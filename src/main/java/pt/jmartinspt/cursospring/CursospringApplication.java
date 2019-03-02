package pt.jmartinspt.cursospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pt.jmartinspt.cursospring.dao.CategoriaDao;
import pt.jmartinspt.cursospring.domain.Categoria;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class CursospringApplication implements CommandLineRunner {

    @Autowired
    private CategoriaDao categoriaDao;

    public static void main(String[] args) {
        SpringApplication.run(CursospringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");
        Categoria cat3 = new Categoria(null, "Armazém");
        Categoria cat4 = new Categoria(null, "Cozinha");

        categoriaDao.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));

    }
}
