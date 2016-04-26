description 'K�ytt�j� pystyy poistamaan artikkelin'

scenario "k�ytt�j� pystyy poistamaan artikkelin", {
    given 'käyttäjä on etusivulla', {
       driver = new HtmlUnitDriver();
       driver.get("http://localhost:8080");
    }

    when 'delete-käsky valitaan', {
       element = driver.findElement(By.linkText("delete"));
       element.click();
    }

    then 'artikkeli poistuu tietokannasta', {
       driver.getPageSource().contains("Artikkeli poistettu").shouldBe true
    }
}