package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name= "Administrators")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;
    @Embedded
    private Name name;
    @Embedded
    private Contact contact;

    public Admin() {
    }

    public Admin(Builder buildAdmin) {
        this.adminId = buildAdmin.adminId;
        this.name = buildAdmin.name;
        this.contact = buildAdmin.contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(adminId, admin.adminId) && Objects.equals(name, admin.name) && Objects.equals(contact, admin.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminId, name, contact);
    }

    @Override
    public String toString() {
        return ".........Administrator......." +"\n"+
                "adminId=" + adminId +"\n"+
                "Name:" + name.getFirstName() +" "+ name.getMiddleName()+" "+name.getLastName() +"\n"+
                "contact:"
                +"\n"+"Email- "+ contact.getEmail()
                +"\n"+ "Tel- "+contact.getMobileNumber() +"\n"+
                ".......................";
    }

    public Long getAdminId() {
        return adminId;
    }

    public Name getName() {
        return name;
    }

    public Contact getContact() {
        return contact;
    }

    public static class Builder {

        private Long adminId;

        private Name name;

        private Contact contact;

        public Builder setAdminId(Long adminId) {
            this.adminId = adminId;
            return this;
        }

        public Builder setName(Name name) {
            this.name = name;
            return this;
        }

        public Builder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }
        public Builder copyAdmin(Admin a){
            this.adminId = a.adminId;
            this.name = a.name;
            this.contact = a.contact;
            return this;
        }
        public Admin buildAdmin(){
            return new Admin(this);
        }
    }
}