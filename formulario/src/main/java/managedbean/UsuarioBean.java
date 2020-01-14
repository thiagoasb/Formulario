package managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import dao.DaoGeneric;
import entidades.Usuario;

@ManagedBean(name="usuarioBean")
@ViewScoped
public class UsuarioBean {
	
	private Usuario user = new Usuario();
	private List<Usuario> listaUser = new ArrayList<Usuario>();
	private DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();
	
	private List<Usuario> listaPesquisado = new ArrayList<Usuario>();
	private String parametro;

	
	@PostConstruct
	public void listar(){
		listaUser = daoGeneric.listar(Usuario.class);
	}
	
	public void buscarListarNome(){
		listaPesquisado = daoGeneric.buscarPorNome(Usuario.class, parametro);
	}
	
	public Usuario getUser() {
		return user;
	}
	
	public void setUser(Usuario user) {
		this.user = user;
	}

	public List<Usuario> getListaUser() {
		return listaUser;
	}

	public void setListaUser(List<Usuario> listaUser) {
		this.listaUser = listaUser;
	}
	
	public List<Usuario> getListaPesquisado() {
		return listaPesquisado;
	}

	public void setListaPesquisado(List<Usuario> listaPesquisado) {
		this.listaPesquisado = listaPesquisado;
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	private void mostrarMsg(String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(msg);
		context.addMessage(null, message);
		
	}
	
	public String salvar(){
		user = daoGeneric.UpdateMerge(user);
		listar();
		mostrarMsg("Cadastrado com sucesso!");

		return "";
	}
	
	public String novo(){
		user = new Usuario();
		return "";
	}
	
	public String remover(){

		daoGeneric.deletar(user);
		listar();
		user = new Usuario();
		mostrarMsg("Removido com sucesso!");
		
		return "";
		
	}

	
	
}
