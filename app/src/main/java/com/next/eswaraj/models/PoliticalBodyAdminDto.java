package com.next.eswaraj.models;


import com.eswaraj.web.dto.BaseDto;
import com.eswaraj.web.dto.PartyDto;

import java.io.Serializable;

public class PoliticalBodyAdminDto extends BaseDto implements Serializable {

    private PartyDto party;
    private PoliticalAdminTypeDto politicalAdminType;
    private PoliticalAdminLocationDto location;
    private Long startDate;
    private String urlIdentifier;
    private String personExternalId;
    private String name;
    private String gender;
    private String profilePhoto;
    private String fbPage;
    private String officeEmail;
    private String email;
    private String biodata;
    private String mobileNumber1;
    private String mobileNumber2;
    private String landlineNumber1;
    private String landlineNumber2;

    public PoliticalBodyAdminDto() {
        party = new PartyDto();
        politicalAdminType = new PoliticalAdminTypeDto();
        location = new PoliticalAdminLocationDto();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber1() {
        return mobileNumber1;
    }

    public void setMobileNumber1(String mobileNumber1) {
        this.mobileNumber1 = mobileNumber1;
    }

    public String getMobileNumber2() {
        return mobileNumber2;
    }

    public void setMobileNumber2(String mobileNumber2) {
        this.mobileNumber2 = mobileNumber2;
    }

    public String getLandlineNumber1() {
        return landlineNumber1;
    }

    public void setLandlineNumber1(String landlineNumber1) {
        this.landlineNumber1 = landlineNumber1;
    }

    public String getLandlineNumber2() {
        return landlineNumber2;
    }

    public void setLandlineNumber2(String landlineNumber2) {
        this.landlineNumber2 = landlineNumber2;
    }

    public PoliticalAdminLocationDto getLocation() {
        return location;
    }

    public void setLocation(PoliticalAdminLocationDto location) {
        this.location = location;
    }

    public PartyDto getPartyDto() {
        return party;
    }

    public void setPartyDto(PartyDto partyDto) {
        this.party = partyDto;
    }

    public PoliticalAdminTypeDto getPoliticalAdminTypeDto() {
        return politicalAdminType;
    }

    public void setPoliticalAdminTypeDto(PoliticalAdminTypeDto politicalAdminTypeDto) {
        this.politicalAdminType = politicalAdminTypeDto;
    }

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public String getUrlIdentifier() {
        return urlIdentifier;
    }

    public void setUrlIdentifier(String urlIdentifier) {
        this.urlIdentifier = urlIdentifier;
    }

    public String getPersonExternalId() {
        return personExternalId;
    }

    public void setPersonExternalId(String personExternalId) {
        this.personExternalId = personExternalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getFbPage() {
        return fbPage;
    }

    public void setFbPage(String fbPage) {
        this.fbPage = fbPage;
    }

    public String getOfficeEmail() {
        return officeEmail;
    }

    public void setOfficeEmail(String officeEmail) {
        this.officeEmail = officeEmail;
    }

    public String getBiodata() {
        return biodata;
    }

    public void setBiodata(String biodata) {
        this.biodata = biodata;
    }

    public PartyDto getParty() {
        return party;
    }

    public void setParty(PartyDto party) {
        this.party = party;
    }

    public PoliticalAdminTypeDto getPoliticalAdminType() {
        return politicalAdminType;
    }

    public void setPoliticalAdminType(PoliticalAdminTypeDto politicalAdminType) {
        this.politicalAdminType = politicalAdminType;
    }

    @Override
    public String toString() {
        return "PoliticalBodyAdminDto{" +
                "party=" + party +
                ", politicalAdminType=" + politicalAdminType +
                ", location=" + location +
                ", startDate=" + startDate +
                ", urlIdentifier='" + urlIdentifier + '\'' +
                ", personExternalId='" + personExternalId + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", profilePhoto='" + profilePhoto + '\'' +
                ", fbPage='" + fbPage + '\'' +
                ", officeEmail='" + officeEmail + '\'' +
                ", biodata='" + biodata + '\'' +
                '}';
    }

    public class PoliticalAdminTypeDto extends BaseDto {
        private String name;
        private String shortName;
        private String description;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getShortName() {
            return shortName;
        }

        public void setShortName(String shortName) {
            this.shortName = shortName;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return "PoliticalAdminTypeDto{" +
                    "name='" + name + '\'' +
                    ", shortName='" + shortName + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
    }

    public class PoliticalAdminLocationDto extends BaseDto {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "PoliticalAdminLocationDto{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
