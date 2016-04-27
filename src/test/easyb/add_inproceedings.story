import main.*

import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver

description 'Kayttaja pystyy tallettamaan inproceedings'

scenario "kayttaja pystyy tallettamaan inproceedings", {
    given 'add inproceedings -kasky valittu', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("inproceedings"));
        element.click();
    }

    when 'kentat taytetty inproceedingsin tiedoilla', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("Sini");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Sinista");
        element = driver.findElement(By.name("booktitle"));
        element.sendKeys("Varit");
        element = driver.findElement(By.name("year"));
        element.sendKeys("2010");
        element = driver.findElement(By.name("lisaa"));
        element.submit();
    }

    then 'inproceedings on lisatty tietokantaan', {
        driver.getPageSource().contains("Inproceedings lisatty").shouldBe true
    }
}
//joka kentalle oma "tyhja kentta"-scenario:
scenario "kayttaja ei tayta yhta kenttaa eika inproceedinsia lisata", {
    given 'add inproceedins -kasky valittu', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("inproceedins"));
        element.click();
    }
    when 'yksi kentta jaa tyhjaksi', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("Sini");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Sinista");
        element = driver.findElement(By.name("journal"));
        element.sendKeys("Varit");
        element = driver.findElement(By.name("lisaa"));
        element.submit();
    }
    then 'inproceedinsia ei lisatty tietokantaan', {
        driver.getPageSource().contains("inproceedingsia ei lisätty").shouldBe true
    }
}

scenario "kentassa aakkasia ja inproceedings lisataan", {
    given 'add inproceedings -kasky valittu', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("inproceedings"));
        element.click();
    }
    when 'inproceedingsin nimessa aakkasia', {
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
    then 'inproceeding on lisatty tietokantaan', {
        driver.getPageSource().contains("Artikkeli lisatty").shouldBe true
    }
}

scenario "year-kentassa on muuta kuin numeroita eika inproceedingsia lisata", {
    given 'add inproceedings -kasky valittu', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("inproceedings"));
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
        element = driver.findElement(By.name("lisaa"));
        element.submit();
    }
    then 'inproceedingsia ei lisatty tietokantaan', {
        driver.getPageSource().contains("inproceedingsia ei lisatty").shouldBe true
    }
}

scenario "year-kentan syatteen pituus ei ole nelja eika inproceedingsia lisata", {
    given 'add inproceedings -kasky valittu', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("inproceedings"));
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
        element = driver.findElement(By.name("lisaa"));
        element.submit();
    }
    then 'inproceedingsia ei lisatty tietokantaan', {
        driver.getPageSource().contains("inproceedingsia ei lisatty").shouldBe true
    }
}