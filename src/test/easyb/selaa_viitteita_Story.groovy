description 'K�ytt�j� pystyy selaamaan talletettuja viitteit�'

scenario "talletetut viitteet n�ytet��n listana listaus-v�lilehdell�", {
	given 'k�ytt�j� on etusivulla', {
	}
	when 'listaus-v�lilehti valitaan', {
	}
	then 'tietokannan sis�lt� n�kyy listana', {
	}
}

scenario "talletetut viitteet n�ytet��n lis�ysj�sjestyksess�", {
	given 'k�ytt�j� on etusivulla', {
	}
	when 'listaus-v�lilehti valitaan', {
	}
	then 'tietokannan sis�lt� n�kyy lis�ysj�rjestyksess�', {
	}
}

scenario "viitteen tiedot on pilkuilla erotettuja listaus-v�lilehdell�", {
	given 'k�ytt�j� on etusivulla', {
	}
	when 'listaus-v�lilehti valitaan', {
	}
	then 'listassa jokaisen viitteen tiedot on pilkuilla erotettuja', {
	}
}