import main.*

import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver

description 'Kayttaja pystyy tallettamaan book:n'

scenario "kayttaja pystyy tallettamaan book:n", {
    given 'add book -kasky valittu', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("book"));
        element.click();
    }

    when 'kentat taytetty book:n tiedoilla', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("Sini");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Sinista");
        element = driver.findElement(By.name("publisher"));
        element.sendKeys("Varit");
        element = driver.findElement(By.name("year"));
        element.sendKeys("2010");
        element = driver.findElement(By.name("lisaa"));
        element.submit();
    }

    then 'book on lisatty tietokantaan', {
        driver.getPageSource().contains("Kirja lisatty").shouldBe true
    }
}
//joka kentalle oma "tyhja kentta"-scenario:
scenario "kayttaja ei tayta yhta kenttaa eika book:a lisata", {
    given 'add book -kasky valittu', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("book"));
        element.click();
    }
    when 'yksi kentta jaa tyhjaksi', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("Sini");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Sinista");
        element = driver.findElement(By.name("publisher"));
        element.sendKeys("Varit");
        element = driver.findElement(By.name("lisaa"));
        element.submit();
    }
    then 'Kirjaaa ei lisatty tietokantaan', {
    }
}

scenario "kentassa aakkasia ja book lisataan", {
    given 'add book -kasky valittu', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("book"));
        element.click();
    }
    when 'artikkelin nimessa aakkasia', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("Sini");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Sinista");
        element = driver.findElement(By.name("publisher"));
        element.sendKeys("Varit");
        element = driver.findElement(By.name("year"));
        element.sendKeys("2010");
        element = driver.findElement(By.name("lisaa"));
        element.submit();
    }
    then 'Kirja on lisatty tietokantaan', {
    }
}

scenario "year-kentassa on muuta kuin numeroita eika book:a lisata", {
    given 'add book -kasky valittu', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("book"));
        element.click();
    }
    when 'year-kentassa kirjain', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("Sini");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Sinista");
        element = driver.findElement(By.name("publisher"));
        element.sendKeys("Varit");
        element = driver.findElement(By.name("year"));
        element.sendKeys("kolme");
        element = driver.findElement(By.name("lisaa"));
        element.submit();
    }
    then 'Kirjaa ei lisatty tietokantaan', {
    }
}

scenario "year-kentan syatteen pituus ei ole nelja eika book:a lisata", {
    given 'add book -kasky valittu', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("book"));
        element.click();
    }
    when 'year-kentassa kolme numeroa', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("Sini");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Sinista");
        element = driver.findElement(By.name("publisher"));
        element.sendKeys("Varit");
        element = driver.findElement(By.name("year"));
        element.sendKeys("201");
        element = driver.findElement(By.name("lisaa"));
        element.submit();
    }
    then 'Kirjaa ei lisatty tietokantaan', {
    }
}