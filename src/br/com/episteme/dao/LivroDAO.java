package br.com.episteme.dao;

import java.util.List;

public class LivroDAO implements GenericDAO{
	private DataSource dataSource;
	
	public LivroDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void create(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Object> read(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub
		
	}

}
