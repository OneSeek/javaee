package service;

import java.util.List;

import vo.Bj;

public interface IBjService {
	
	void add(Bj bj);

	public void update(Bj bj);

	public void delete(int id);

	public Bj findById(int id);

	public List<Bj> queryAll();

}
