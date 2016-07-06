import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * Created by anujacharya on 7/3/16.
 */
public class BTActor extends UntypedActor {
    // Every Paymetric in its own thread
    // 2.7 M / GB of RAM
    LoggingAdapter LOG = Logging.getLogger(getContext().system(), this);

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof Token) {
            LOG.info("Vault in BT"+((Token) message).ccPanToken);
        }
    }
}

