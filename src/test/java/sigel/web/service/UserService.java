package sigel.web.service;

import java.util.List;

import sigel.web.entity.User;


public interface UserService {
	
public List<User> findAll();
	
	public User findById(int id);
	
	public void save(User user);
	
	public void deleteById(int id);

}
