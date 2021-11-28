/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.usa.ciclo4.web.repositorios;

import java.util.List;
import java.util.Optional;
import mintic.usa.ciclo4.web.modelos.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Oscar
 */
public interface InterfaceUser extends CrudRepository<User, Integer> {
    
    public Optional<User> findByEmail(String email);
   
}
