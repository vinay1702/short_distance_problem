package org.problem;

import java.util.Comparator;

public class CustomerComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer cus1, Customer cus2) {
        return (cus1.getUser_id() < cus2.getUser_id()) ? -1 : 1;
    }
}