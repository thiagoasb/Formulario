package formulario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Persistir {
	
	public static EntityManagerFactory factory = null;
	
	static {
		init();
	}
	
	private static void init(){
		try{
			if(factory == null){
				factory = Persistence.createEntityManagerFactory("formulario");
			}
		} catch (Exception e){ 
			e.printStackTrace();
		}
	}
	
	public static EntityManager getEntityManager(){
		
		return factory.createEntityManager();
	}
	
	public static Object getPrimaryKey(Object obj){
		
		return factory.getPersistenceUnitUtil().getIdentifier(obj);
	}
}
