/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancario;

/**
 *
 * @author 55649
 */
public class DepositHandler implements TransactionHandler {
    private TransactionHandler nextHandler;

    @Override
    public void setNextHandler(TransactionHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleTransaction(Transaction transaction) {
        if ("DEPOSIT".equals(transaction.getType())) {
            if (transaction.getAmount() > 0) {
                transaction.getDestinationAccount().deposit(transaction.getAmount());
                System.out.println("Deposito de: " + transaction.getAmount());
            } else {
                System.out.println("Valor de deposito invalido. O valor deve ser maior que 0.");
            }
        } else if (nextHandler != null) {
            nextHandler.handleTransaction(transaction);
        }
    }
}





  




