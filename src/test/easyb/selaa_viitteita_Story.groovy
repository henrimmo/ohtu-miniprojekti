description 'K�ytt�j� pystyy selaamaan talletettuja viitteit�'

scenario "talletetut viitteet n�ytet��n listana listaus-v�lilehdell�", {
    given 'viite on lisätty tietokantaan', {
        element = driver.findElement(By.linkText("artikkeli"));
        element.click();
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
    when 'käyttäjä on etusivulla', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
    }
    then 'viite näkyy etusivulla', {
        driver.getPageSource().contains("Sini").shouldBe true
    }
}
/*
scenario "talletetut viitteet n�ytet��n lis�ysj�sjestyksess�", {
    given 'k�ytt�j� on etusivulla', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
    }
    when 'listaus-v�lilehti valitaan', {
    }
    then 'tietokannan sis�lt� n�kyy lis�ysj�rjestyksess�', {
    }
}

scenario "viitteen tiedot on pilkuilla erotettuja listaus-v�lilehdell�", {
    given 'k�ytt�j� on etusivulla', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
    }
    when 'listaus-v�lilehti valitaan', {
    }
    then 'listassa jokaisen viitteen tiedot on pilkuilla erotettuja', {
    }
}*/