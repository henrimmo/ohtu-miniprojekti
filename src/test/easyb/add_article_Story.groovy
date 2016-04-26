description 'K�ytt�j� pystyy tallettamaan artikkelin'

scenario "k�ytt�j� pystyy tallettamaan artikkelin", {
    given 'lis�� artikkeli -k�sky valittu', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("artikkeli"));
        element.click();
    }

    when 'kent�t t�ytetty artikkelin tiedoilla', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("Sini");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Sinist�");
        element = driver.findElement(By.name("journal"));
        element.sendKeys("V�rit");
        element = driver.findElement(By.name("year"));
        element.sendKeys("2010");
        element = driver.findElement(By.name("volume"));
        element.sendKeys("3");
        element = driver.findElement(By.name("lisaa"));
        element.submit();
    }

    then 'artikkeli on lis�tty tietokantaan', {
        driver.getPageSource().contains("Artikkeli lis�tty").shouldBe true
    }
}
//joka kent�lle oma "tyhj� kentt�"-scenario:
scenario "k�ytt�j� ei t�yt� yht� kentt�� eik� artikkelia lis�t�", {
    given 'lis�� artikkeli -k�sky valittu', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("artikkeli"));
        element.click();
    }
    when 'yksi kentt� j�� tyhj�ksi', {
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
    then 'artikkelia ei lis�tty tietokantaan', {
        driver.getPageSource().contains("Artikkelia ei lisätty").shouldBe true
    }
}

scenario "kent�ss� ��kk�si� ja artikkeli lis�t��n", {
    given 'lis�� artikkeli -k�sky valittu', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("artikkeli"));
        element.click();
    }
    when 'artikkelin nimess� ��kk�si�', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("Sini");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Sinist�");
        element = driver.findElement(By.name("journal"));
        element.sendKeys("V�rit");
        element = driver.findElement(By.name("year"));
        element.sendKeys("2010");
        element = driver.findElement(By.name("volume"));
        element.sendKeys("3");
        element = driver.findElement(By.name("lisaa"));
        element.submit();
    }
    then 'artikkeli on lis�tty tietokantaan', {
        driver.getPageSource().contains("Artikkeli lis�tty").shouldBe true
    }
}

scenario "year-kent�ss� on muuta kuin numeroita eik� artikkelia lis�t�", {
    given 'lis�� artikkeli -k�sky valittu', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("artikkeli"));
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
        element = driver.findElement(By.name("volume"));
        element.sendKeys("3");
        element = driver.findElement(By.name("lisaa"));
        element.submit();
    }
    then 'artikkelia ei lis�tty tietokantaan', {
        driver.getPageSource().contains("Artikkelia ei lis�tty").shouldBe true
    }
}

scenario "year-kent�n sy�tteen pituus ei ole nelj� eik� artikkelia lis�t�", {
    given 'lis�� artikkeli -k�sky valittu', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("artikkeli"));
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
        element = driver.findElement(By.name("volume"));
        element.sendKeys("3");
        element = driver.findElement(By.name("lisaa"));
        element.submit();
    }
    then 'artikkelia ei lis�tty tietokantaan', {
        driver.getPageSource().contains("Artikkelia ei lis�tty").shouldBe true
    }
}