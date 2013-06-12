package org.jiji.trapp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;


/**
 *
 * @author jvdgriendt
 */
@Entity
public class CreditAccount extends Account implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigDecimal credit;

    public CreditAccount(BigDecimal credit, String accountNumber){
        super(accountNumber);
        setCredit(credit);
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return String.format("%s[id=%d, accoutNumber=%s, balance=%d, credit=%d]",getClass().getSimpleName(),getId(), getAccountNumber(), getBalance(), credit);
    }

}
