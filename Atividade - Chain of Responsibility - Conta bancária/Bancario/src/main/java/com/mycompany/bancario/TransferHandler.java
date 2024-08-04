/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancario;

/**
 *
 * @author 55649
 */ 
// Manipulador de Transferência
public class TransferHandler implements TransactionHandler {
    private TransactionHandler nextHandler;

    @Override
    public void setNextHandler(TransactionHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleTransaction(Transaction transaction) {
        if ("TRANSFER".equals(transaction.getType())) {
            if (transaction.getSourceAccount() == null || transaction.getDestinationAccount() == null) {
                System.out.println("Transferencia invalida. A conta de origem ou destino é nula.");
                return;
            }

            if (transaction.getSourceAccount().transfer(transaction.getDestinationAccount(), transaction.getAmount())) {
                System.out.println("Transferido: " + transaction.getAmount());
            } else {
                System.out.println("Saldo insuficiente para transferencia.");
            }
        } else if (nextHandler != null) {
            nextHandler.handleTransaction(transaction);
        }
    }
}







