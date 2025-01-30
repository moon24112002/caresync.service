package com.CareSync.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id", referencedColumnName = "id")
    private Details details;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "qualification_id", referencedColumnName = "id")
    private Qualification qualification;

    public Doctor(Long id, Details details, Address address, Qualification qualification) {
        this.id = id;
        this.details = details;
        this.address = address;
        this.qualification = qualification;
    }

    public Doctor() {
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Doctor)) return false;
        final Doctor other = (Doctor) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$details = this.getDetails();
        final Object other$details = other.getDetails();
        if (this$details == null ? other$details != null : !this$details.equals(other$details)) return false;
        final Object this$address = this.getAddress();
        final Object other$address = other.getAddress();
        if (this$address == null ? other$address != null : !this$address.equals(other$address)) return false;
        final Object this$qualification = this.getQualification();
        final Object other$qualification = other.getQualification();
        if (this$qualification == null ? other$qualification != null : !this$qualification.equals(other$qualification))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Doctor;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $details = this.getDetails();
        result = result * PRIME + ($details == null ? 43 : $details.hashCode());
        final Object $address = this.getAddress();
        result = result * PRIME + ($address == null ? 43 : $address.hashCode());
        final Object $qualification = this.getQualification();
        result = result * PRIME + ($qualification == null ? 43 : $qualification.hashCode());
        return result;
    }

    public String toString() {
        return "Doctor(id=" + this.getId() + ", details=" + this.getDetails() + ", address=" + this.getAddress() + ", qualification=" + this.getQualification() + ")";
    }

    public Long getId() {
        return this.id;
    }

    public Details getDetails() {
        return this.details;
    }

    public Address getAddress() {
        return this.address;
    }

    public Qualification getQualification() {
        return this.qualification;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }
}
