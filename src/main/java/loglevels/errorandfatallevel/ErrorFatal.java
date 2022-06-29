package loglevels.errorandfatallevel;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import loglevels.Task;

public class ErrorFatal {
    private static final Logger logger = LoggerFactory.getLogger(ErrorFatal.class);

    public boolean processTask(Task task) {
        logger.debug("processTask id = " + task.getId());
        try {
            task.start();
            task.progress();
            task.complete();
            return true;
        } catch (Exception e) {
            logger.error("Unknown error", e);
            return false;
        }
    }
}
