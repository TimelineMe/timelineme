package timeline.persistence;

public class DaoFactory {

	public static AgenteDao getAgenteDao(){
		return AgenteDaoJdbcImpl.getInstance(); //el que fabrica los daos, uno por cada uno de las clases
	}
	public static EmpresaDao getEmpresaDao(){
		return EmpresaDaoJdbcImpl.getInstance(); //el que fabrica los daos, uno por cada uno de las clases
	}
	public static NoticiaDao getNoticiaDao(){
		return NoticiaDaoJdbcImpl.getInstance();
	}
	public static AgenteEmpresaDao getAgenteEmpresaDao(){
		return AgenteEmpresaDaoJdbcImpl.getInstance();
	}
}
