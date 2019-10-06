
package com.guelfi.cursomc.cursomc.services;

import java.util.Optional;
import com.guelfi.cursomc.cursomc.domain.Categoria;
import com.guelfi.cursomc.cursomc.repositories.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscar(Integer id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);

        return obj.orElse(null);
    }

}
