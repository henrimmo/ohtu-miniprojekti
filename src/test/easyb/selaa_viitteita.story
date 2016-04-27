import main.*

import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver

description 'Kayttaja pystyy selaamaan talletettuja viitteita'

scenario "talletetut viitteet naytetaan listana listaus-valilehdella", {
    given 'viite on lisätty tietokantaan', {
        element = driver.findElement(By.linkText("artikkeli"));
        element.click();
        element = driver.findElement(By.name("author"));
        element.sendKeys("Sini");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Sinista");
        element = driver.findElement(By.name("journal"));
        element.sendKeys("Varit");
        element = driver.findElement(By.name("year"));
        element.sendKeys("2010");
        element = driver.findElement(By.name("volume"));
        element.sendKeys("3");
        element = driver.findElement(By.name("lisaa"));
        element.submit();
    }
    when 'käyttäjä on etusivulla', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
    }
    then 'viite näkyy etusivulla', {
        driver.getPageSource().contains("Sini").shouldBe true
    }
}
/*
scenario "talletetut viitteet naytetaan lisaysjasjestyksessa", {
    given 'kayttaja on etusivulla', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
    }
    when 'listaus-valilehti valitaan', {
    }
    then 'tietokannan sisalta nakyy lisaysjarjestyksessa', {
    }
}

scenario "viitteen tiedot on pilkuilla erotettuja listaus-valilehdella", {
    given 'kayttaja on etusivulla', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
    }
    when 'listaus-valilehti valitaan', {
    }
    then 'listassa jokaisen viitteen tiedot on pilkuilla erotettuja', {
    }
}*/