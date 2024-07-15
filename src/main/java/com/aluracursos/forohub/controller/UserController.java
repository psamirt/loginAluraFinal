package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.model.User;
import com.aluracursos.forohub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("crear")
    public String post(@RequestBody User user) {
        userRepository.save(user);
        return "Creado";
    }

    @GetMapping("editar/{id}")
    public String update(@PathVariable Long id, @RequestBody User user) {
        User updateUser = userRepository.findById(id).get();
        updateUser.setNombre(user.getNombre());
        userRepository.save(updateUser);
        return "Editado correctamente";
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        User deleteUser = userRepository.findById(id).get();
        userRepository.delete((deleteUser));
        return "Eliminado";
    }

}
