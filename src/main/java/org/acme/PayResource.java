package org.acme;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Getter
@Setter
@Path("/api")
public class PayResource {
    static Database database = new Database();

    @GET
    @Path("/customer/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomer(@PathParam("id")int id) {
        return database.customers[id];

    }

    @GET
    @Path("/merchant/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Merchant getMerchant(@PathParam("id") int id) {
        return database.merchants[id];
    }

    @POST
    @Path("/payment/{customerId}/{merchantId}/{amount}")
    @Produces(MediaType.TEXT_PLAIN)
        public Boolean makePayment(@PathParam("customerId") int customerId, @PathParam("merchantId") int merchantId, @PathParam("amount") int amount) throws Exception {
        try {
            database.customers[customerId].setStakater(database.customers[customerId].getStakater() - amount);
        } catch (Exception e) {
            throw new Exception("customer with id " + customerId + " is unknown");
        }
        try {
            database.merchants[merchantId].setDimmadollars(database.merchants[merchantId].getDimmadollars() + amount);
        } catch (Exception e){
            throw new Exception("merchant with id " + merchantId + " is unknown");
        }
        database.payments.add(new Payment(customerId, merchantId, amount));
        return true;
    }

    @GET
    @Path("/payment/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Payment> getPayments(){
        return database.getPayments();
    }


}
