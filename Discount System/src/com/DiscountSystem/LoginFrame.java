package com.DiscountSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener
{
    Customer customer = new Customer();
    Visit visit = new Visit(customer);
    Container container = getContentPane();
    JLabel name = new JLabel("Name");
    JTextField nameField = new JTextField();

    JLabel memberLabel = new JLabel("Are You A Member?");
    JCheckBox memberYes= new JCheckBox();
    JCheckBox memberNo = new JCheckBox();
    JLabel yes = new JLabel("Yes");
    JLabel no = new JLabel("No");

    JLabel memberType = new JLabel("Member Type:");
    JCheckBox premium = new JCheckBox();
    JCheckBox gold = new JCheckBox();
    JCheckBox silver = new JCheckBox();
    JLabel premiumLabel = new JLabel("Premium");
    JLabel goldLabel = new JLabel("Gold");
    JLabel silverLabel = new JLabel("Silver");


    JLabel dateLabel = new JLabel("Date (dd/mm/yy)");
    JTextField dateField = new JTextField();

    JLabel serviceLabel = new JLabel("Service Avail:");
    JButton haircut = new JButton("Haircut 40");


    JLabel productLabel = new JLabel("Product Avail:");

    JTextArea result = new JTextArea();

    JButton loginButton = new JButton("TOTAL");
    JButton resetButton = new JButton("RESET");

    LoginFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        name.setBounds(20, 50, 100, 30);
        nameField.setBounds(100, 50, 200, 30);

        memberLabel.setBounds(20,100,200,30);
        memberYes.setBounds(170,100,50,30);
        memberNo.setBounds(250,100,50,30);
        yes.setBounds(170,120,80,30);
        no.setBounds(250,120,80,30);

        memberType.setBounds(20,150,100,30);
        premium.setBounds(150,150,50,30);
        gold.setBounds(210,150,50,30);
        silver.setBounds(270,150,50,30);
        premiumLabel.setBounds(130,170,100,30);
        goldLabel.setBounds(205,170,50,30);
        silverLabel.setBounds(260,170,50,30);


        dateLabel.setBounds(20, 210, 100, 30);
        dateField.setBounds(115, 210, 175, 30);

        serviceLabel.setBounds(50,250,100,30);
        haircut.setBounds(40,280,100,30);

        productLabel.setBounds(220,250,100,30);

        result.setBounds(125,450,100,30);

        loginButton.setBounds(50, 500, 100, 30);
        resetButton.setBounds(200, 500, 100, 30);
    }

    public void addComponentsToContainer() {
        container.add(name);
        container.add(nameField);

        container.add(memberLabel);
        container.add(memberYes);
        container.add(memberNo);
        container.add(yes);
        container.add(no);

        container.add(memberType);
        container.add(premium);
        container.add(gold);
        container.add(silver);
        container.add(premiumLabel);
        container.add(goldLabel);
        container.add(silverLabel);

        container.add(dateLabel);
        container.add(dateField);

        container.add(serviceLabel);
        container.add(haircut);

        container.add(productLabel);

        container.add(result);

        container.add(loginButton);
        container.add(resetButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);

        memberNo.addActionListener(this);
        memberYes.addActionListener(this);

        gold.addActionListener(this);
        premium.addActionListener(this);
        silver.addActionListener(this);

        haircut.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            visit.setName(nameField.getText());
            customer.setName(nameField.getText());
            visit.setDate(Integer.parseInt(dateField.getText()));
            result.setText("Total:"+visit.getTotalExpense());
            System.out.println(visit.toString());
        }

        if (e.getSource() == memberNo)
        {
            customer.setMemberType(" ");
            customer.setMember(false);
            memberYes.setSelected(false);
            premium.setSelected(false);
            gold.setSelected(false);
            silver.setSelected(false);
            premium.setEnabled(false);
            gold.setEnabled(false);
            silver.setEnabled(false);
        }

        if (e.getSource() == memberYes)
        {
            customer.setMember(true);
            memberNo.setSelected(false);

            premium.setEnabled(true);
            gold.setEnabled(true);
            silver.setEnabled(true);
        }

        if(e.getSource()== premium) {
            customer.setMemberType("Premium");
            gold.setSelected(false);
            silver.setSelected(false);
        }

        if(e.getSource()== gold)
        {
            customer.setMemberType("Gold");
            premium.setSelected(false);
            silver.setSelected(false);
        }

        if(e.getSource()== silver)
        {
            customer.setMemberType("Silver");
            premium.setSelected(false);
            gold.setSelected(false);
        }

        if(e.getSource() == haircut)
        {
            visit.setServiceExpense(40);
            result.setText("1x Haircut");
        }

        if (e.getSource() == resetButton) {
            nameField.setText("");
            dateField.setText("");
            visit.reset();
            result.setText("Reset");

            memberYes.setSelected(false);
            memberNo.setSelected(false);
            premium.setSelected(false);
            gold.setSelected(false);
            silver.setSelected(false);
        }

    }
}
