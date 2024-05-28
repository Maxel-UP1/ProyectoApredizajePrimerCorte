package model;

public class Teacher {
	private int id_Teacher;
	private String name_Teacher;
	private String mail_Teacher;
	private String address_Teacher;
	private int phone_Teacher;
	

    public Teacher(int id_Teacher, String name_Teacher, String mail_Teacher, String address_Teacher, int phone_Teacher) {
        this.id_Teacher = id_Teacher;
        this.name_Teacher = name_Teacher;
        this.mail_Teacher = mail_Teacher;
        this.address_Teacher = address_Teacher;
        this.phone_Teacher = phone_Teacher;
    }

  
    public int getId_Teacher() {
        return id_Teacher;
    }

    public void setId_Teacher(int id_Teacher) {
        this.id_Teacher = id_Teacher;
    }

   
    public String getName_Teacher() {
        return name_Teacher;
    }

    public void setName_Teacher(String name_Teacher) {
        this.name_Teacher = name_Teacher;
    }

    
    public String getMail_Teacher() {
        return mail_Teacher;
    }

    public void setMail_Teacher(String mail_Teacher) {
        this.mail_Teacher = mail_Teacher;
    }

    
    public String getAddress_Teacher() {
        return address_Teacher;
    }

    public void setAddress_Teacher(String address_Teacher) {
        this.address_Teacher = address_Teacher;
    }

   
    public int getPhone_Teacher() {
        return phone_Teacher;
    }

    public void setPhone_Teacher(int phone_Teacher) {
        this.phone_Teacher = phone_Teacher;
    }

       @Override
    public String toString() {
        return "Teacher{" +
                "id_Teacher=" + id_Teacher +
                ", name_Teacher='" + name_Teacher + '\'' +
                ", mail_Teacher='" + mail_Teacher + '\'' +
                ", address_Teacher='" + address_Teacher + '\'' +
                ", phone_Teacher=" + phone_Teacher +
                '}';
    }
}


