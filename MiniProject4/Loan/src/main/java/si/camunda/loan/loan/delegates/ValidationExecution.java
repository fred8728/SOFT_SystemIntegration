package si.camunda.loan.loan.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import si.camunda.loan.loan.model.ApplicantInfo;
import si.camunda.loan.loan.service.StartService;

import javax.inject.Inject;

public class ValidationExecution implements JavaDelegate {

    Logger LOGGER = LoggerFactory.getLogger(ValidationExecution.class);

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        execution.setVariable("validationvar", "value");
        LOGGER.info("Executed validation service");
    }
}
