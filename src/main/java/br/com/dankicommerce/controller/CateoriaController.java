package br.com.dankicommerce.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.dankicommerce.model.Categoria;
import br.com.olimposistema.aipa.dao.DAO;
import br.com.olimposistema.aipa.vraptorcrud.CrudRest;
import net.bytebuddy.asm.Advice.This;

@Controller
@Path("categoria")
public class CateoriaController  extends CrudRest<Categoria>{
	
	// API REST
		@Inject Result result;
		private DAO<Categoria> dao;
	
	@Inject	
	public CateoriaController(DAO<Categoria> dao) {
		super(Categoria.class, dao);
		this.dao = dao;
		
		
	}
	
	@Deprecated
	public CateoriaController() {this(null);}
	/*
	 * @Post("")
	 * 
	 * @Consumes("application/json") public void adicionaCategoria(Categoria
	 * categoria) {
	 * 
	 * Categoria categoriaInserida = categoriaDao.insertOrUpdate(categoria);
	 * 
	 * result.use(Results.json()) .withoutRoot() .from(categoriaInserida)
	 * .serialize();
	 * 
	 * }
	 */
	
}
