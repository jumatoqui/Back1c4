
package mintic.usa.ciclo4.web.servicios;

import java.util.List;
import java.util.Optional;
import mintic.usa.ciclo4.web.modelos.User;
import mintic.usa.ciclo4.web.repositorios.crud.RepositorioUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Oscar
 */
@Service
public class ServicioUser {
    @Autowired
    private RepositorioUser repositorioUser;
    
    public List<User> getAll(){
        return (List<User>) repositorioUser.getAll();
    }
    
    public Optional<User> getUser(int idUser){
        return repositorioUser.getUser(idUser);
    }
    
    public void save(User user){
        if(user.getId()==null){
            repositorioUser.save(user);
        }else {
            Optional<User> obtener = repositorioUser.getUser(user.getId());
            if (obtener.isEmpty()) {
                repositorioUser.save(user);
            }
        }
    }
    
    /*public boolean existeEmail(String email){
        Boolean existe = getEmailById(emailId).map(email->{
        repositorioUser.existeEmail(email);
        return true;
        }).orElse(other: false);
        return existe;
    }*/
    
    
    public boolean existe(String email){
     
        Optional<User> objeto= repositorioUser.existe(email);
        System.out.println(objeto.toString());
        if(objeto.isEmpty()){
            return false;
        }
        return true;
    }
    
}
