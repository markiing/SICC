package com.br.sicc.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import com.br.sicc.business.EnderecoBO;
import com.br.sicc.business.PessoaBO;
import com.br.sicc.config.ApplicationContextProvider;
import com.br.sicc.facade.GenericFacade;
import com.br.sicc.model.Cidade;
import com.br.sicc.model.Estado;
import com.br.sicc.model.Pessoa;
import com.br.sicc.util.FeedbackUtils;
import com.br.sicc.util.SICCUtil;

@ManagedBean
@ViewScoped
public class PessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private GenericFacade facade = ApplicationContextProvider.getApplicationContext().getBean(GenericFacade.class);
	private List<Estado> listEstado = new ArrayList<>();
	private List<Cidade> listCidade = new ArrayList<>();
	private List<Pessoa> listPessoas = new ArrayList<>();
	private List<SelectItem> estadosSI = new ArrayList<>();
	private List<SelectItem> cidadesSI = new ArrayList<>();
	private List<Pessoa> listPessoasFiltradas = new ArrayList<>();
	private Pessoa pessoa;
	private Estado estado;
	private String tipoTelefone = "C";
	private static final Integer LENGHT_CHARACTER_FIXPHONE = 13;
	private static String PHONE_MASK = "(99)99999-9999";
	
	@PostConstruct
	public void init(){
		estado = new Estado();
		pessoa = new Pessoa();
		try {
			listEstado = facade.get(EnderecoBO.class).listarEstados();
			for(Estado e: listEstado){
				estadosSI.add(new SelectItem(e, e.getEstado()));
			}
			
			listPessoas = facade.get(PessoaBO.class).recuperarPessoas();
			listPessoasFiltradas = listPessoas;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void carregarCidades(Estado e){
		try{
			if(cidadesSI.size()>0) cidadesSI.clear();
			listCidade = facade.get(EnderecoBO.class).listarCidade(e);
			for(Cidade c: listCidade){
				cidadesSI.add(new SelectItem(c, c.getCidade()));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void cadastrar(Pessoa p){
		try {
			if(facade.get(PessoaBO.class).recuperarPessoa(p) == null){
				facade.get(PessoaBO.class).salvar(p);
				SICCUtil.exibirMensagem(FacesMessage.SEVERITY_INFO, FeedbackUtils.INSERT_SUCCESSFULLY);
			}else{
				SICCUtil.exibirMensagem(FacesMessage.SEVERITY_ERROR, FeedbackUtils.INSERT_FAILED_EXISTING_REGISTER);
			}
		} catch (Exception e) {
			SICCUtil.exibirMensagem(FacesMessage.SEVERITY_ERROR, FeedbackUtils.GENERIC_INSERT_ERROR);
		}
		pessoa = new Pessoa();
	}
	
	public void atualizarDados(Pessoa p){
		try{
			facade.get(PessoaBO.class).atualizar(p);
			SICCUtil.exibirMensagem(FacesMessage.SEVERITY_INFO, FeedbackUtils.UPDATE_SUCCESSFULLY);
		}catch(Exception ex){
			SICCUtil.exibirMensagem(FacesMessage.SEVERITY_ERROR, ex.getMessage().toUpperCase());
			p = new Pessoa();
		}
	}
	
	public void alterarTipoCelular(String tipo){
		if(tipo.equals("C")){
			this.PHONE_MASK = "(99)99999-9999";
		}else{
			this.PHONE_MASK = "(99)9999-9999";
		}
	}
	
	public void confPessoa(Pessoa p){
		this.pessoa = p;
		pessoa.setTelefone(new String());
		if(p.getTelefone().length() == LENGHT_CHARACTER_FIXPHONE){
			this.PHONE_MASK = "(99)9999-9999";
		}
	}
	

	
	/*##################### GETTERS AND SETTERS ################*/
	
	public List<Estado> getListEstado() {
		return listEstado;
	}
	
	public void setListEstado(List<Estado> listEstado) {
		this.listEstado = listEstado;
	}
	
	public List<SelectItem> getEstadosSI() {
		return estadosSI;
	}
	
	public void setEstadosSI(List<SelectItem> estadosSI) {
		this.estadosSI = estadosSI;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public void setCidadesSI(List<SelectItem> cidadesSI) {
		this.cidadesSI = cidadesSI;
	}
	
	public List<SelectItem> getCidadesSI() {
		return cidadesSI;
	}

	public List<Pessoa> getListPessoas() {
		return listPessoas;
	}

	public void setListPessoas(List<Pessoa> listPessoas) {
		this.listPessoas = listPessoas;
	}
	
	public void setListPessoasFiltradas(List<Pessoa> listPessoasFiltradas) {
		this.listPessoasFiltradas = listPessoasFiltradas;
	}
	
	public List<Pessoa> getListPessoasFiltradas() {
		return listPessoasFiltradas;
	}
	public void setMascaraTelefone(String PHONE_MASK) {
		PessoaBean.PHONE_MASK = PHONE_MASK;
	}
	
	public String getMascaraTelefone() {
		return PHONE_MASK;
	}
	
	public void setTipoTelefone(String tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}
	
	public String getTipoTelefone() {
		return tipoTelefone;
	}
	
}


