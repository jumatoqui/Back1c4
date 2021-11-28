
package mintic.usa.ciclo4.web.repositorios.crud;

import java.util.List;
import java.util.Optional;
import mintic.usa.ciclo4.web.modelos.User;
import mintic.usa.ciclo4.web.repositorios.InterfaceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Oscar
 */
@Repository
public class RepositorioUser {
    @Autowired
    private InterfaceUser crud;
    
    public List<User> getAll(){
        return (List<User>) crud.findAll();
    }
    
    public Optional<User> getUser(int idUser){
        return crud.findById(idUser);
    }
    
    public User save(User user){
        return crud.save(user);
    }
    
    public Optional<User> existe(String email){
        return crud.findByEmail(email);
    }
    
}
