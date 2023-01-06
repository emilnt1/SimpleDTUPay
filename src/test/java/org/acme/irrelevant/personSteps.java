package org.acme.irrelevant;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.acme.irrelevant.Person;

import static org.junit.Assert.assertEquals;

public class personSteps {


    Person person = new Person();

    @Given("A person with no name and address")
    public void aPersonWithNoNameAndAddress() {
        person.setName("");
        person.setAddress("");
    }

    @When("I change the persons name and address to {string} and {string}")
    public void iChangeThePersonsNameAndAddressToAnd(String arg0, String arg1) {
        person.setName(arg0);
        person.setAddress(arg1);
    }

    @Then("The name and address of the person is {string} and {string}")
    public void theNameAndAddressOfThePersonIsAnd(String arg0, String arg1) {
        assertEquals(arg0, person.getName());
        assertEquals(arg1, person.getAddress());
    }



}
