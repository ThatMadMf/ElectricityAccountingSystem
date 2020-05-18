package org.system.invoice;

import java.time.LocalDate;

public class InvoiceDto {

    private int accountId;
    private double electricityUnits;
    private LocalDate invoiceDate;

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

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
}


