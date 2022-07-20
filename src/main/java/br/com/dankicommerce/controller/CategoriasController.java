package br.com.dankicommerce.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.dankicommerce.interceptors.SomenteLogado;
import br.com.dankicommerce.model.Categoria;
import br.com.olimposistema.aipa.dao.DAO;

@Controller
@Path("categorias")
public class CategoriasController {
	
	@Inject HttpSession session;
	@Inject Result result;
	@Inject DAO<Categoria> categoriaDao;
	@Inject Validator validator;
	
	@Get("")
	@SomenteLogado
	public void categorias() {
		
		List<Categoria> categorias = categoriaDao.selectAll();
		result.include("categorias", categorias);
		
	}

}
