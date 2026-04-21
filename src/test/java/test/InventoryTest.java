package test;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.InventoryPage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {
    WebDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    void anadirUnProductoAlCarrito() {
        inventoryPage.añadirProducto("Sauce Labs Backpack");
        assertEquals("1", inventoryPage.obtenerContadorCarrito());
    }

    @Test
    void anadirDosProductosAlCarrito() {
        inventoryPage.añadirProducto("Sauce Labs Backpack");
        inventoryPage.añadirProducto("Sauce Labs Bike Light");
        assertEquals("2", inventoryPage.obtenerContadorCarrito());
    }

    @Test
    void botonCambiaTrasAnadirProducto() {
        String producto = "Sauce Labs Backpack";
        inventoryPage.añadirProducto(producto);
        assertEquals("Remove", inventoryPage.obtenerTextoBoton(producto));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
