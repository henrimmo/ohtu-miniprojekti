description 'K‰ytt‰j‰ pystyy tallettamaan artikkelin'

scenario "k‰ytt‰j‰ pystyy tallettamaan artikkelin", {
    given 'lis‰‰ artikkeli -k‰sky valittu', {
       driver = new HtmlUnitDriver();
       driver.get("http://localhost:8080");
       element = driver.findElement(By.linkText("artikkeli"));
       element.click();
    }

    when 'kent‰t t‰ytetty artikkelin tiedoilla', {
       element = driver.findElement(By.name("author"));
       element.sendKeys("Sini");
       element = driver.findElement(By.name("title"));
       element.sendKeys("Sinist‰");
       element = driver.findElement(By.name("journal"));
       element.sendKeys("V‰rit");
       element = driver.findElement(By.name("year"));
       element.sendKeys("2010");
       element = driver.findElement(By.name("volume"));
       element.sendKeys("3");
       element = driver.findElement(By.name("lisaa"));
       element.submit();
    }

    then 'artikkeli on lis‰tty tietokantaan', {
       driver.getPageSource().contains("Artikkeli lis‰tty").shouldBe true
    }
}
//joka kent‰lle oma "tyhj‰ kentt‰"-scenario:
scenario "k‰ytt‰j‰ ei t‰yt‰ yht‰ kentt‰‰ eik‰ artikkelia lis‰t‰", {
	given 'lis‰‰ artikkeli -k‰sky valittu', {
	}
	when 'yksi kentt‰ j‰‰ tyhj‰ksi', {
	}
	then 'artikkelia ei lis‰tty tietokantaan', {
	}
}

scenario "kent‰ss‰ ‰‰kkˆsi‰ ja artikkeli lis‰t‰‰n", {
	given 'lis‰‰ artikkeli -k‰sky valittu', {
	}
	when 'artikkelin nimess‰ ‰‰kkˆsi‰', {
	}
	then 'artikkeli on lis‰tty tietokantaan', {
	}
}

scenario "year-kent‰ss‰ on muuta kuin numeroita eik‰ artikkelia lis‰t‰", {
	given 'lis‰‰ artikkeli -k‰sky valittu', {
	}
	when 'year-kent‰ss‰ kirjain', {
	}
	then 'artikkelia ei lis‰tty tietokantaan', {
	}
}

scenario "year-kent‰n syˆtteen pituus ei ole nelj‰ eik‰ artikkelia lis‰t‰", {
	given 'lis‰‰ artikkeli -k‰sky valittu', {
	}
	when 'year-kent‰ss‰ kolme numeroa', {
	}
	then 'artikkelia ei lis‰tty tietokantaan', {
	}
}


description 'K‰ytt‰j‰ pystyy selaamaan talletettuja viitteit‰'

scenario "talletetut viitteet n‰ytet‰‰n listana listaus-v‰lilehdell‰", {
	given 'k‰ytt‰j‰ on etusivulla', {
	}
	when 'listaus-v‰lilehti valitaan', {
	}
	then 'tietokannan sis‰ltˆ n‰kyy listana', {
	}
}

scenario "talletetut viitteet n‰ytet‰‰n lis‰ysj‰sjestyksess‰", {
	given 'k‰ytt‰j‰ on etusivulla', {
	}
	when 'listaus-v‰lilehti valitaan', {
	}
	then 'tietokannan sis‰ltˆ n‰kyy lis‰ysj‰rjestyksess‰', {
	}
}

scenario "viitteen tiedot on pilkuilla erotettuja listaus-v‰lilehdell‰", {
	given 'k‰ytt‰j‰ on etusivulla', {
	}
	when 'listaus-v‰lilehti valitaan', {
	}
	then 'listassa jokaisen viitteen tiedot on pilkuilla erotettuja', {
	}
}