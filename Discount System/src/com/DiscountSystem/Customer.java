package com.DiscountSystem;
public class Customer
{


    public String name;

    public boolean member;
    public String memberType = " ";

    public Customer() {
    }

    public Customer(String name, boolean member, String memberType)
    {
        this.name = name;
        this.member=member;
        this.memberType=memberType;
    }


    public boolean ismember()
    {
        return member;
    }

    public void setName(String name) { this.name = name;}

    public void setMember(boolean member)
    {
        this.member = member;
    }

    public String getName()
    {
        return name;
    }

    public void setMemberType(String memberType)
    {
        this.memberType = memberType;
    }

    public String getMemberType()
    {
        return memberType;
    }

    @Override
    public String toString() {
        return "Costumer{" +
                "name='" + name + '\'' +
                ", member=" + member +
                ", memberType='" + memberType + '\'' +
                '}';
    }
}
