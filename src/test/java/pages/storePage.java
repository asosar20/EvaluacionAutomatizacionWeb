package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class storePage {

    private WebDriver driver;
    private WebDriverWait wait;
    public storePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
    }

    private By btnIniciarSesion = By.xpath("//div[@class='user-info']//span[contains(text(),'Iniciar sesión')]");
    private By lnkCrearCuenta = By.xpath("//div[@class='no-account']//a[contains(text(),'¿No tiene una cuenta? Cree una aquí')]");
    private By radioSr = By.id("field-id_gender-1");
    private By txtNombre = By.id("field-firstname");
    private By txtApellido = By.id("field-lastname");
    private By txtEmail = By.id("field-email");
    private By txtPassword = By.id("field-password");
    private By txtBirthday = By.id("field-birthday");
    private By chkOfertas = By.name("optin");
    private By chkTerms = By.name("psgdpr");
    private By chkNewsletter = By.name("newsletter");
    private By chkCustomerPrivacy = By.name("customer_privacy");

    private By btnGuardar = By.xpath("//button[@data-link-action='save-customer']");

    private By lblUsuarioLogueado = By.cssSelector(".user-info .account .hidden-sm-down");

    public void clickIniciarSesion() {
        wait.until(ExpectedConditions.elementToBeClickable(btnIniciarSesion)).click();
    }

    public void clickCrearCuenta() {
        wait.until(ExpectedConditions.elementToBeClickable(lnkCrearCuenta)).click();
    }

    public void llenarFormularioRegistro() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtNombre));

        driver.findElement(radioSr).click();
        driver.findElement(txtNombre).sendKeys("Francisco Alexander");
        driver.findElement(txtApellido).sendKeys("Sosa Ruiz");

        String emailUnico = "fasr_" + System.currentTimeMillis() + "@qalab.com";
        driver.findElement(txtEmail).sendKeys(emailUnico);

        driver.findElement(txtPassword).sendKeys("PassFASR2211@");
        driver.findElement(txtBirthday).sendKeys("20/05/1997");
        driver.findElement(chkOfertas).click();
        driver.findElement(chkTerms).click();
        driver.findElement(chkNewsletter).click();
        driver.findElement(chkCustomerPrivacy).click();
    }

    public void clickGuardar() {
        driver.findElement(btnGuardar).click();
    }

    public String obtenerTitulo() {
        return driver.getTitle();
    }

    public String obtenerNombreUsuario() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(lblUsuarioLogueado)).getText();
    }

}
