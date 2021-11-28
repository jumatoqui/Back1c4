
package mintic.usa.ciclo4.web.controladores;

import java.util.List;
import java.util.Optional;
import mintic.usa.ciclo4.web.modelos.User;
import mintic.usa.ciclo4.web.servicios.ServicioUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ControladorUser {
    @Autowired
    private ServicioUser servicios;
    
    @GetMapping("/all")
    public List<User> getUsers() {
        return servicios.getAll();
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody User user) {
        servicios.save(user);
    }
    
    @GetMapping("/{email}")
    public boolean existe(@PathVariable("email") String email) {
        return servicios.existe(email);
    }
    
    @GetMapping("/{email}/{password}")
    public User existeUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return null;
    }
}
