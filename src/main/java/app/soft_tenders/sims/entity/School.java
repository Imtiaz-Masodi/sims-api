package app.soft_tenders.sims.entity;

import app.soft_tenders.sims.enums.Accreditation;
import app.soft_tenders.sims.enums.BoardType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "schools")
public class School {
    @Id
    private String id;
    @Indexed(unique = true)
    private String schoolId;
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private short establishedYear;
    private String website;
    private BoardType boardType; // SSC, CBSC and ICSC
    private Accreditation accreditation; // Regionally, Nationally, Programmatically, Internationally and Unaccredited
    private String addressId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public short getEstablishedYear() {
        return establishedYear;
    }

    public void setEstablishedYear(short establishedYear) {
        this.establishedYear = establishedYear;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public BoardType getBoardType() {
        return boardType;
    }

    public void setBoardType(BoardType boardType) {
        this.boardType = boardType;
    }

    public Accreditation getAccreditation() {
        return accreditation;
    }

    public void setAccreditation(Accreditation accreditation) {
        this.accreditation = accreditation;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }
}
