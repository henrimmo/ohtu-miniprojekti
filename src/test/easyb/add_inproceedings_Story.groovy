description 'K�ytt�j� pystyy tallettamaan inproceedings'

scenario "k�ytt�j� pystyy tallettamaan inproceedings", {
    given 'add inproceedings -k�sky valittu', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("inproceedings"));
        element.click();
    }

    when 'kent�t t�ytetty inproceedingsin tiedoilla', {
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

    then 'inproceedings on lis�tty tietokantaan', {
        driver.getPageSource().contains("Inproceedings lis�tty").shouldBe true
    }
}
//joka kent�lle oma "tyhj� kentt�"-scenario:
scenario "k�ytt�j� ei t�yt� yht� kentt�� eik� inproceedinsia lis�t�", {
    given 'add inproceedins -k�sky valittu', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("inproceedins"));
        element.click();
    }
    when 'yksi kentt� j�� tyhj�ksi', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("Sini");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Sinista");
        element = driver.findElement(By.name("journal"));
        element.sendKeys("Varit");
        element = driver.findElement(By.name("lisaa"));
        element.submit();
    }
    then 'inproceedinsia ei lis�tty tietokantaan', {
        driver.getPageSource().contains("inproceedingsia ei lisätty").shouldBe true
    }
}

scenario "kent�ss� ��kk�si� ja inproceedings lis�t��n", {
    given 'add inproceedings -k�sky valittu', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("inproceedings"));
        element.click();
    }
    when 'inproceedingsin nimess� ��kk�si�', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("Sini");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Sinist�");
        element = driver.findElement(By.name("journal"));
        element.sendKeys("V�rit");
        element = driver.findElement(By.name("year"));
        element.sendKeys("2010");
        element = driver.findElement(By.name("lisaa"));
        element.submit();
    }
    then 'inproceeding on lis�tty tietokantaan', {
        driver.getPageSource().contains("Artikkeli lis�tty").shouldBe true
    }
}

scenario "year-kent�ss� on muuta kuin numeroita eik� inproceedingsia lis�t�", {
    given 'add inproceedings -k�sky valittu', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("inproceedings"));
        element.click();
    }
    when 'year-kent�ss� kirjain', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("Sini");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Sinist�");
        element = driver.findElement(By.name("journal"));
        element.sendKeys("V�rit");
        element = driver.findElement(By.name("year"));
        element.sendKeys("kolme");
        element = driver.findElement(By.name("lisaa"));
        element.submit();
    }
    then 'inproceedingsia ei lis�tty tietokantaan', {
        driver.getPageSource().contains("inproceedingsia ei lis�tty").shouldBe true
    }
}

scenario "year-kent�n sy�tteen pituus ei ole nelj� eik� inproceedingsia lis�t�", {
    given 'add inproceedings -k�sky valittu', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("inproceedings"));
        element.click();
    }
    when 'year-kent�ss� kolme numeroa', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("Sini");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Sinist�");
        element = driver.findElement(By.name("journal"));
        element.sendKeys("V�rit");
        element = driver.findElement(By.name("year"));
        element.sendKeys("201");
        element = driver.findElement(By.name("lisaa"));
        element.submit();
    }
    then 'inproceedingsia ei lis�tty tietokantaan', {
        driver.getPageSource().contains("inproceedingsia ei lis�tty").shouldBe true
    }
}