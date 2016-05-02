import main.*

import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver

description 'Kayttaja pystyy suorittamaan haun tagin perusteella'

scenario "kayttaja pystyy poistamaan artikkelin", {
    given 'käyttäjä on etusivulla', {
       driver = new HtmlUnitDriver();
       driver.get("http://localhost:8080/addtestdata");
       driver.get("http://localhost:8080");
    }

    when 'haku suoritetaan', {
       element = driver.findElement(By.id("search-box"));
       element.sendKeys("test1");
       element = driver.findElement(By.id("search-submit"));
       element.click();
    }

    then 'vain oikean tagin omaavien viitteiden tulisi nakya', {
       driver.getPageSource().contains("Test title").shouldBe true
       driver.getPageSource().contains("Book 1").shouldBe true

       driver.getPageSource().contains("Second title").shouldBe false
       driver.getPageSource().contains("Inproceedings 1").shouldBe false
    }
}
