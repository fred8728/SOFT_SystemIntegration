package si.bank.bankconsumer.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import si.bank.bankconsumer.config.MQConfig;
import si.bank.bankconsumer.model.Loan;

@Component
public class MessageListener {

    @RabbitListener(queues = MQConfig.QUEUE)
    public void listener (Loan loan){
        System.out.println(loan);
    }
}
