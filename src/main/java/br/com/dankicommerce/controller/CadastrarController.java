package br.com.dankicommerce.controller;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.dankicommerce.model.Usuario;

@Controller
@Path("cadastrar")
public class CadastrarController {
	
	@Inject EntityManager em;
	@Inject Result result;
	
	@Get("")
	public void cadastrar() {
		// vai cair aqui
	}

	@Post("salvaUsuario")
	public void salvaUsuario(Usuario usuario) {
		// savar no banco 
		em.persist(usuario);
		result.redirectTo(ProdutosController.class).produtos();
		
	}

}
