package com.belyf;

public class BankAccount {

    private boolean active;
    private Integer balance = 0;

    public void open() {
        this.active = true;
    }

    public Integer getBalance() throws BankAccountActionInvalidException {
        if(!this.active) throw new BankAccountActionInvalidException("Account closed");
        return balance;
    }

    public synchronized void deposit(Integer amount) throws BankAccountActionInvalidException {
        if(!this.active) throw new BankAccountActionInvalidException("Account closed");
        if(amount < 0) throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        balance += amount;
    }

    public synchronized void withdraw(Integer amount) throws BankAccountActionInvalidException {
        if(!this.active) throw new BankAccountActionInvalidException("Account closed");
        if(amount < 0) throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        if(balance == 0) throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
        if(balance < amount) throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
        balance -= amount;
    }

    public void close() {
        this.active = false;
    }

}
