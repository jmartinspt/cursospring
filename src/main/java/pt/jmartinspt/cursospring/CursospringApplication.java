package pt.jmartinspt.cursospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pt.jmartinspt.cursospring.dao.*;
import pt.jmartinspt.cursospring.domain.*;
import pt.jmartinspt.cursospring.domain.enums.EstadoPagamento;
import pt.jmartinspt.cursospring.domain.enums.TipoCliente;

import java.text.SimpleDateFormat;
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

    @Autowired
    private ClienteDao clienteDao;

    @Autowired
    private EnderecoDao enderecoDao;


    @Autowired
    private PedidoDao pedidoDao;

    @Autowired
    private PagamentoDao pagamentoDao;

    @Autowired
    private ItemPedidoDao itemPedidoDao;

    public static void main(String[] args) {
        SpringApplication.run(CursospringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");
        Categoria cat3 = new Categoria(null, "Armazém");
        Categoria cat4 = new Categoria(null, "Cozinha");


        Produto prod1 = new Produto(null, "Computador", 1500.00);
        Produto prod2 = new Produto(null, "Teclado", 50.00);
        Produto prod3 = new Produto(null, "Armário", 800.00);
        Produto prod4 = new Produto(null, "Microondas", 200.00);
        Produto prod5 = new Produto(null, "Torradeira", 80.00);
        Produto prod6 = new Produto(null, "Cadeira ergonómica", 250.00);
        Produto prod7 = new Produto(null, "Escadote", 35.00);


        Distrito dist1 = new Distrito(null, "Viana do Castelo");
        Distrito dist2 = new Distrito(null, "Porto");
        Distrito dist3 = new Distrito(null, "Braga");

        Cidade cid1 = new Cidade(null, "Alvarães", dist1);
        Cidade cid2 = new Cidade(null, "Valença", dist1);
        Cidade cid3 = new Cidade(null, "Matosinhos", dist2);
        Cidade cid4 = new Cidade(null, "Gaia", dist2);
        Cidade cid5 = new Cidade(null, "Guimarães", dist3);
        Cidade cid6 = new Cidade(null, "Fafe", dist3);


        Cliente cli1 = new Cliente(null, "Joel Martins", "jmartins.com@gmail.com", 207199844, TipoCliente.PARTICULAR);
        Cliente cli2 = new Cliente(null, "SPMS", "spms-general.min-saude.pt", 507886312, TipoCliente.EMPRESARIAL);


        Endereco end1 = new Endereco(null, "Rua da Igreja", "175", null, "4905-205", "Alvarães", cid1, cli1);
        Endereco end2 = new Endereco(null, "Travessa da Carvalhosa", "37/39", "RC", "4050-169", "Cedofeita", cid3, cli1);
        Endereco end3 = new Endereco(null, "Rua do Breiner", "124", "RC", "4050-121", "Cedofeita", cid3, cli2);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Pedido ped1 = new Pedido(null, sdf.parse("13/04/2018 18:50"), cli1, end1);
        Pedido ped2 = new Pedido(null, sdf.parse("10/04/2018 08:55"), cli1, end2);

        Pagamento pag1 = new PagamentoCartao(null, EstadoPagamento.REALIZADO, ped1, 6);
        ped1.setPagamento(pag1);

        Pagamento pag2 = new PagamentoCheque(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("10/07/2018 08:57"), null);
        ped2.setPagamento(pag2);


        cat1.getProdutos().addAll(Arrays.asList(prod1, prod2));
        cat2.getProdutos().addAll((Arrays.asList(prod6)));
        cat3.getProdutos().addAll(Arrays.asList(prod3, prod7));
        cat4.getProdutos().addAll(Arrays.asList(prod4, prod5));

        prod1.getCategorias().addAll(Arrays.asList(cat1));
        prod2.getCategorias().addAll(Arrays.asList(cat1));
        prod3.getCategorias().addAll(Arrays.asList(cat3));
        prod4.getCategorias().addAll(Arrays.asList(cat4));
        prod5.getCategorias().addAll(Arrays.asList(cat4));
        prod6.getCategorias().addAll(Arrays.asList(cat2));
        prod7.getCategorias().addAll(Arrays.asList(cat3));


        dist1.getCidades().addAll(Arrays.asList(cid1, cid2));
        dist2.getCidades().addAll(Arrays.asList(cid3, cid4));
        dist3.getCidades().addAll(Arrays.asList(cid5, cid6));


        cli1.getTelefones().addAll(Arrays.asList("962422378", "258771254"));
        cli2.getTelefones().addAll(Arrays.asList("93900123", "250777644"));
        cli1.getEnderecos().addAll(Arrays.asList(end1, end2));
        cli2.getEnderecos().addAll(Arrays.asList(end3));


        categoriaDao.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
        produtoDao.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5, prod6, prod7));
        distritoDao.saveAll(Arrays.asList(dist1, dist2, dist3));
        cidadeDao.saveAll(Arrays.asList(cid1, cid2, cid3, cid4, cid5, cid6));
        clienteDao.saveAll(Arrays.asList(cli1, cli2));
        enderecoDao.saveAll(Arrays.asList(end1, end2, end3));

        cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));

        pedidoDao.saveAll(Arrays.asList(ped1,ped2));
        pagamentoDao.saveAll(Arrays.asList(pag1,pag2));

        ItemPedido ip1 = new ItemPedido(ped1,prod1, 0.00, 1, 2000.00);
        ItemPedido ip2 = new ItemPedido(ped1,prod3, 0.00, 2, 80.00);
        ItemPedido ip3 = new ItemPedido(ped2,prod2, 100.00, 1, 800.00);


        ped1.getItems().addAll(Arrays.asList(ip1,ip2));
        ped2.getItems().addAll(Arrays.asList(ip3));

        prod1.getItems().addAll(Arrays.asList(ip1));
        prod2.getItems().addAll(Arrays.asList(ip3));
        prod3.getItems().addAll(Arrays.asList(ip2));

        itemPedidoDao.saveAll(Arrays.asList(ip1,ip2,ip3)); 


    }
}
