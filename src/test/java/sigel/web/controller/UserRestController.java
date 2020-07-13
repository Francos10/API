package sigel.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sigel.web.entity.User;
import sigel.web.service.UserService;

//controlador rest
@RestController
@RequestMapping("/api") //localhost:8080/api/


public class UserRestController {
	
	//Inyeccion del servicio
		@Autowired
		private UserService userService;

		/*Este método GET que llama la url 
		localhost:8080/api/users*/
		@GetMapping("/users")
		public List<User> findAll(){
			//retornará todos los usuarios
			return userService.findAll();
		}
		
		/*Este método GET que llama la url + el id ingresado
		localhost:8080/api/users*/
		@GetMapping("/users/{userId}")
		public User getUser(@PathVariable int userId){
			User user = userService.findById(userId);
			
			if(user == null) {
				throw new RuntimeException("User id not found -"+userId);
			}
			//retornará al usuario con id pasado en la url
			return user;
		}
		
		/*Este método POST que llama la url 
		localhost:8080/api/users*/
		@PostMapping("/users")
		public User addUser(@RequestBody User user) {
			user.setId(0);
			
			//Este metodo guardará al usuario enviado en el JSON en la BD
			userService.save(user);
			
			return user;
			
		}
		/*Este método PUT que llama la url 
		localhost:8080/api/users*/
		@PutMapping("/users")
		public User updateUser(@RequestBody User user) {
			
			userService.save(user);
			
			//este metodo actualizará al usuario enviado en el JSON en la BD
			
			return user;
		}
		
		/*Este método DELETE que llama la url + el id ingresado
		localhost:8080/api/users*/
		@DeleteMapping("users/{userId}")
		public String deteteUser(@PathVariable int userId) {
			
			User user = userService.findById(userId);
			
			if(user == null) {
				throw new RuntimeException("User id not found -"+userId);
			}
			
			userService.deleteById(userId);
			
			//Esto método, recibira el id de un usuario por URL y se borrará de la bd.
			return "Deleted user id - "+userId;
		}

}
