/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.cefsa.fesa_share.validacao;

import java.time.Duration;
import java.time.LocalDate;

/**
 *
 * @author USUARIO
 */
public class ValidacaoPedido {
    public static boolean isDateValid(LocalDate emprestimo, LocalDate devolucao){
        return Duration.between(devolucao.atStartOfDay(), emprestimo.atStartOfDay()).toMillis() > 0;
    }
}
