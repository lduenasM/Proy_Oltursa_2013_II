package dao;

import java.util.List;

public interface Entidad<T> {
	
	public T insert(T t);
	
	public int update(T t);
	
	public int delete(T t);
	
	public T findById(T t);

	public List<T> listAll();

	public List<T> listT(T t);
	
	public T ultReg(T t);
	
	public List<T> listAllCustom(Object...objects);
}