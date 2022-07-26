package br.com.dankicommerce.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.dankicommerce.rn.ConverteDataDeEnParaCalendar;
import br.com.dankicommerce.rn.FormataDeDoubleParaReais;
import br.com.olimposistema.aipa.imagem.Imagem;
import br.com.olimposistema.aipa.model.Model;

@Entity
public class Produto extends Model {
	

	@NotEmpty(message = "{produto.nome.notempty}")
	@Size(min = 2, max = 150, message = "{produto.nome.size}")
	private String nome;
	
	@NotEmpty(message = "{produto.descricao.notempty}")
	@Type(type = "text")
	private String descricao;
	
	@NotNull(message = "{produto.valor.notnull}")
	@Min(value = 0, message = "{produto.valor.min}")
	private Double valor;
	
	
	@ManyToOne
	@NotNull(message = "{produto.categoria.notnull}")
	private Categoria categoria;
	
	@NotNull(message = "{produto.dataValidade.notnull}")
	@Temporal(TemporalType.DATE)
	private Calendar dataValidade;
	
	@OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE}, fetch = FetchType.EAGER, orphanRemoval = true )
	private Imagem imagem;
	
	

	public Imagem getImagem() {
		return imagem;
	}

	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}

	public Calendar getDataValidade() {
		return dataValidade;
	}
	
	public String getDataValidadeFormtada() {
		
		String dataformatada = new SimpleDateFormat("dd/MM/yyyy").format(dataValidade.getTime());
		
		return dataformatada;
	}

	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	}
	
	public void setDataValidadeEn(String data) {
		//2022-07-23
		
		if(data == null) return;
		
		this.dataValidade = new ConverteDataDeEnParaCalendar().executa(data);
		
	}
	

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}
	
	public String getValorMoney() {
		
		String valorFormatado = new FormataDeDoubleParaReais().executa(valor);
		
		return valorFormatado;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
