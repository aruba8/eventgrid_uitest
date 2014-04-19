package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.blocks.CategoriesCreationWindow;
import pages.blocks.CategoryBlock;
import pages.blocks.ProductCreationBlock;
import pages.blocks.ProductsBlock;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

public class MainPage {
    private CategoriesCreationWindow categoriesCreationWindow;
    private CategoryBlock categoryBlock;
    private ProductCreationBlock productCreationBlock;
    private ProductsBlock productsBlock;

    private final String storeXpath = "//li/a[.//span[contains(text(), 'Store')]]";
    private final String productsXpath = "//li/ul[@class='submenu']/li/a[contains(text(), 'Products')]";
    private final String categoriesXpath = "//li/ul[@class='submenu']/li/a[contains(text(), 'Categories')]";
    private final String addCategoryButtonXpath = "//button[text()='ADD CATEGORY']";
    private final String addProductButtonXpath = "//a[text()='Add Product']";


    public MainPage(WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(driver), this);
    }

    @FindBy(xpath = addProductButtonXpath)
    private WebElement addProductButton;

    @FindBy(xpath = addCategoryButtonXpath)
    private WebElement addCategoryButton;

    @FindBy(xpath = storeXpath)
    private WebElement store;

    @FindBy(xpath = productsXpath)
    private WebElement products;

    @FindBy(xpath = categoriesXpath)
    private WebElement categories;

    public void goToAddCategory() {
        store.click();
        categories.click();
    }

    public void addCategory(String categoryName) {
        addCategoryButton.click();
        categoriesCreationWindow.typeCategoryName(categoryName);
    }

    public void addSubCategory(String subCategoryName) {
        categoriesCreationWindow.addSubCategory(subCategoryName);
    }

    public void createCategory() {
        categoriesCreationWindow.confirmCreateCategory();
    }

    public String getFirstCreatedCategoryName() {
        return categoryBlock.getCreatedCategoryName();
    }

    public void openProducts() {
        products.click();
    }

    public void openAddProductForm() {
        addProductButton.click();
    }

    public void fillProductCreationForm(String productName, String shortDescription, String price, String sku, String imgPath) {
        productCreationBlock.setImageAddInput(imgPath);
        productCreationBlock.setToProductNameInput(productName);
        productCreationBlock.setToShortDescription(shortDescription);
        productCreationBlock.setToPriceInput(price);
        productCreationBlock.setToSkuInput(sku);
        productCreationBlock.setCategory();
    }

    public void saveProduct() {
        productCreationBlock.saveProduct();
    }

    public String getCreatedProductName() {
        return productsBlock.getCreatedProductName();
    }


}
