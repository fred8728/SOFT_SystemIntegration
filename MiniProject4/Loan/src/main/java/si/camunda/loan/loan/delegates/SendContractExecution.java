package si.camunda.loan.loan.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendContractExecution implements JavaDelegate {
    Logger LOGGER = LoggerFactory.getLogger(SendContractExecution.class);
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        execution.setVariable("confirmationvar", "value");
        execution.setVariable("monthlypayment", execution.getVariable("monthlypayment"));
        LOGGER.info("SendContractExecution is executed");
    }
}
