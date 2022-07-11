package br.com.dankicommerce.controller;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.dankicommerce.model.Usuario;
import br.com.olimposistema.aipa.dao.DAO;

@Controller
@Path("cadastrar")
public class CadastrarController {
	
	@Inject EntityManager em;
	@Inject Result result;
	@Inject DAO<Usuario> usuarioDao;
	@Inject Validator validator;
	
	@Get("")
	public void cadastrar() {
		// vai cair aqui
	}

	@Post("salvaUsuario")
	public void salvaUsuario(@Valid Usuario usuario) {
		// savar no banco 
		// redireciona para cadastrar
		validator.onErrorRedirectTo(this).cadastrar();
		usuarioDao.insert(usuario);
		/* em.persist(usuario); */
		result.redirectTo(ProdutosController.class).produtos();
		
	}

}
