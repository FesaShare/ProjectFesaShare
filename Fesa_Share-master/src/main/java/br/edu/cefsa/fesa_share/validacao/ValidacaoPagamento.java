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
public class ValidacaoPagamento {
    public static boolean isPago (String status, LocalDate diaPagamento){
        if("Alugado".equals(status)){
            return Duration.between(LocalDate.now().atStartOfDay(), diaPagamento.atStartOfDay()).toMillis() >= 0; 
        }
        return false;
    }
}
