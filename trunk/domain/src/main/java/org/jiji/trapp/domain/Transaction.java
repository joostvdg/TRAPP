package org.jiji.trapp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.jiji.trapp.domain.listener.Auditor;



/**
 *
 * @author jvdgriendt
 */
@Entity
@EntityListeners(Auditor.class)
public class Transaction extends ModelBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne(optional=false)
    private Account accountFrom;

    @ManyToOne(optional=false)
    private Account accountTo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionTimestamp;

    @Column(nullable=false)
    private BigDecimal mutation;

    @Column(length=255, nullable=false)
    private String description;

    /**
     * Default constructor voor persistence.
     */
    protected Transaction(){
        super();
    }

    /**
     *
     * @param rekeningVan
     * @param rekeningNaar
     */
    public Transaction(Account accountFrom, Account accountTo, BigDecimal mutation){
        this();
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.mutation = mutation;
        transactionTimestamp = new Date();
    }

    public Account getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(Account accountFrom) {
        this.accountFrom = accountFrom;
    }

    public Account getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(Account accountTo) {
        this.accountTo = accountTo;
    }

    public Date getTransactionTimestamp() {
        return transactionTimestamp;
    }

    public void setTransactionTimestamp(Date transactionTimestamp) {
        this.transactionTimestamp = transactionTimestamp;
    }

    public BigDecimal getMutation() {
        return mutation;
    }

    public void setMutation(BigDecimal mutation) {
        this.mutation = mutation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
