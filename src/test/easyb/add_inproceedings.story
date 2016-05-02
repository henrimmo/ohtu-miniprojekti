import main.*

import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver

description 'Kayttaja pystyy tallettamaan inproceedings'

scenario "kayttaja pystyy tallettamaan inproceedings", {
    given 'add inproceedings -kasky valittu', {
        start();
    }

    when 'kentat taytetty inproceedingsin tiedoilla', {
        element = driver.findElement(By.name("id"));
        element.sendKeys("sini1");
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
        containsSini(true);
    }
}
//joka kentalle oma "tyhja kentta"-scenario:
scenario "kayttaja ei tayta yhta kenttaa eika inproceedinsia lisata", {
    given 'add inproceedins -kasky valittu', {
        start();
    }
    when 'yksi kentta jaa tyhjaksi', {
        element = driver.findElement(By.name("id"));
        element.sendKeys("sini1");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Sinista");
        element = driver.findElement(By.name("journal"));
        element.sendKeys("Varit");
        element = driver.findElement(By.name("lisaa"));
        element.submit();
    }
    then 'inproceedinsia ei lisatty tietokantaan', {
        containsSini(false);
    }
}

scenario "kentassa aakkasia ja inproceedings lisataan", {
    given 'add inproceedings -kasky valittu', {
        start();
    }
    when 'inproceedingsin nimessa aakkasia', {
        element = driver.findElement(By.name("id"));
        element.sendKeys("sini1");
        element = driver.findElement(By.name("author"));
        element.sendKeys("Sini");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Sinistä");
        element = driver.findElement(By.name("journal"));
        element.sendKeys("Varit");
        element = driver.findElement(By.name("year"));
        element.sendKeys("2010");
        element = driver.findElement(By.name("lisaa"));
        element.submit();
    }
    then 'inproceeding on lisatty tietokantaan', {
        driver.getPageSource().contains("Sinistä").shouldBe true
    }
}

scenario "year-kentassa on muuta kuin numeroita eika inproceedingsia lisata", {
    given 'add inproceedings -kasky valittu', {
        start();
    }
    when 'year-kentassa kirjain', {
        element = driver.findElement(By.name("id"));
        element.sendKeys("sini1");
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
        containsSini(false);
    }
}

scenario "year-kentan syatteen pituus ei ole nelja eika inproceedingsia lisata", {
    given 'add inproceedings -kasky valittu', {
        start();
    }
    when 'year-kentassa kolme numeroa', {
        element = driver.findElement(By.name("id"));
        element.sendKeys("sini1");
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
        containsSini(false);
    }
}

void start(){
    driver = new HtmlUnitDriver();
    driver.get("http://localhost:8080/");
    element = driver.findElement(By.linkText("Add inproceedings"));
    element.click();
}

void containsSini(boolean condition){
    driver.getPageSource().contains("Sini").shouldBe condition
    driver.getPageSource().contains("Sinista").shouldBe condition
    driver.getPageSource().contains("Varit").shouldBe condition
    driver.getPageSource().contains("2010").shouldBe condition
}