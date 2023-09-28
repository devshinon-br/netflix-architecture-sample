package iftm.logpool.messages;

import iftm.logpool.models.dto.LogDTO;
import iftm.logpool.services.LogService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqReadLog {

    @Autowired
    private LogService logService;

    @RabbitListener(queues = "${softwareHouse.rabbitmq.queue}")
    public void receiveLog(@Payload final LogDTO logDTO) {
        if (logDTO != null) logService.save(logDTO);
    }
}