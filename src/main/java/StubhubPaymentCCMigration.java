import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

import java.util.concurrent.TimeUnit;

import scala.concurrent.duration.Duration;

/**
 * Created by anujacharya on 7/3/16.
 */
public class StubhubPaymentCCMigration {
//    public static class WhoToSendToken implements Serializable {
//        // payment provider
//        public final String paymentProvider;
//
//        public WhoToSendToken(String paymentProvider) {
//            this.paymentProvider = paymentProvider;
//        }
//    }

//    public static class Token implements Serializable {
//        public final String token;
//        public Token(String token) {
//            this.token = token;
//        }
//    }


    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("POCPaymentDataMigration");
        final ActorRef paymetricActor =
                system.actorOf(Props.create(PaymetricActor.class),
                        "paymetricActor");

        //call db and get the tokens

        //send paymetricActor the message the tokens
        // put the message on fire-forget
        // actor will react to tokens
        // everything is async


        //Schedules to send the "foo"-message to the testActor after 50ms


        system.scheduler().scheduleOnce(Duration.create(3, TimeUnit.SECONDS),
                new Runnable() {
                    @Override
                    public void run() {
                        for(int i =0; i<1000000; i++){
                            paymetricActor.tell(new Token("cc_"+i), ActorRef.noSender());
                        }

                    }
                }, system.dispatcher());


        // 50M messages/second for 8 cores



    }
}