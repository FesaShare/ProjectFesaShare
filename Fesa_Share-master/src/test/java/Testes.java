/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import br.edu.cefsa.fesa_share.models.Produto;
import static br.edu.cefsa.fesa_share.validacao.ValidacaoAluguel.isAlugado;
import static br.edu.cefsa.fesa_share.validacao.ValidacaoAluguel.isDisponivel;
import static br.edu.cefsa.fesa_share.validacao.ValidacaoPagamento.isPago;
import static br.edu.cefsa.fesa_share.validacao.ValidacaoPedido.isDateValid;
import static br.edu.cefsa.fesa_share.validacao.ValidacaoUsuario.isPhoneValid;
import static br.edu.cefsa.fesa_share.validacao.ValidacaoUsuario.isValidEmailAddress;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 *
 * @author USUARIO
 */
public class Testes {
    
    public Testes() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {}
    
     @Test
     public void numeroTelefone(){
        String numero = "123456789";
        Assertions.assertTrue(isPhoneValid(numero));
     }
     
    @Test
    public void email(){
        String email = "teste@primeiro.2@gmail.com";
        Assertions.assertFalse(isValidEmailAddress(email));
    }
    
    @Test
    public void dataEmprestimo(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
        LocalDate emprestimo = LocalDate.parse("2022-nov-28",format);
        LocalDate devolucao = LocalDate.parse("2022-nov-11",format);
        Assertions.assertFalse(isDateValid(emprestimo, devolucao));
    }
    
    @Test
    public void dataPagamento(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
        LocalDate emprestimo = LocalDate.parse("2022-nov-12",format);
        Assertions.assertTrue(isPago("Alugado", emprestimo));
    }
    
    @Test
    public void produtoAlugado(){
        Produto prod = new Produto(1, 1, 1, 12, null, null, null, "Alugado", 0, null, 2);
        Assertions.assertEquals(1, isAlugado("Alugado", prod));
    }
    
    @Test
    public void produtoDisponivel(){
        Produto prod = new Produto(3, 1, 1, 12, null, null, null, "Alugado", 0, null, 2);
        Assertions.assertNotEquals(1, isDisponivel("Disponivel", prod));
    }
}
