package kernel360.ckt.admin.application.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import kernel360.ckt.admin.application.service.command.CreateVehicleCommand;
import kernel360.ckt.admin.application.service.command.VehicleKeywordCommand;
import kernel360.ckt.admin.application.service.command.UpdateVehicleCommand;
import kernel360.ckt.admin.infra.jpa.RentalJpaRepository;
import kernel360.ckt.core.common.error.VehicleErrorCode;
import kernel360.ckt.core.common.exception.CustomException;
import kernel360.ckt.core.domain.entity.VehicleEntity;
import kernel360.ckt.core.domain.enums.VehicleStatus;
import kernel360.ckt.admin.application.port.RentalRepository;
import kernel360.ckt.admin.application.port.VehicleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class VehicleService {
    private final VehicleRepository vehicleRepository;
    private final RentalRepository rentalRepository;
    private final RentalJpaRepository rentalJpaRepository;
    private final ObjectMapper objectMapper;

    public VehicleEntity create(CreateVehicleCommand command) {
        log.info("차량 등록 번호 중복 검사 - 차량 번호: {}", command.getRegistrationNumber());
        vehicleRepository.findByRegistrationNumber(command.getRegistrationNumber())
            .ifPresent(vehicle -> {
                throw new CustomException(VehicleErrorCode.DUPLICATE_REGISTRATION_NUMBER);
            });

        final VehicleEntity vehicle = command.toEntity(); // entity 생성
        final VehicleEntity savedVehicle = vehicleRepository.save(vehicle); // 저장

        log.info("차량 등록 완료 - ID: {}", savedVehicle.getId());
        return savedVehicle;
    }

    @Transactional
    public VehicleEntity update(Long id, UpdateVehicleCommand command) {
        VehicleEntity vehicle = vehicleRepository.findById(id)
            .orElseThrow(() -> new CustomException(VehicleErrorCode.VEHICLE_NOT_FOUND));

        log.info("차량 수정 진행 - ID: {}, modelYear: {}, manufacturer: {}, modelName: {}, batteryVoltage: {}, fuelType: {}, transmissionType: {}, memo: {}",
            id,
            command.getModelYear(),
            command.getManufacturer(),
            command.getModelName(),
            command.getBatteryVoltage(),
            command.getFuelType(),
            command.getTransmissionType(),
            command.getMemo()
        );

        vehicle.updateVehicle(
            command.getModelYear(),
            command.getManufacturer(),
            command.getModelName(),
            command.getBatteryVoltage(),
            command.getFuelType(),
            command.getTransmissionType(),
            command.getMemo()
        );

        final VehicleEntity savedVehicle = vehicleRepository.save(vehicle);
        log.info("차량 수정 완료: {}", vehicle);
        return savedVehicle;
    }

    public Page<VehicleEntity> searchVehicles(VehicleStatus status, String keyword, Pageable pageable) {
        log.info("차량 목록 조회 실행 - status: {}, keyword: {}, pageable: {}", status, keyword, pageable);
        Page<VehicleEntity> result = vehicleRepository.findAll(status, keyword, pageable);

        log.info("차량 검색 결과 - 총 {}건", result.getTotalElements());
        return result;
    }

    public VehicleEntity findById(Long vehicleId) {
        log.info("차량 아이디 존재 검사 - vehicleId: {}", vehicleId);

        VehicleEntity vehicle = vehicleRepository.findById(vehicleId)
            .orElseThrow(() -> new CustomException(VehicleErrorCode.VEHICLE_NOT_FOUND));

        log.info("차량 아이디 존재함 - vehicleId: {}", vehicleId);
        return vehicle;
    }

    public void delete(Long vehicleId) {
        log.info("차량 삭제 시도 - vehicleId: {}", vehicleId);
        findById(vehicleId);
        vehicleRepository.deleteById(vehicleId);
        log.info("차량 삭제 성공 - vehicleId: {}", vehicleId);
    }

    public List<VehicleEntity> searchKeyword(VehicleKeywordCommand command) {
        return vehicleRepository.searchAvailableVehiclesByKeyword(command.getKeyword(), command.getPickupAt(), command.getReturnAt());
    }

}
