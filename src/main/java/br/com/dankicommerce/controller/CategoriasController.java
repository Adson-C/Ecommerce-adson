package br.com.dankicommerce.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.dankicommerce.interceptors.SomenteLogado;

@Controller
@Path("categorias")
public class CategoriasController {
	
	@Get("")
	@SomenteLogado
	public void categorias() {
		
		
	}

}
