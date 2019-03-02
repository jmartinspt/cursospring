package pt.jmartinspt.cursospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pt.jmartinspt.cursospring.dao.CategoriaDao;
import pt.jmartinspt.cursospring.dao.CidadeDao;
import pt.jmartinspt.cursospring.dao.DistritoDao;
import pt.jmartinspt.cursospring.dao.ProdutoDao;
import pt.jmartinspt.cursospring.domain.Categoria;
import pt.jmartinspt.cursospring.domain.Cidade;
import pt.jmartinspt.cursospring.domain.Distrito;
import pt.jmartinspt.cursospring.domain.Produto;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class CursospringApplication implements CommandLineRunner {

    @Autowired
    private CategoriaDao categoriaDao;

    @Autowired
    private ProdutoDao produtoDao;

    @Autowired
    private CidadeDao cidadeDao;

    @Autowired
    private DistritoDao distritoDao;

    public static void main(String[] args) {
        SpringApplication.run(CursospringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");
        Categoria cat3 = new Categoria(null, "Armazém");
        Categoria cat4 = new Categoria(null, "Cozinha");


        Produto prod1 = new Produto(null,"Computador",1500.00);
        Produto prod2 = new Produto(null,"Teclado",50.00);
        Produto prod3 = new Produto(null,"Armário",800.00);
        Produto prod4 = new Produto(null,"Microondas",200.00);
        Produto prod5 = new Produto(null,"Torradeira",80.00);
        Produto prod6 = new Produto(null,"Cadeira ergonómica",250.00);
        Produto prod7 = new Produto(null,"Escadote",35.00);


        Distrito dist1 = new Distrito(null,"Viana do Castelo");
        Distrito dist2 = new Distrito(null,"Porto");
        Distrito dist3 = new Distrito(null,"Braga");

        Cidade cid1 = new Cidade(null, "Alvarães", dist1);
        Cidade cid2= new Cidade(null, "Valença", dist1);
        Cidade cid3 = new Cidade(null, "Matosinhos", dist2);
        Cidade cid4 = new Cidade(null, "Gaia", dist2);
        Cidade cid5 = new Cidade(null, "Guimarães", dist3);
        Cidade cid6 = new Cidade(null, "Fafe", dist3);


        cat1.getProdutos().addAll(Arrays.asList(prod1,prod2));
        cat2.getProdutos().addAll((Arrays.asList(prod6)));
        cat3.getProdutos().addAll(Arrays.asList(prod3,prod7));
        cat4.getProdutos().addAll(Arrays.asList(prod4,prod5));

        prod1.getCategorias().addAll(Arrays.asList(cat1));
        prod2.getCategorias().addAll(Arrays.asList(cat1));
        prod3.getCategorias().addAll(Arrays.asList(cat3));
        prod4.getCategorias().addAll(Arrays.asList(cat4));
        prod5.getCategorias().addAll(Arrays.asList(cat4));
        prod6.getCategorias().addAll(Arrays.asList(cat2));
        prod7.getCategorias().addAll(Arrays.asList(cat3));


        dist1.getCidades().addAll(Arrays.asList(cid1,cid2));
        dist2.getCidades().addAll(Arrays.asList(cid3,cid4));
        dist3.getCidades().addAll(Arrays.asList(cid5,cid6));

        categoriaDao.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
        produtoDao.saveAll(Arrays.asList(prod1,prod2,prod3,prod4,prod5,prod6,prod7));
        distritoDao.saveAll(Arrays.asList(dist1,dist2,dist3));
        cidadeDao.saveAll(Arrays.asList(cid1,cid2,cid3,cid4,cid5,cid6));



    }
}
