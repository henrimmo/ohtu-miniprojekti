/*import main.*

import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver

description 'Kayttaja pystyy tallettamaan manualin'

scenario "kayttaja pystyy tallettamaan manualin", {
    given 'add manual -kasky valittu', {
        start();
    }

    when 'kentat taytetty manualin tiedoilla', {
        element = driver.findElement(By.name("id"));
        element.sendKeys("sini1");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Sinista");
        element = driver.findElement(By.id("manual-save"));
        element.submit();
    }

    then 'manual on lisatty tietokantaan', {
        containsSini(true);
    }
}

/*
//joka kentalle oma "tyhja kentta"-scenario:
scenario "kayttaja ei tayta yhta kenttaa eika manualia lisata", {
    given 'add manual -kasky valittu', {
        start();
    }
    when 'yksi kentta jaa tyhjaksi', {
        element = driver.findElement(By.name("id"));
        element.sendKeys("sini1");
        element = driver.findElement(By.id("manual-save"));
        element.submit();
    }
    then 'manualia ei lisatty tietokantaan', {
        containsSini(false);
    }
}
*/

scenario "kentassa aakkasia ja manual lisataan", {
    given 'add manual -kasky valittu', {
        start();
    }
    when 'manualin nimessa aakkasia', {
        element = driver.findElement(By.name("id"));
        element.sendKeys("sini1");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Sinistä");
        element = driver.findElement(By.id("manual-save"));
        element.submit();
    }
    then 'manual on lisatty tietokantaan', {
        driver.getPageSource().contains("Sinistä").shouldBe true
    }
}


void start(){
    driver = new HtmlUnitDriver();
    driver.get("http://localhost:8080/");
    element = driver.findElement(By.linkText("Add manual"));
    element.click();
}

void containsSini(boolean condition){
    driver.getPageSource().contains("Sinista").shouldBe condition
}
*/