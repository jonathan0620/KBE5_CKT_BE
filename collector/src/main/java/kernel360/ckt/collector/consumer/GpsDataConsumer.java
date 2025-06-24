package kernel360.ckt.collector.consumer;

import kernel360.ckt.collector.application.service.VehicleCollectorService;
import kernel360.ckt.collector.config.RabbitConfig;
import kernel360.ckt.collector.ui.dto.request.VehicleCollectorCycleRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class GpsDataConsumer {

    private final VehicleCollectorService vehicleCollectorService;
    private final ObjectMapper objectMapper;

    @RabbitListener(queues = RabbitConfig.GPS_QUEUE)
    public void receiveGpsData(String message) {
        try {
            log.info("MQ 수신: {}", message);
            VehicleCollectorCycleRequest request = objectMapper.readValue(message, VehicleCollectorCycleRequest.class);
            vehicleCollectorService.saveVehicleCycle(request.toCommand());
        } catch (Exception e) {
            log.error("MQ 처리 실패: {}", message, e);
        }
    }
}
