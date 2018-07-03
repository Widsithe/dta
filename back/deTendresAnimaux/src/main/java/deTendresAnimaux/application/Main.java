package deTendresAnimaux.application;

import org.springframework.beans.factory.annotation.Autowired;

import deTendresAnimaux.dao.AdminDao;



public class Main {
	
	@Autowired
	private AdminDao adminDao;
	
	
	
	public void start() throws InterruptedException {
		//System.out.println(repositoryDao.ligneInsert(user1));
		//System.out.println(userDao.getListUser());

	}

}
