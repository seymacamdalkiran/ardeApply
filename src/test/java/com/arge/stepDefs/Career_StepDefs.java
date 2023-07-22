package com.arge.stepDefs;

import com.arge.pages.CareerPage;
import com.arge.utilities.BrowserUtils;
import com.arge.utilities.ConfigurationReader;
import com.arge.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;

public class Career_StepDefs {

    CareerPage careerPage=new CareerPage();
    static String jobName;
    @Given("The user should be on the ar-ge page")
    public void the_user_should_be_on_the_ar_ge_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @Then("Validate the correct page")
    public void validate_the_correct_page() {
        String actualUrl = Driver.get().getCurrentUrl();
        String expectedUrl = ConfigurationReader.get("url");
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    @When("The user choose the {string} menu")
    public void the_user_choose_the_menu(String menu) {
        careerPage.chooseArgeMenu(menu);
    }

    @Then("Validate the correct menu")
    public void validate_the_correct_menu() {
        Assert.assertTrue(careerPage.openPositions.isDisplayed());
    }

    @Then("The user should choose {string} job")
    public void the_user_should_choose_job(String job) {
        jobName=job;
        careerPage.chooseJob(job);
    }

    @Then("The user should apply for job")
    public void the_user_should_apply_for_job() {
        careerPage.applyJob(jobName);
        careerPage.apply.click();
    }

    @Then("The user should fill the apply for this position list with {string}, {string}, {string}, {string}")
    public void the_user_should_fill_the_apply_for_this_position_list_with(String firstName, String lastName, String email, String telephone) {
        careerPage.fillTheApplicationList(firstName, lastName, email, telephone);
    }

    @Then("The user should add the github url {string}")
    public void the_user_should_add_the_github_url(String github) {
        careerPage.cvURL.sendKeys(github);
    }

    @Then("The user should add the linkedin profile url {string}")
    public void the_user_should_add_the_linkedin_profile_url(String linkedin) {
        careerPage.linkedin.sendKeys(linkedin);
    }

    @Then("The user should write description {string}")
    public void the_user_should_write_description(String description) {
        careerPage.description.sendKeys(description);
    }

    @Then("The user should submit application")
    public void the_user_should_submit_application() {
        careerPage.send.click();
    }

    @Then("The user should see {string} message")
    public void the_user_should_see_message(String message) {
        Assert.assertEquals(careerPage.verification.getText(),message);
       }
}