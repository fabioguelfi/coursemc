package com.guelfi.curso.api;

import java.util.Arrays;

import com.guelfi.curso.api.domain.Categoria;
import com.guelfi.curso.api.domain.Cidade;
import com.guelfi.curso.api.domain.Estado;
import com.guelfi.curso.api.domain.Produto;
import com.guelfi.curso.api.repositories.CategoriaRepository;
import com.guelfi.curso.api.repositories.CidadeRepository;
import com.guelfi.curso.api.repositories.EstadoRepository;
import com.guelfi.curso.api.repositories.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursoApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    public static void main(String[] args) {
        SpringApplication.run(CursoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "informatica");
        Categoria cat2 = new Categoria(null, "escritorio");

        Produto prod1 = new Produto(null, "Computador", 2000.00);
        Produto prod2 = new Produto(null, "Impressora", 800.00);
        Produto prod3 = new Produto(null, "Mouse", 80.00);

        cat1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
        cat2.getProdutos().addAll(Arrays.asList(prod2));

        prod1.getCategorias().addAll(Arrays.asList(cat1));
        prod2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        prod3.getCategorias().addAll(Arrays.asList(cat1));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3));

        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "São Paulo");

        Cidade cid1 = new Cidade(null, "Uberlandia", est1);
        Cidade cid2 = new Cidade(null, "Osasco", est2);
        Cidade cid3 = new Cidade(null, "Campinas", est2);

        est1.getCidades().addAll(Arrays.asList(cid1));
        est2.getCidades().addAll(Arrays.asList(cid2, cid3));

        estadoRepository.saveAll(Arrays.asList(est1, est2));
        cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
    }

}
