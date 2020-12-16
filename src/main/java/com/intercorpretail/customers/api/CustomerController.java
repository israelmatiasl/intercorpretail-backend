package com.intercorpretail.customers.api;

import com.intercorpretail.customers.core.dtos.CustomerDto;
import com.intercorpretail.customers.core.dtos.KpiDto;
import com.intercorpretail.customers.core.response.WrapperResponse;
import com.intercorpretail.customers.core.services.ICustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    public WrapperResponse<CustomerDto> getCustomers() {
        return new WrapperResponse<>(customerService.getCustomers());
    }

    @PostMapping()
    public WrapperResponse<CustomerDto> saveCustomer(@RequestBody  CustomerDto customerDto) {
        return new WrapperResponse<>(customerService.saveCustomer(customerDto));
    }

    @GetMapping("kpi")
    public WrapperResponse<KpiDto> getKpi() {
        return new WrapperResponse<>(customerService.getKpi());
    }
}
