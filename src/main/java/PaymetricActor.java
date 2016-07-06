import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * Created by anujacharya on 7/3/16.
 */
public class PaymetricActor extends UntypedActor {
    // Every Paymetric in its own thread
    // 2.7 M / GB of RAM
    LoggingAdapter LOG = Logging.getLogger(getContext().system(), this);

    final ActorRef child =
            getContext().actorOf(Props.create(BTActor.class), "btActor");

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof Token) {
            Token paymetricToken = (Token) message;
            LOG.info("DeTokenize " + paymetricToken.ccPanToken);

            //10 seconds
//            Thread.sleep(10000);

            LOG.info("Complete Paymetric to de-tokenize");




            child.tell(new Token("btToken_"+paymetricToken.ccPanToken), ActorRef.noSender());
            //reply to sender
//                getSender().tell("Processing "+paymetricToken.ccPanToken, getSelf());
        }
    }
}
