package org.jiji.trapp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;

import org.jiji.trapp.domain.listener.Auditor;



/**
 *
 * @author jvdgriendt
 */
@Entity
@EntityListeners(Auditor.class)
public abstract class Account extends ModelBase implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final BigDecimal STARTING_BALANCE = new BigDecimal(0.0);

    @Column(length=40)
    private String accountNumber;

    @Column
    private BigDecimal balance;

    @ManyToOne(cascade=CascadeType.ALL)
    private User owner;

    public Account(BigDecimal balance, String accountNumber){
        super();
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public Account(String accountNumber){
        this(STARTING_BALANCE, accountNumber);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = (prime * result) + ((accountNumber == null) ? 0 : accountNumber.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Account other = (Account) obj;
        if (accountNumber == null) {
            if (other.accountNumber != null) {
                return false;
            }
        }
        else if (!accountNumber.equals(other.accountNumber)) {
            return false;
        }
        return true;
    }


}
