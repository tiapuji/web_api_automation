package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.example.pages.LoginPage;

public class LoginSteps {

    LoginPage login = new LoginPage(Hooks.driver);

    @Given("pengguna membuka halaman login")
    public void bukaLogin() {
        login.open();
    }

    @When("pengguna memasukkan username {string}")
    public void username(String user) {
        login.inputUsername(user);
    }

    @And("pengguna memasukkan password {string}")
    public void password(String pass) {
        login.inputPassword(pass);
    }

    @And("pengguna menekan tombol login")
    public void klikLogin() {
        login.clickLogin();
    }

    @Then("login berhasil")
    public void loginBerhasil() {
        String message = login.getMessage();
        System.out.println("Pesan Login Berhasil: " + message);
        Assert.assertTrue(message.contains("You logged into a secure area!"));
    }

    @Then("muncul pesan login gagal")
    public void loginGagal() {
        String message = login.getMessage();
        System.out.println("Pesan Login Gagal: " + message);
        Assert.assertTrue(message.contains("Your username is invalid"));
    }
}