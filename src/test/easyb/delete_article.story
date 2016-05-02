import main.*

import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver

description 'Kayttaja pystyy poistamaan artikkelin'

scenario "kayttaja pystyy poistamaan artikkelin", {
    given 'käyttäjä on etusivulla', {
       driver = new HtmlUnitDriver();
       driver.get("http://localhost:8080/addtestdata");
       driver.get("http://localhost:8080");
    }

    when 'delete-käsky valitaan', {
       element = driver.findElement(By.linkText("Delete"));
       element.click();
    }

    then 'artikkeli poistuu tietokannasta', {
       driver.getPageSource().contains("Second Auhtor").shouldBe false
    }
}
