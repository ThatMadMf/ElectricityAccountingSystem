package org.system.invoice;

import java.util.Date;

public class InvoiceDto {

    private int accountId;
    private double electricityUnits;
    private Date invoiceDate;

    public InvoiceDto() {
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getElectricityUnits() {
        return electricityUnits;
    }

    public void setElectricityUnits(double electricityUnits) {
        this.electricityUnits = electricityUnits;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
}


