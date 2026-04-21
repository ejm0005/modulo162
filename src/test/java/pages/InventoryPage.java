package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private WebDriver driver;

    // Locadores dinámicos y fijos
    private By carritoBadge = By.className("shopping_cart_badge");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void añadirProducto(String nombreProducto) {
        // Formateamos el ID basándonos en el nombre (ej: "Sauce Labs Backpack" -> "add-to-cart-sauce-labs-backpack")
        String idProducto = "add-to-cart-" + nombreProducto.toLowerCase().replace(" ", "-");
        driver.findElement(By.id(idProducto)).click();
    }

    public String obtenerContadorCarrito() {
        return driver.findElement(carritoBadge).getText();
    }

    public String obtenerTextoBoton(String nombreProducto) {
        String idBoton = "remove-" + nombreProducto.toLowerCase().replace(" ", "-");
        return driver.findElement(By.id(idBoton)).getText();
    }
}
