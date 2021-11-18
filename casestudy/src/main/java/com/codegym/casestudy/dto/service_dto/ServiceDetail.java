package com.codegym.casestudy.dto.service_dto;

public interface ServiceDetail {
    Integer getServiceId();
    String getServiceName();
    String getCustomerName();
    Integer getContractId();
    String getContractStartDate();
    String getContractEndDate();
    Integer getContractDetailId();
    String getAttachServiceName();
    Integer getQuantity();
    Double getTotal();
}
