package pages.blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Block(@FindBy(xpath = "//div[.//form[@action='/Product/Create'] and @id='page-content']"))
public class ProductCreationBlock extends HtmlElement {

    private final String productNameInputXpath = ".//input[@id='Name']";
    private final String productDescriptionTextAreaXpath = ".//textarea[@id='Description']";
    private final String categorySelectorXpath = ".//div[@class='category-selector']";
    private final String priceInputXpath = ".//input[@id='Variants_Items_0__PriceViewModel_PriceString']";
    private final String skuInputXpath = ".//input[@id='Variants_Items_0__SKU']";
    private final String imageAddInputXpath = ".//input[@id='add-img-btn']";
    private final String saveProductButtonXpath = ".//button[text()='Save Product']";

    @FindBy(xpath = saveProductButtonXpath)
    private WebElement saveProductButton;

    @FindBy(xpath = productNameInputXpath)
    private WebElement productNameInput;

    @FindBy(xpath = productDescriptionTextAreaXpath)
    private WebElement productDescriptionTextArea;

    @FindBy(xpath = categorySelectorXpath)
    private WebElement categorySelector;

    @FindBy(xpath = priceInputXpath)
    private WebElement priceInput;

    @FindBy(xpath = skuInputXpath)
    private WebElement skuInput;

    @FindBy(xpath = imageAddInputXpath)
    private WebElement imageAddInput;

    public void setToProductNameInput(String productName) {
        productNameInput.sendKeys(productName);
    }

    public void setToShortDescription(String productDescription) {
        productDescriptionTextArea.sendKeys(productDescription);
    }

    public void setToPriceInput(String price) {
        priceInput.sendKeys(price);
    }

    public void setToSkuInput(String sku) {
        skuInput.sendKeys(sku);
    }

    public void setImageAddInput(String imagePath) {
        imageAddInput.sendKeys(imagePath);
    }

    public void saveProduct() {
        saveProductButton.click();
        saveProductButton.click();
    }

    public void openCategorySelector() {
        categorySelector.click();
    }

    public void setCategory() {
        openCategorySelector();
        WebElement category = categorySelector.findElement(By.xpath(".//ul[@class='categories']/li/input"));
        category.click();
    }

}
