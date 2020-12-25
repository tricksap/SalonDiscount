package com.DiscountSystem;

import java.util.Date;

public class Visit extends Customer {
    private Customer name ;


    private int date;
    private double serviceExpense ;
    private double productExpense ;

    public  Visit(Customer name)
    {
        this.name = name;
    }
    public Visit(Customer name,int date)
    {
        this.name = name;
        this.date = date;
    }

    @Override
    public String getName()
    {
        return name.getName();
    }

    public void reset ()
    {
        serviceExpense = 0;
        productExpense = 0;
    }


    public double getServiceExpense() {
        return serviceExpense;
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = this.serviceExpense + serviceExpense;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = this.productExpense + productExpense;
    }

    public double getTotalExpense() {
        return (serviceExpense - (serviceExpense * DiscountRate.getServiceDiscountRate(name.getMemberType()))) +
                (productExpense - (productExpense * DiscountRate.getProductDiscountRate(name.getMemberType())));
    }
    public int getDate() {
        return date;
    }
    public void setDate(int date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Visit{" +
                "date=" + date +
                ", serviceExpense=" + serviceExpense +
                ", productExpense=" + productExpense +
                ", name='" + name + '\'' +
                '}';
    }
}
