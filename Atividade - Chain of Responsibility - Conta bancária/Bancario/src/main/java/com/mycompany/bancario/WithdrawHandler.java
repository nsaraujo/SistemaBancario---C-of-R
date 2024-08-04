/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancario;

/**
 *
 * @author 55649
 */
// Manipulador de Saque
public class WithdrawHandler implements TransactionHandler {
    private TransactionHandler nextHandler;

    @Override
    public void setNextHandler(TransactionHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleTransaction(Transaction transaction) {
        if ("WITHDRAW".equals(transaction.getType())) {
            if (transaction.getSourceAccount().withdraw(transaction.getAmount())) {
                System.out.println("Saque de: " + transaction.getAmount());
            } else {
                System.out.println("Saldo insuficiente para saque.");
            }
        } else if (nextHandler != null) {
            nextHandler.handleTransaction(transaction);
        }
    }
}




     



