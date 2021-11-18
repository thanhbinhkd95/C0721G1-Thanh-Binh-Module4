package com.codegym.casestudy.dto.contract_dto;



import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Data
public class AttachServiceDto {
    private Integer attachServiceId;
    private String attachServiceName;

    @NotNull(message = "Giá tiền không được để trống.")
    @Min(value = 1, message = "Giá tiền phải là số dương.")
    private Double attachServiceCost;

    @NotNull(message = "Đơn vị không được để trống.")
    @Min(value = 1, message = "Đơn vị phải là số dương.")
    private Integer attachServiceUnit;

    private String attachServiceStatus;


}
