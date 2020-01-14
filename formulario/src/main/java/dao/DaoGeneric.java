package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import formulario.Persistir;

public class DaoGeneric <E>{
	
	EntityManager entityManager = Persistir.getEntityManager();
	
	public void salvar(E entidade){
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entidade);
		transaction.commit();
	}
	
	public E UpdateMerge(E entidade){ 
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		E entidadeSalva = entityManager.merge(entidade); 
		transaction.commit();
		
		return entidadeSalva;
	}
	
	public void deletar(E entidade){
		
		Object id = Persistir.getPrimaryKey(entidade);

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		entityManager.createNativeQuery("delete from " + entidade.getClass().getSimpleName().toLowerCase() + 
				" where id = " + id).executeUpdate();
		
		transaction.commit();
	}
	
	//para teste de update
	public E pesquisar(Long id, Class<E> entidade){
		E e = (E) entityManager.find(entidade,id);
		return e;
	}
	
	//método não genérico
	public List<E> buscarPorNome (Class<E> entidade, String nome){
		
		List<E> lista = entityManager.createQuery("select u from Usuario u where u.nome like :pnome").setParameter("pnome","%" + nome + "%").getResultList();
		
		return lista;
	}
	
	public List<E> listar (Class<E> entidade){
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		List<E> lista  = entityManager.createQuery("from " + entidade.getName()).getResultList(); 
		
		transaction.commit();
		return lista;
	}
}
