package com.intercorpretail.customers.core.services.implementations;

import com.intercorpretail.customers.core.dtos.CustomerDto;
import com.intercorpretail.customers.core.dtos.KpiDto;
import com.intercorpretail.customers.core.entities.Customer;
import com.intercorpretail.customers.core.repositories.CustomerRepository;
import com.intercorpretail.customers.core.services.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ICustomerServiceImpl implements ICustomerService {

    final CustomerRepository customerRepository;

    public ICustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerRepository.save(customer);

        return customerDto;
    }

    @Override
    public List<CustomerDto> getCustomers() {
        return this.customerRepository.findAll().stream()
                .map(customer -> new CustomerDto(customer.getId(),
                        customer.getName(),
                        customer.getSurname(),
                        customer.getAge(),
                        customer.getBirthdate(),
                        customer.getDeathdate())
                ).collect(Collectors.toList());
    }

    @Override
    public KpiDto getKpi() {
        List<Integer> customersAges = customerRepository.findAll().stream().map(Customer::getAge).collect(Collectors.toList());
        double average = getAverage(customersAges);
        double standardDerivation = getStandardDerivation(customersAges, average);

        return new KpiDto(average, standardDerivation);
    }

    private double getAverage(List<Integer> ages) {
        Integer sumTerms = ages.stream().mapToInt(Integer::intValue).sum();
        return (double)(sumTerms/ages.size());
    }

    private double getStandardDerivation(List<Integer> ages, double average) {
        List<Double> sumTerms = ages.stream().map(age -> Math.pow((age-average), 2)).collect(Collectors.toList());
        Double sumAllTerms = sumTerms.stream().mapToDouble(Double::doubleValue).sum();

        return Math.sqrt((sumAllTerms/(ages.size() - 1)));
    }
}
