package br.com.dankicommerce.rn;

import java.text.NumberFormat;
import java.util.Locale;

public class FormataDeDoubleParaReais {

	public String executa(Double valor) {
		
		final Locale brasil = new Locale("pt", "BR");
		
		return  NumberFormat.getCurrencyInstance(brasil).format(valor);
	}

}
