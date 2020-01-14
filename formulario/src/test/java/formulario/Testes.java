package formulario;

import java.util.List;
import org.junit.Test;
import dao.DaoGeneric;
import entidades.Usuario;

public class Testes {
	
	@Test
	public void testeFactory(){
		Persistir.getEntityManager();
	}
	
	@Test
	public void testeSalvar(){
		 
		DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();
		Usuario user = new Usuario();
		
		user.setLogin("admin");
		user.setSenha("admin"); 
		user.setNome("Testando");
		
		daoGeneric.salvar(user);
		
		System.out.println(user);
		
	}
	
	@Test
	public void testeMerge(){
		DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();
		Usuario user = daoGeneric.pesquisar(71L,Usuario.class);
		
		user.setNome("teste");
		user.setLogin("test");
		user.setSenha("test");
		user.setEmail("test@email.com");
		user.setNascimento("09/08/1999");
		user.setSexo("MASCULINO");
		
		user = daoGeneric.UpdateMerge(user);
		
		System.out.println(user);
	}
	
	@Test
	public void testeDeletar(){

		DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();
		Usuario user = new Usuario();

		user.setId(71L);

		daoGeneric.deletar(user);


	}
	
	@Test
	public void testeListar(){
		DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();
		
		List<Usuario> list =  daoGeneric.listar(Usuario.class);
		
		for (Usuario usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
			System.out.println("------------------------------");
		}

	}
	
	@Test
	public void buscarPorNome(){
		DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();
		
		List<Usuario> list = daoGeneric.buscarPorNome(Usuario.class, "teste");
		
		for (Usuario usuario : list) {
			System.out.println(usuario);
		}
	}
	
}
