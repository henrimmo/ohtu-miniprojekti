import main.*

import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver

description 'Kayttaja pystyy selaamaan talletettuja viitteita'

scenario "talletetut viitteet naytetaan listana listaus-valilehdella", {
    given 'viite on lisätty tietokantaan', {
        start();
    }
    when 'käyttäjä on etusivulla', {
        driver.get("http://localhost:8080");
    }
    then 'viite näkyy etusivulla', {
        driver.getPageSource().contains("test00").shouldBe true
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

void start(){
    driver = new HtmlUnitDriver();
    driver.get("http://localhost:8080/addtestdata");
}