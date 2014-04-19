package pages.blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Block(@FindBy(xpath = "//div[@id='categories-block-wrapper']"))
public class CategoryBlock extends HtmlElement {
    private final String categoriesTableXpath = "//table[@class='ev-grid categories']";
    private final String firstCategoryRowInTableXpath = "(//div[@id='categories-block-wrapper']//table[@class='ev-grid categories']/tbody/tr)[1]";

    @FindBy(xpath = firstCategoryRowInTableXpath)
    private WebElement firstCategoryRowInTable;

    public String getCreatedCategoryName() {
        WebElement createdCategory = firstCategoryRowInTable.findElement(By.xpath(".//b[@class='category-name']"));
        return createdCategory.getText();
    }

}
