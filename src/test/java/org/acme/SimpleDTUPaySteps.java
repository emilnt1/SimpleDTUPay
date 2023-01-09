package org.acme;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;

public class SimpleDTUPaySteps {
    int cid, mid;
    PayResource dtuPay = new PayResource();
    List<Payment> payments = new ArrayList<>();
    boolean successful;
    String errormessage;

    @Given("a customer with id {int}")
    public void aCustomerWithId(int cid) {
        this.cid = cid;
    }
    @Given("a merchant with id {int}")
    public void aMerchantWithId(int mid) {
        this.mid = mid;
    }
    @When("the merchant initiates a payment for {int} kr by the customer")
    public void theMerchantInitiatesAPaymentForKrByTheCustomer(int amount) throws Exception {
        try {
            successful = dtuPay.makePayment(cid, mid, amount);
        } catch (Exception e) {
            errormessage = e.getMessage();
        }
    }
    @Then("the payment is successful")
    public void thePaymentIsSuccessful() {
        assertTrue(successful);
    }



    @Given("a successful payment of {int} kr from customer {int} to merchant {int}")
    public void aSuccessfulPaymentOfKrFromCustomerToMerchant(int payment, int customerId, int merchantId) throws Exception {
        dtuPay.makePayment(customerId, merchantId, payment);
    }
    @When("the manager asks for a list of payments")
    public void theManagerAsksForAListOfPayments() {
        payments.addAll(dtuPay.getPayments());
    }
    @Then("the list contains a payments where customer {int} paid {int} kr to merchant {int}")
    public void theListContainsAPaymentsWhereCustomerPaidKrToMerchant(int customerId, int payment, int merchantId) {
        for (Payment p : payments) {
            if (p.getCustomerId() == customerId && p.getMerchantId() == merchantId && p.getPaymentAmount() == payment) {
                assertTrue(true);
                return;
            }
        }

        fail();
    }

    @Then("the payment is not successful")
    public void thePaymentIsNotSuccessful() {
        assertFalse(successful);
    }

    @And("an error message is returned saying {string}")
    public void anErrorMessageIsReturnedSaying(String errormessage) {
        assertEquals(errormessage, this.errormessage);
    }


    @Given("a customer with a bank account with balance {int}")
    public void aCustomerWithABankAccountWithBalance(int arg0) {
    }

    @And("that the customer is registered with DTU Pay")
    public void thatTheCustomerIsRegisteredWithDTUPay() {
    }

    @Given("a merchant with a bank account with balance {int}")
    public void aMerchantWithABankAccountWithBalance(int arg0) {
    }

    @And("that the merchant is registered with DTU Pay")
    public void thatTheMerchantIsRegisteredWithDTUPay() {
    }

    @And("the balance of the customer at the bank is {int} kr")
    public void theBalanceOfTheCustomerAtTheBankIsKr(int arg0) {
    }

    @And("the balance of the merchant at the bank is {int} kr")
    public void theBalanceOfTheMerchantAtTheBankIsKr(int arg0) {
    }
}

