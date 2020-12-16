package com.intercorpretail.customers.core.services;

import com.intercorpretail.customers.core.dtos.CustomerDto;
import com.intercorpretail.customers.core.dtos.KpiDto;

import java.util.List;

public interface ICustomerService {
    CustomerDto saveCustomer(CustomerDto customerDto);
    List<CustomerDto> getCustomers();
    KpiDto getKpi();
}
