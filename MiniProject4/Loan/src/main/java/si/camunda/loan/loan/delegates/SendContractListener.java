package si.camunda.loan.loan.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendContractListener implements ExecutionListener {
    Logger LOGGER = LoggerFactory.getLogger(SendContractListener.class);
    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {
        LOGGER.info("SendContractListener executed");
    }
}
