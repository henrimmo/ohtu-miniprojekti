description 'K�ytt�j� pystyy tallettamaan book:n'

scenario "k�ytt�j� pystyy tallettamaan book:n", {
    given 'add book -k�sky valittu', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("book"));
        element.click();
    }

    when 'kent�t t�ytetty book:n tiedoilla', {
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

    then 'book on lis�tty tietokantaan', {
        driver.getPageSource().contains("Kirja lis�tty").shouldBe true
    }
}
//joka kent�lle oma "tyhj� kentt�"-scenario:
scenario "k�ytt�j� ei t�yt� yht� kentt�� eik� book:a lis�t�", {
    given 'add book -k�sky valittu', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("book"));
        element.click();
    }
    when 'yksi kentt� j�� tyhj�ksi', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("Sini");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Sinista");
        element = driver.findElement(By.name("publisher"));
        element.sendKeys("Varit");
        element = driver.findElement(By.name("lisaa"));
        element.submit();
    }
    then 'Kirjaaa ei lis�tty tietokantaan', {
    }
}

scenario "kent�ss� ��kk�si� ja book lis�t��n", {
    given 'add book -k�sky valittu', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("book"));
        element.click();
    }
    when 'artikkelin nimess� ��kk�si�', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("Sini");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Sinist�");
        element = driver.findElement(By.name("publisher"));
        element.sendKeys("V�rit");
        element = driver.findElement(By.name("year"));
        element.sendKeys("2010");
        element = driver.findElement(By.name("lisaa"));
        element.submit();
    }
    then 'Kirja on lis�tty tietokantaan', {
    }
}

scenario "year-kent�ss� on muuta kuin numeroita eik� book:a lis�t�", {
    given 'add book -k�sky valittu', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("book"));
        element.click();
    }
    when 'year-kent�ss� kirjain', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("Sini");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Sinist�");
        element = driver.findElement(By.name("publisher"));
        element.sendKeys("V�rit");
        element = driver.findElement(By.name("year"));
        element.sendKeys("kolme");
        element = driver.findElement(By.name("lisaa"));
        element.submit();
    }
    then 'Kirjaa ei lis�tty tietokantaan', {
    }
}

scenario "year-kent�n sy�tteen pituus ei ole nelj� eik� book:a lis�t�", {
    given 'add book -k�sky valittu', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("book"));
        element.click();
    }
    when 'year-kent�ss� kolme numeroa', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("Sini");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Sinist�");
        element = driver.findElement(By.name("publisher"));
        element.sendKeys("V�rit");
        element = driver.findElement(By.name("year"));
        element.sendKeys("201");
        element = driver.findElement(By.name("lisaa"));
        element.submit();
    }
    then 'Kirjaa ei lis�tty tietokantaan', {
    }
}