package pages.blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Block(@FindBy(xpath = "//div[@id='page-content' and //table[@id='grid']]"))
public class ProductsBlock extends HtmlElement {
    private final String productsTableXpath = ".//table[@id='grid']";

    @FindBy(xpath = productsTableXpath)
    private WebElement productsTable;

    public String getCreatedProductName() {
        WebElement td = productsTable.findElement(By.xpath("./tbody/tr[1]/td[2]"));
        return td.getText();
    }

}
