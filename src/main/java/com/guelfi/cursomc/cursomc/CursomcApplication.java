package com.guelfi.cursomc.cursomc;

import java.util.Arrays;

import com.guelfi.cursomc.cursomc.domain.Categoria;
import com.guelfi.cursomc.cursomc.repositories.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public static void main(String[] args) {
        SpringApplication.run(CursomcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "informatica");
        Categoria cat2 = new Categoria(null, "escritorio");

        this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
    }

}
