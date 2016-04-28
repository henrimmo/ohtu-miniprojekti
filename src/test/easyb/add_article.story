import main.*

import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver

description 'Kayttaja pystyy tallettamaan artikkelin'

scenario "kayttaja pystyy tallettamaan artikkelin", {
    given 'lisaa artikkeli -kasky valittu', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/");
        element = driver.findElement(By.linkText("Add article"));
        element.click();
    }

    when 'kentat taytetty artikkelin tiedoilla', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("Sini");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Sinista");
        element = driver.findElement(By.name("journal"));
        element.sendKeys("Varit");
        element = driver.findElement(By.name("year"));
        element.sendKeys("2010");
        element = driver.findElement(By.name("lisaa"));
        element.submit();
    }

    then 'artikkeli on lisatty tietokantaan', {
        driver.getPageSource().contains("Sini").shouldBe true
    }
}

//joka kentalle oma "tyhja kentta"-scenario:
scenario "kayttaja ei tayta yhta kenttaa eika artikkelia lisata", {
    given 'lisaa artikkeli -kasky valittu', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("artikkeli"));
        element.click();
    }
    when 'yksi kentta jaa tyhjaksi', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("Sini");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Sinista");
        element = driver.findElement(By.name("journal"));
        element.sendKeys("Varit");
        element = driver.findElement(By.name("year"));
        element.sendKeys("2010");
        element = driver.findElement(By.name("lisaa"));
        element.submit();
    }
    then 'artikkelia ei lisatty tietokantaan', {
        driver.getPageSource().contains("Artikkelia ei lisätty").shouldBe true
    }
}

scenario "kentassa aakkasia ja artikkeli lisataan", {
    given 'lisaa artikkeli -kasky valittu', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("artikkeli"));
        element.click();
    }
    when 'artikkelin nimessa aakkasia', {
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
    then 'artikkeli on lisatty tietokantaan', {
        driver.getPageSource().contains("Artikkeli lisatty").shouldBe true
    }
}

scenario "year-kentassa on muuta kuin numeroita eika artikkelia lisata", {
    given 'lisaa artikkeli -kasky valittu', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("artikkeli"));
        element.click();
    }
    when 'year-kentassa kirjain', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("Sini");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Sinista");
        element = driver.findElement(By.name("journal"));
        element.sendKeys("Varit");
        element = driver.findElement(By.name("year"));
        element.sendKeys("kolme");
        element = driver.findElement(By.name("volume"));
        element.sendKeys("3");
        element = driver.findElement(By.name("lisaa"));
        element.submit();
    }
    then 'artikkelia ei lisatty tietokantaan', {
        driver.getPageSource().contains("Artikkelia ei lisatty").shouldBe true
    }
}

scenario "year-kentan syatteen pituus ei ole nelja eika artikkelia lisata", {
    given 'lisaa artikkeli -kasky valittu', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("artikkeli"));
        element.click();
    }
    when 'year-kentassa kolme numeroa', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("Sini");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Sinista");
        element = driver.findElement(By.name("journal"));
        element.sendKeys("Varit");
        element = driver.findElement(By.name("year"));
        element.sendKeys("201");
        element = driver.findElement(By.name("volume"));
        element.sendKeys("3");
        element = driver.findElement(By.name("lisaa"));
        element.submit();
    }
    then 'artikkelia ei lisatty tietokantaan', {
        driver.getPageSource().contains("Artikkelia ei lisatty").shouldBe true
    }
}