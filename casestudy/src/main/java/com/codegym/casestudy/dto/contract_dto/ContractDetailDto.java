package com.codegym.casestudy.dto.contract_dto;

import com.codegym.casestudy.model.contract.AttachService;
import com.codegym.casestudy.model.contract.Contract;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class ContractDetailDto {
    private Integer contractDetailId;
    @NotNull(message = "Số lượng không được để trống.")
    @Min(value = 1, message = "Số lượng phải là số dương.")
    private Integer quantity;

    private Contract contract;

    private AttachService attachService;

}
