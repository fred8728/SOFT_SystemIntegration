package si.camunda.loan.loan.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidationListener implements ExecutionListener {

    Logger LOGGER = LoggerFactory.getLogger(ValidationListener.class);

    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {
        LOGGER.info("ValidationListener is executed");
    }
}
