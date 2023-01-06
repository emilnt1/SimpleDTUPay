package org.acme;

import lombok.Data;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Data
public class Database {
    Customer[] customers = new Customer[10];
    Merchant[] merchants = new Merchant[10];
    List<Payment> payments = new ArrayList<Payment>();

    public Database() {
        for (int i = 0; i < 10; i++) {
            customers[i] = new Customer();
            customers[i].setCid(i);
            customers[i].setStakater(1000);
            merchants[i] = new Merchant();
            merchants[i].setMid(i);
            merchants[i].setDimmadollars(1000);
        }
    }
}
