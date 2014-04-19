package pages.blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Block(@FindBy(xpath = "//div[@id='category_dialog']"))
public class CategoriesCreationWindow extends HtmlElement {
    private final String categoryNameInputXpath = ".//input[@id='Name']";
    private final String addSubCategoryLinkXpath = ".//a[text()='+ Add Subcategory']";
    private final String lastSubCategoryInputXpath = "(//div[@id='sub-categories']/div)[last()]/input[@type='text']";
    private final String doneButtonXpath = "./form[@id='category-form']//button[text()='Done']";

    @FindBy(xpath = doneButtonXpath)
    private WebElement doneButton;

    @FindBy(xpath = lastSubCategoryInputXpath)
    private WebElement lastSubCategoryInput;

    @FindBy(xpath = categoryNameInputXpath)
    private WebElement categoryNameInput;

    @FindBy(xpath = addSubCategoryLinkXpath)
    private WebElement addSubcategoryLink;

    public void typeCategoryName(String categoryName) {
        categoryNameInput.sendKeys(categoryName);
    }

    public void addSubCategory(String subCategoryName) {
        addSubcategoryLink.click();
        lastSubCategoryInput.sendKeys(subCategoryName);
    }

    public void confirmCreateCategory() {
        doneButton.click();
    }

}
