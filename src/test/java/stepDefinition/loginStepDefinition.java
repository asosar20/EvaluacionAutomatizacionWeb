package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.storePage;
import utility.BrowserDriver;

public class loginStepDefinition {

    private WebDriver driver;
    private storePage storePage;
    public loginStepDefinition() {
        this.driver = BrowserDriver.getDriver();
        this.storePage = new storePage(driver);
    }


    @Given("estoy en la página de la tienda")
    public void estoy_en_la_pagina_de_la_tienda() {
        String tituloEsperado = "My Store";
        String tituloActual = storePage.obtenerTitulo();
        Assert.assertEquals("El título de la página no coincide.", tituloEsperado, tituloActual);
    }

    @When("doy click en la opción iniciar sesión")
    public void doy_click_en_la_opcion_iniciar_sesion() {
        storePage.clickIniciarSesion();
    }

    @When("doy click en el link text cree una cuenta aquí")
    public void doy_click_en_el_link_text_cree_una_cuenta_aqui() {
        storePage.clickCrearCuenta();
    }

    @When("lleno los campos del formulario para el registro")
    public void lleno_los_campos_del_formulario_para_el_registro() {
        storePage.llenarFormularioRegistro();
    }

    @When("doy click en el botón guardar")
    public void doy_click_en_el_boton_guardar() {
        storePage.clickGuardar();
    }

    @Then("debería visualizar mi usuario logeado en la pantalla")
    public void deberia_visualizar_mi_usuario_logeado_en_la_pantalla() {
        String nombreUsuario = storePage.obtenerNombreUsuario();
        Assert.assertTrue("El usuario no está logueado", nombreUsuario.contains("Francisco Alexander"));
    }


}
