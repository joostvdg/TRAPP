package org.jiji.trapp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author jvdgriendt
 */
@Entity
public class SavingsAccount extends Account implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigDecimal interest;

    @OneToOne(optional=false)
    private CreditAccount attachedAccount;

    public SavingsAccount(String accountNumber) {
        super(accountNumber);
        interest = new BigDecimal(0.0);
    }

    public SavingsAccount(BigDecimal balance, String accountNumber) {
        super(balance, accountNumber);
        interest = new BigDecimal(0.0);
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public CreditAccount getAttachedAccount() {
        return attachedAccount;
    }

    public void setAttachedAccount(CreditAccount attachedAccount) {
        this.attachedAccount = attachedAccount;
    }

    @Override
    public String toString() {
        return String.format("%s[id=%d, accountNumber=%s, balance=%d, interest=%d]", getClass().getSimpleName(), getAccountNumber(), getBalance(), interest);
    }

}
