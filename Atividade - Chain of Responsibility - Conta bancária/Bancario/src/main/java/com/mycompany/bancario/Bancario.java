/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bancario;

/**
 *
 * @author 55649
 */
public class Bancario {

    public static void main(String[] args) {
        
        Account conta01 = new Account(900);
        Account conta02 = new Account(100);

        // Criar manipuladores
        DepositHandler depositHandler = new DepositHandler();
        WithdrawHandler withdrawHandler = new WithdrawHandler();
        TransferHandler transferHandler = new TransferHandler();

        // Configurar cadeia de responsabilidade
        depositHandler.setNextHandler(withdrawHandler);
        withdrawHandler.setNextHandler(transferHandler);

        // Processar transações
        Transaction depositTransaction = new Transaction("DEPOSIT", 109, null, conta01);
        Transaction withdrawTransaction = new Transaction("WITHDRAW", 322, conta01, null);
        Transaction transferTransaction = new Transaction("TRANSFER", 222, conta01, conta02);
        Transaction invalidDepositTransaction = new Transaction("DEPOSIT", -50, null, conta01); 
        Transaction invalidWithdrawTransaction = new Transaction("WITHDRAW", 1500, conta01, null); 
        Transaction invalidTransferTransaction = new Transaction("TRANSFER", 100, null, conta02); 
        Transaction invalidTransaction = new Transaction("INVALID", 0, null, null);

        depositHandler.handleTransaction(depositTransaction);
        withdrawHandler.handleTransaction(withdrawTransaction);
        transferHandler.handleTransaction(transferTransaction);
        depositHandler.handleTransaction(invalidDepositTransaction); 
        withdrawHandler.handleTransaction(invalidWithdrawTransaction); 
        transferHandler.handleTransaction(invalidTransferTransaction); 
        depositHandler.handleTransaction(invalidTransaction); 
    }
}








        
        
        
    
