package whtask;

import connector.Utilities;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dao.User;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Stepdefs {

    private static User[] users;

    @Given("^there is default data in database$")
    public void useDefaultData() {
        users = new User[]{};
        // Some clever way to reset test data
    }

    @When("^I get list of users$")
    public void getUsers() {
        users = new Utilities().getAllUsers();
    }

    @When("^I add new user with parameters$")
    public void addUser(DataTable table) {
        List<List<String>> data = table.raw();
        int id = Integer.parseInt(data.get(1).get(0));
        String name = data.get(1).get(1);
        double balance = Double.parseDouble(data.get(1).get(2));
        String currency = data.get(1).get(3);
        String preferences = data.get(1).get(4);
        boolean isHighRoller = Boolean.parseBoolean(data.get(1).get(5));

        new Utilities().createNewUser(new User(id, name, balance, currency, preferences, isHighRoller));
    }

    @When("^I update balance of user with id 4 by 20000$")
    public void moreMoneyForBrian() {
        Utilities utilities = new Utilities();
        User brian = utilities.getUserById(4);
        brian.setBalance(brian.getBalance() + 20000);
        utilities.updateUser(4, brian);
    }

    @Then("^all of them have their balances in GBP$")
    public void checkBalanceCurrency() {
        assertTrue("All currency codes are GBP", checkCurrency(users));
    }

    @Then("^balance of user with id ó is converted to GBP$")
    public void checkCurrencyOfNewUser() {
        User user = new Utilities().getUserById(200);
        assertEquals("Currency of new user is GBP", "GBP", user.getActiveCurrency());
    }

    @Then("^one of them is marked as High-Roller$")
    public void checkHighRollerExistence() {
        int numberOfHighrollers = 0;
        for (User user : users) {
            if (user.getHighRoller()) {
                numberOfHighrollers++;
            }
        }
        Assert.assertEquals("There is one High-Roller", 1, numberOfHighrollers);
    }

    @Then("^user with ID 100 is marked as High-Roller$")
    public void checkIfUsersIsHighRoller() {
        Assert.assertTrue("Newly added user is High-Roller", new Utilities().getUserById(100).getHighRoller());
    }

    @Then("^high-roller has the highest balance$")
    public void checkBalance() {
        Arrays.sort(users, (first, second) -> Double.compare(second.getBalance(), first.getBalance()));
        Assert.assertTrue("The first entry in sorted users table is High-Roller", users[0].getHighRoller());
    }

    @Then("^user of id 4 have more money$")
    public void checkNewBalance() {
        double briansBalance = new Utilities().getUserByName("Brian")[0].getBalance();
        assertEquals("Brian should have 20008.0 GBP", 20008, new Utilities().getUserById(4).getBalance(), 0);
    }

    @Then("^customer with parameters is present$")
    public void checkIfCustomerExists(DataTable table) {
        List<List<String>> data = table.raw();
        String name = data.get(1).get(0);
        double balance = Double.parseDouble(data.get(1).get(1));
        String currency = data.get(1).get(2);
        String preferences = data.get(1).get(3);

        User james = new Utilities().getUserByName(name)[0];
            assertEquals("James has 20 GBP", balance, james.getBalance(), 0);
            assertEquals("James has uses GBP", currency, james.getActiveCurrency());
            assertEquals("James likes Bingo", preferences, james.getPreferences());
    }

    private boolean checkCurrency(User[] users) {
        for (User user : users) {
            if (!user.getActiveCurrency().equals("GPB")) {
                return false;
            }
        }
        return true;
    }
}