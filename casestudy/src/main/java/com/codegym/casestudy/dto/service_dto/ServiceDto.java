package com.codegym.casestudy.dto.service_dto;

import com.codegym.casestudy.model.service.RentType;
import com.codegym.casestudy.model.service.Service;
import com.codegym.casestudy.model.service.ServiceType;
import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;
@Data
public class ServiceDto implements Validator {

    private Integer serviceId;

    @Pattern(regexp = "^(DV)-[0-9]{4}$",
            message = "Mã Dịch vụ có định dạng là DV-XXXX (X là số 0-9)")
    private String serviceCode;

    @NotBlank
    private String serviceName;

    @Min(value = 0,
            message = "Vui lòng nhập số dương")
    private Double serviceArea;

    @Min(value = 0,
            message = "Vui lòng nhập số dương")
    private Double serviceCost;

    @Min(value = 0,
            message = "Vui lòng nhập số dương")
    private Integer serviceMaxPeople;

    @NotBlank
    private String standardRoom;

    @NotBlank
    private String desciption;

    @Min(value = 0,
            message = "Vui lòng nhập số dương")
    private Double poolArea;

    @Min(value = 0,
            message = "Vui lòng nhập số dương")
    private Integer numberOfFloors;

    private ServiceType serviceType;
    private RentType rentType;

    List<Service> services = new ArrayList<>();

    private boolean checkCode;

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public boolean isCheckCode() {
        return checkCode;
    }

    public void setCheckCode(boolean checkCode) {
        this.checkCode = checkCode;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ServiceDto serviceDto = (ServiceDto) target;
        for (Service service : services) {
            if (serviceDto.checkCode) {
                if (serviceDto.getServiceCode().equals(service.getServiceId())) {
                    errors.rejectValue("serviceCode", "serviceCode.equals", "Mã DV này đã tồn tại.");
                }
            }
        }
    }
}
