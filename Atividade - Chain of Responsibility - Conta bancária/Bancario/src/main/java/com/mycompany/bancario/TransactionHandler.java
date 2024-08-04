/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancario;

/**
 *
 * @author 55649
 */

public interface TransactionHandler {
    void setNextHandler(TransactionHandler nextHandler);
    void handleTransaction(Transaction transaction);
}


