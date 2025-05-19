
package org.techdisqus.dao.response.custom.attributes;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "address",
    "addressCountry",
    "addressPlace",
    "age",
    "bloodType",
    "can",
    "chairman",
    "citizenship",
    "citizenshipStatus",
    "city",
    "civilStatus",
    "commercialTelegraphicCode",
    "conditions",
    "corpulence",
    "countryCode",
    "dateAndPlaceOfBirth",
    "dateAndPlaceOfIssue",
    "dateOfBirth",
    "dateOfBirthNationalLanguage",
    "dateOfExpiry",
    "dateOfExpiryNationalLanguage",
    "dateOfFirstRegistration",
    "dateOfIssue",
    "dateOfIssueNationalLanguage",
    "dateOfModification",
    "dateOfRegistration",
    "dayOfBirth",
    "district",
    "division",
    "documentIssuedBy",
    "documentNumber",
    "documentType",
    "documentTypeCode",
    "documentTypeNationalLanguage",
    "donor",
    "drivingCategories",
    "drivingCategoriesNationalLanguage",
    "education",
    "email",
    "emergencyAddress",
    "emergencyName",
    "emergencyPhoneNumber",
    "employer",
    "encounterMissionType",
    "estimatedDate",
    "ethnicType",
    "eyesColor",
    "faceFeatures",
    "faceMarks",
    "fathersName",
    "fathersNameNationalLanguage",
    "fin",
    "fpClassificationLeft",
    "fpClassificationRight",
    "fullName",
    "fullNameNationalLanguage",
    "givenNames",
    "givenNamesNationalLanguage",
    "hairColor",
    "healthNumber",
    "height",
    "immigrationStatus",
    "issuingAuthority",
    "job",
    "licenceDate",
    "licenceVersion",
    "licenseNumber",
    "limbsMarks",
    "literate",
    "location",
    "lockVersion",
    "machineReadableZone",
    "middleName",
    "modification",
    "monthOfBirth",
    "mothersName",
    "mothersNameNationalLanguage",
    "mothersSurnameAtBirth",
    "municipality",
    "nameAndSurnameOfKids",
    "nameAndSurnameOfSpouse",
    "nationalId",
    "nationality",
    "nationalityFreeText",
    "nationalityNationalLanguage",
    "nickname",
    "notes",
    "notesNationalLanguage",
    "observations",
    "occupation",
    "organDonation",
    "ori",
    "otherFeatures",
    "parentNames",
    "parentsGivenNames",
    "passportNumber",
    "personCategoryCode",
    "personalNumber",
    "personalNumberNationalLanguage",
    "personalNumberOfKids",
    "personalNumberOfSpouse",
    "phoneNumber",
    "placeOfBirth",
    "placeOfBirthNationalLanguage",
    "placeOfIssue",
    "postmaster",
    "procedure",
    "profession",
    "professionFreeText",
    "professionNationalLanguage",
    "province",
    "provinceOfBirth",
    "race",
    "racialCharacteristic",
    "recordedAt",
    "recordedBy",
    "recordedOn",
    "region",
    "registrationCentreCode",
    "registrationCentreName",
    "registrationConstituencyCode",
    "registrationConstituencyName",
    "registrationCountryCode",
    "registrationCountryName",
    "registrationCountyCode",
    "registrationCountyName",
    "registrationNumber",
    "registrationType",
    "registrationWardCode",
    "registrationWardName",
    "religion",
    "remarks",
    "reportReason",
    "restrictions",
    "secondSurname",
    "section",
    "securityNumber",
    "sex",
    "sexFreeText",
    "sexNationalLanguage",
    "snapshot",
    "sourceSystem",
    "spassNumber",
    "specialNeeds",
    "state",
    "surname",
    "surnameAtBirth",
    "surnameNationalLanguage",
    "taxNo",
    "title",
    "torsoMarks",
    "transactionNumber",
    "transactionType",
    "updateType",
    "voice",
    "votersIdentificationNumber",
    "votingCentreCode",
    "votingCentreName",
    "votingConstituencyCode",
    "votingConstituencyName",
    "votingCountryCode",
    "votingCountryName",
    "votingCountyCode",
    "votingCountyName",
    "votingWardCode",
    "votingWardName",
    "weight",
    "workPermitNumber",
    "yearOfBirth",
    "yearOfRegistration"
})
@Generated("jsonschema2pojo")
public class CustomDetails {

    @JsonProperty("address")
    private String address;
    @JsonProperty("addressCountry")
    private String addressCountry;
    @JsonProperty("addressPlace")
    private String addressPlace;
    @JsonProperty("age")
    private String age;
    @JsonProperty("bloodType")
    private String bloodType;
    @JsonProperty("can")
    private String can;
    @JsonProperty("chairman")
    private String chairman;
    @JsonProperty("citizenship")
    private String citizenship;
    @JsonProperty("citizenshipStatus")
    private String citizenshipStatus;
    @JsonProperty("city")
    private String city;
    @JsonProperty("civilStatus")
    private String civilStatus;
    @JsonProperty("commercialTelegraphicCode")
    private String commercialTelegraphicCode;
    @JsonProperty("conditions")
    private String conditions;
    @JsonProperty("corpulence")
    private String corpulence;
    @JsonProperty("countryCode")
    private String countryCode;
    @JsonProperty("dateAndPlaceOfBirth")
    private String dateAndPlaceOfBirth;
    @JsonProperty("dateAndPlaceOfIssue")
    private String dateAndPlaceOfIssue;
    @JsonProperty("dateOfBirth")
    private String dateOfBirth;
    @JsonProperty("dateOfBirthNationalLanguage")
    private String dateOfBirthNationalLanguage;
    @JsonProperty("dateOfExpiry")
    private String dateOfExpiry;
    @JsonProperty("dateOfExpiryNationalLanguage")
    private String dateOfExpiryNationalLanguage;
    @JsonProperty("dateOfFirstRegistration")
    private String dateOfFirstRegistration;
    @JsonProperty("dateOfIssue")
    private String dateOfIssue;
    @JsonProperty("dateOfIssueNationalLanguage")
    private String dateOfIssueNationalLanguage;
    @JsonProperty("dateOfModification")
    private String dateOfModification;
    @JsonProperty("dateOfRegistration")
    private String dateOfRegistration;
    @JsonProperty("dayOfBirth")
    private String dayOfBirth;
    @JsonProperty("district")
    private String district;
    @JsonProperty("division")
    private String division;
    @JsonProperty("documentIssuedBy")
    private String documentIssuedBy;
    @JsonProperty("documentNumber")
    private String documentNumber;
    @JsonProperty("documentType")
    private String documentType;
    @JsonProperty("documentTypeCode")
    private String documentTypeCode;
    @JsonProperty("documentTypeNationalLanguage")
    private String documentTypeNationalLanguage;
    @JsonProperty("donor")
    private String donor;
    @JsonProperty("drivingCategories")
    private String drivingCategories;
    @JsonProperty("drivingCategoriesNationalLanguage")
    private String drivingCategoriesNationalLanguage;
    @JsonProperty("education")
    private String education;
    @JsonProperty("email")
    private String email;
    @JsonProperty("emergencyAddress")
    private String emergencyAddress;
    @JsonProperty("emergencyName")
    private String emergencyName;
    @JsonProperty("emergencyPhoneNumber")
    private String emergencyPhoneNumber;
    @JsonProperty("employer")
    private String employer;
    @JsonProperty("encounterMissionType")
    private String encounterMissionType;
    @JsonProperty("estimatedDate")
    private String estimatedDate;
    @JsonProperty("ethnicType")
    private String ethnicType;
    @JsonProperty("eyesColor")
    private String eyesColor;
    @JsonProperty("faceFeatures")
    private String faceFeatures;
    @JsonProperty("faceMarks")
    private String faceMarks;
    @JsonProperty("fathersName")
    private String fathersName;
    @JsonProperty("fathersNameNationalLanguage")
    private String fathersNameNationalLanguage;
    @JsonProperty("fin")
    private String fin;
    @JsonProperty("fpClassificationLeft")
    private String fpClassificationLeft;
    @JsonProperty("fpClassificationRight")
    private String fpClassificationRight;
    @JsonProperty("fullName")
    private String fullName;
    @JsonProperty("fullNameNationalLanguage")
    private String fullNameNationalLanguage;
    @JsonProperty("givenNames")
    private String givenNames;
    @JsonProperty("givenNamesNationalLanguage")
    private String givenNamesNationalLanguage;
    @JsonProperty("hairColor")
    private String hairColor;
    @JsonProperty("healthNumber")
    private String healthNumber;
    @JsonProperty("height")
    private String height;
    @JsonProperty("immigrationStatus")
    private String immigrationStatus;
    @JsonProperty("issuingAuthority")
    private String issuingAuthority;
    @JsonProperty("job")
    private String job;
    @JsonProperty("licenceDate")
    private String licenceDate;
    @JsonProperty("licenceVersion")
    private String licenceVersion;
    @JsonProperty("licenseNumber")
    private String licenseNumber;
    @JsonProperty("limbsMarks")
    private String limbsMarks;
    @JsonProperty("literate")
    private String literate;
    @JsonProperty("location")
    private String location;
    @JsonProperty("lockVersion")
    private String lockVersion;
    @JsonProperty("machineReadableZone")
    private String machineReadableZone;
    @JsonProperty("middleName")
    private String middleName;
    @JsonProperty("modification")
    private String modification;
    @JsonProperty("monthOfBirth")
    private String monthOfBirth;
    @JsonProperty("mothersName")
    private String mothersName;
    @JsonProperty("mothersNameNationalLanguage")
    private String mothersNameNationalLanguage;
    @JsonProperty("mothersSurnameAtBirth")
    private String mothersSurnameAtBirth;
    @JsonProperty("municipality")
    private String municipality;
    @JsonProperty("nameAndSurnameOfKids")
    private String nameAndSurnameOfKids;
    @JsonProperty("nameAndSurnameOfSpouse")
    private String nameAndSurnameOfSpouse;
    @JsonProperty("nationalId")
    private String nationalId;
    @JsonProperty("nationality")
    private String nationality;
    @JsonProperty("nationalityFreeText")
    private String nationalityFreeText;
    @JsonProperty("nationalityNationalLanguage")
    private String nationalityNationalLanguage;
    @JsonProperty("nickname")
    private String nickname;
    @JsonProperty("notes")
    private String notes;
    @JsonProperty("notesNationalLanguage")
    private String notesNationalLanguage;
    @JsonProperty("observations")
    private String observations;
    @JsonProperty("occupation")
    private String occupation;
    @JsonProperty("organDonation")
    private String organDonation;
    @JsonProperty("ori")
    private String ori;
    @JsonProperty("otherFeatures")
    private String otherFeatures;
    @JsonProperty("parentNames")
    private String parentNames;
    @JsonProperty("parentsGivenNames")
    private String parentsGivenNames;
    @JsonProperty("passportNumber")
    private String passportNumber;
    @JsonProperty("personCategoryCode")
    private String personCategoryCode;
    @JsonProperty("personalNumber")
    private String personalNumber;
    @JsonProperty("personalNumberNationalLanguage")
    private String personalNumberNationalLanguage;
    @JsonProperty("personalNumberOfKids")
    private String personalNumberOfKids;
    @JsonProperty("personalNumberOfSpouse")
    private String personalNumberOfSpouse;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("placeOfBirth")
    private String placeOfBirth;
    @JsonProperty("placeOfBirthNationalLanguage")
    private String placeOfBirthNationalLanguage;
    @JsonProperty("placeOfIssue")
    private String placeOfIssue;
    @JsonProperty("postmaster")
    private String postmaster;
    @JsonProperty("procedure")
    private String procedure;
    @JsonProperty("profession")
    private String profession;
    @JsonProperty("professionFreeText")
    private String professionFreeText;
    @JsonProperty("professionNationalLanguage")
    private String professionNationalLanguage;
    @JsonProperty("province")
    private String province;
    @JsonProperty("provinceOfBirth")
    private String provinceOfBirth;
    @JsonProperty("race")
    private String race;
    @JsonProperty("racialCharacteristic")
    private String racialCharacteristic;
    @JsonProperty("recordedAt")
    private String recordedAt;
    @JsonProperty("recordedBy")
    private String recordedBy;
    @JsonProperty("recordedOn")
    private String recordedOn;
    @JsonProperty("region")
    private String region;
    @JsonProperty("registrationCentreCode")
    private String registrationCentreCode;
    @JsonProperty("registrationCentreName")
    private String registrationCentreName;
    @JsonProperty("registrationConstituencyCode")
    private String registrationConstituencyCode;
    @JsonProperty("registrationConstituencyName")
    private String registrationConstituencyName;
    @JsonProperty("registrationCountryCode")
    private String registrationCountryCode;
    @JsonProperty("registrationCountryName")
    private String registrationCountryName;
    @JsonProperty("registrationCountyCode")
    private String registrationCountyCode;
    @JsonProperty("registrationCountyName")
    private String registrationCountyName;
    @JsonProperty("registrationNumber")
    private String registrationNumber;
    @JsonProperty("registrationType")
    private String registrationType;
    @JsonProperty("registrationWardCode")
    private String registrationWardCode;
    @JsonProperty("registrationWardName")
    private String registrationWardName;
    @JsonProperty("religion")
    private String religion;
    @JsonProperty("remarks")
    private String remarks;
    @JsonProperty("reportReason")
    private String reportReason;
    @JsonProperty("restrictions")
    private String restrictions;
    @JsonProperty("secondSurname")
    private String secondSurname;
    @JsonProperty("section")
    private String section;
    @JsonProperty("securityNumber")
    private String securityNumber;
    @JsonProperty("sex")
    private String sex;
    @JsonProperty("sexFreeText")
    private String sexFreeText;
    @JsonProperty("sexNationalLanguage")
    private String sexNationalLanguage;
    @JsonProperty("snapshot")
    private String snapshot;
    @JsonProperty("sourceSystem")
    private String sourceSystem;
    @JsonProperty("spassNumber")
    private String spassNumber;
    @JsonProperty("specialNeeds")
    private String specialNeeds;
    @JsonProperty("state")
    private String state;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("surnameAtBirth")
    private String surnameAtBirth;
    @JsonProperty("surnameNationalLanguage")
    private String surnameNationalLanguage;
    @JsonProperty("taxNo")
    private String taxNo;
    @JsonProperty("title")
    private String title;
    @JsonProperty("torsoMarks")
    private String torsoMarks;
    @JsonProperty("transactionNumber")
    private String transactionNumber;
    @JsonProperty("transactionType")
    private String transactionType;
    @JsonProperty("updateType")
    private String updateType;
    @JsonProperty("voice")
    private String voice;
    @JsonProperty("votersIdentificationNumber")
    private String votersIdentificationNumber;
    @JsonProperty("votingCentreCode")
    private String votingCentreCode;
    @JsonProperty("votingCentreName")
    private String votingCentreName;
    @JsonProperty("votingConstituencyCode")
    private String votingConstituencyCode;
    @JsonProperty("votingConstituencyName")
    private String votingConstituencyName;
    @JsonProperty("votingCountryCode")
    private String votingCountryCode;
    @JsonProperty("votingCountryName")
    private String votingCountryName;
    @JsonProperty("votingCountyCode")
    private String votingCountyCode;
    @JsonProperty("votingCountyName")
    private String votingCountyName;
    @JsonProperty("votingWardCode")
    private String votingWardCode;
    @JsonProperty("votingWardName")
    private String votingWardName;
    @JsonProperty("weight")
    private String weight;
    @JsonProperty("workPermitNumber")
    private String workPermitNumber;
    @JsonProperty("yearOfBirth")
    private String yearOfBirth;
    @JsonProperty("yearOfRegistration")
    private String yearOfRegistration;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    public CustomDetails withAddress(String address) {
        this.address = address;
        return this;
    }

    @JsonProperty("addressCountry")
    public String getAddressCountry() {
        return addressCountry;
    }

    @JsonProperty("addressCountry")
    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }

    public CustomDetails withAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
        return this;
    }

    @JsonProperty("addressPlace")
    public String getAddressPlace() {
        return addressPlace;
    }

    @JsonProperty("addressPlace")
    public void setAddressPlace(String addressPlace) {
        this.addressPlace = addressPlace;
    }

    public CustomDetails withAddressPlace(String addressPlace) {
        this.addressPlace = addressPlace;
        return this;
    }

    @JsonProperty("age")
    public String getAge() {
        return age;
    }

    @JsonProperty("age")
    public void setAge(String age) {
        this.age = age;
    }

    public CustomDetails withAge(String age) {
        this.age = age;
        return this;
    }

    @JsonProperty("bloodType")
    public String getBloodType() {
        return bloodType;
    }

    @JsonProperty("bloodType")
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public CustomDetails withBloodType(String bloodType) {
        this.bloodType = bloodType;
        return this;
    }

    @JsonProperty("can")
    public String getCan() {
        return can;
    }

    @JsonProperty("can")
    public void setCan(String can) {
        this.can = can;
    }

    public CustomDetails withCan(String can) {
        this.can = can;
        return this;
    }

    @JsonProperty("chairman")
    public String getChairman() {
        return chairman;
    }

    @JsonProperty("chairman")
    public void setChairman(String chairman) {
        this.chairman = chairman;
    }

    public CustomDetails withChairman(String chairman) {
        this.chairman = chairman;
        return this;
    }

    @JsonProperty("citizenship")
    public String getCitizenship() {
        return citizenship;
    }

    @JsonProperty("citizenship")
    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public CustomDetails withCitizenship(String citizenship) {
        this.citizenship = citizenship;
        return this;
    }

    @JsonProperty("citizenshipStatus")
    public String getCitizenshipStatus() {
        return citizenshipStatus;
    }

    @JsonProperty("citizenshipStatus")
    public void setCitizenshipStatus(String citizenshipStatus) {
        this.citizenshipStatus = citizenshipStatus;
    }

    public CustomDetails withCitizenshipStatus(String citizenshipStatus) {
        this.citizenshipStatus = citizenshipStatus;
        return this;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    public CustomDetails withCity(String city) {
        this.city = city;
        return this;
    }

    @JsonProperty("civilStatus")
    public String getCivilStatus() {
        return civilStatus;
    }

    @JsonProperty("civilStatus")
    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    public CustomDetails withCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
        return this;
    }

    @JsonProperty("commercialTelegraphicCode")
    public String getCommercialTelegraphicCode() {
        return commercialTelegraphicCode;
    }

    @JsonProperty("commercialTelegraphicCode")
    public void setCommercialTelegraphicCode(String commercialTelegraphicCode) {
        this.commercialTelegraphicCode = commercialTelegraphicCode;
    }

    public CustomDetails withCommercialTelegraphicCode(String commercialTelegraphicCode) {
        this.commercialTelegraphicCode = commercialTelegraphicCode;
        return this;
    }

    @JsonProperty("conditions")
    public String getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public CustomDetails withConditions(String conditions) {
        this.conditions = conditions;
        return this;
    }

    @JsonProperty("corpulence")
    public String getCorpulence() {
        return corpulence;
    }

    @JsonProperty("corpulence")
    public void setCorpulence(String corpulence) {
        this.corpulence = corpulence;
    }

    public CustomDetails withCorpulence(String corpulence) {
        this.corpulence = corpulence;
        return this;
    }

    @JsonProperty("countryCode")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("countryCode")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public CustomDetails withCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    @JsonProperty("dateAndPlaceOfBirth")
    public String getDateAndPlaceOfBirth() {
        return dateAndPlaceOfBirth;
    }

    @JsonProperty("dateAndPlaceOfBirth")
    public void setDateAndPlaceOfBirth(String dateAndPlaceOfBirth) {
        this.dateAndPlaceOfBirth = dateAndPlaceOfBirth;
    }

    public CustomDetails withDateAndPlaceOfBirth(String dateAndPlaceOfBirth) {
        this.dateAndPlaceOfBirth = dateAndPlaceOfBirth;
        return this;
    }

    @JsonProperty("dateAndPlaceOfIssue")
    public String getDateAndPlaceOfIssue() {
        return dateAndPlaceOfIssue;
    }

    @JsonProperty("dateAndPlaceOfIssue")
    public void setDateAndPlaceOfIssue(String dateAndPlaceOfIssue) {
        this.dateAndPlaceOfIssue = dateAndPlaceOfIssue;
    }

    public CustomDetails withDateAndPlaceOfIssue(String dateAndPlaceOfIssue) {
        this.dateAndPlaceOfIssue = dateAndPlaceOfIssue;
        return this;
    }

    @JsonProperty("dateOfBirth")
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    @JsonProperty("dateOfBirth")
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public CustomDetails withDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    @JsonProperty("dateOfBirthNationalLanguage")
    public String getDateOfBirthNationalLanguage() {
        return dateOfBirthNationalLanguage;
    }

    @JsonProperty("dateOfBirthNationalLanguage")
    public void setDateOfBirthNationalLanguage(String dateOfBirthNationalLanguage) {
        this.dateOfBirthNationalLanguage = dateOfBirthNationalLanguage;
    }

    public CustomDetails withDateOfBirthNationalLanguage(String dateOfBirthNationalLanguage) {
        this.dateOfBirthNationalLanguage = dateOfBirthNationalLanguage;
        return this;
    }

    @JsonProperty("dateOfExpiry")
    public String getDateOfExpiry() {
        return dateOfExpiry;
    }

    @JsonProperty("dateOfExpiry")
    public void setDateOfExpiry(String dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    public CustomDetails withDateOfExpiry(String dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
        return this;
    }

    @JsonProperty("dateOfExpiryNationalLanguage")
    public String getDateOfExpiryNationalLanguage() {
        return dateOfExpiryNationalLanguage;
    }

    @JsonProperty("dateOfExpiryNationalLanguage")
    public void setDateOfExpiryNationalLanguage(String dateOfExpiryNationalLanguage) {
        this.dateOfExpiryNationalLanguage = dateOfExpiryNationalLanguage;
    }

    public CustomDetails withDateOfExpiryNationalLanguage(String dateOfExpiryNationalLanguage) {
        this.dateOfExpiryNationalLanguage = dateOfExpiryNationalLanguage;
        return this;
    }

    @JsonProperty("dateOfFirstRegistration")
    public String getDateOfFirstRegistration() {
        return dateOfFirstRegistration;
    }

    @JsonProperty("dateOfFirstRegistration")
    public void setDateOfFirstRegistration(String dateOfFirstRegistration) {
        this.dateOfFirstRegistration = dateOfFirstRegistration;
    }

    public CustomDetails withDateOfFirstRegistration(String dateOfFirstRegistration) {
        this.dateOfFirstRegistration = dateOfFirstRegistration;
        return this;
    }

    @JsonProperty("dateOfIssue")
    public String getDateOfIssue() {
        return dateOfIssue;
    }

    @JsonProperty("dateOfIssue")
    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public CustomDetails withDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
        return this;
    }

    @JsonProperty("dateOfIssueNationalLanguage")
    public String getDateOfIssueNationalLanguage() {
        return dateOfIssueNationalLanguage;
    }

    @JsonProperty("dateOfIssueNationalLanguage")
    public void setDateOfIssueNationalLanguage(String dateOfIssueNationalLanguage) {
        this.dateOfIssueNationalLanguage = dateOfIssueNationalLanguage;
    }

    public CustomDetails withDateOfIssueNationalLanguage(String dateOfIssueNationalLanguage) {
        this.dateOfIssueNationalLanguage = dateOfIssueNationalLanguage;
        return this;
    }

    @JsonProperty("dateOfModification")
    public String getDateOfModification() {
        return dateOfModification;
    }

    @JsonProperty("dateOfModification")
    public void setDateOfModification(String dateOfModification) {
        this.dateOfModification = dateOfModification;
    }

    public CustomDetails withDateOfModification(String dateOfModification) {
        this.dateOfModification = dateOfModification;
        return this;
    }

    @JsonProperty("dateOfRegistration")
    public String getDateOfRegistration() {
        return dateOfRegistration;
    }

    @JsonProperty("dateOfRegistration")
    public void setDateOfRegistration(String dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public CustomDetails withDateOfRegistration(String dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
        return this;
    }

    @JsonProperty("dayOfBirth")
    public String getDayOfBirth() {
        return dayOfBirth;
    }

    @JsonProperty("dayOfBirth")
    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public CustomDetails withDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
        return this;
    }

    @JsonProperty("district")
    public String getDistrict() {
        return district;
    }

    @JsonProperty("district")
    public void setDistrict(String district) {
        this.district = district;
    }

    public CustomDetails withDistrict(String district) {
        this.district = district;
        return this;
    }

    @JsonProperty("division")
    public String getDivision() {
        return division;
    }

    @JsonProperty("division")
    public void setDivision(String division) {
        this.division = division;
    }

    public CustomDetails withDivision(String division) {
        this.division = division;
        return this;
    }

    @JsonProperty("documentIssuedBy")
    public String getDocumentIssuedBy() {
        return documentIssuedBy;
    }

    @JsonProperty("documentIssuedBy")
    public void setDocumentIssuedBy(String documentIssuedBy) {
        this.documentIssuedBy = documentIssuedBy;
    }

    public CustomDetails withDocumentIssuedBy(String documentIssuedBy) {
        this.documentIssuedBy = documentIssuedBy;
        return this;
    }

    @JsonProperty("documentNumber")
    public String getDocumentNumber() {
        return documentNumber;
    }

    @JsonProperty("documentNumber")
    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public CustomDetails withDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
        return this;
    }

    @JsonProperty("documentType")
    public String getDocumentType() {
        return documentType;
    }

    @JsonProperty("documentType")
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public CustomDetails withDocumentType(String documentType) {
        this.documentType = documentType;
        return this;
    }

    @JsonProperty("documentTypeCode")
    public String getDocumentTypeCode() {
        return documentTypeCode;
    }

    @JsonProperty("documentTypeCode")
    public void setDocumentTypeCode(String documentTypeCode) {
        this.documentTypeCode = documentTypeCode;
    }

    public CustomDetails withDocumentTypeCode(String documentTypeCode) {
        this.documentTypeCode = documentTypeCode;
        return this;
    }

    @JsonProperty("documentTypeNationalLanguage")
    public String getDocumentTypeNationalLanguage() {
        return documentTypeNationalLanguage;
    }

    @JsonProperty("documentTypeNationalLanguage")
    public void setDocumentTypeNationalLanguage(String documentTypeNationalLanguage) {
        this.documentTypeNationalLanguage = documentTypeNationalLanguage;
    }

    public CustomDetails withDocumentTypeNationalLanguage(String documentTypeNationalLanguage) {
        this.documentTypeNationalLanguage = documentTypeNationalLanguage;
        return this;
    }

    @JsonProperty("donor")
    public String getDonor() {
        return donor;
    }

    @JsonProperty("donor")
    public void setDonor(String donor) {
        this.donor = donor;
    }

    public CustomDetails withDonor(String donor) {
        this.donor = donor;
        return this;
    }

    @JsonProperty("drivingCategories")
    public String getDrivingCategories() {
        return drivingCategories;
    }

    @JsonProperty("drivingCategories")
    public void setDrivingCategories(String drivingCategories) {
        this.drivingCategories = drivingCategories;
    }

    public CustomDetails withDrivingCategories(String drivingCategories) {
        this.drivingCategories = drivingCategories;
        return this;
    }

    @JsonProperty("drivingCategoriesNationalLanguage")
    public String getDrivingCategoriesNationalLanguage() {
        return drivingCategoriesNationalLanguage;
    }

    @JsonProperty("drivingCategoriesNationalLanguage")
    public void setDrivingCategoriesNationalLanguage(String drivingCategoriesNationalLanguage) {
        this.drivingCategoriesNationalLanguage = drivingCategoriesNationalLanguage;
    }

    public CustomDetails withDrivingCategoriesNationalLanguage(String drivingCategoriesNationalLanguage) {
        this.drivingCategoriesNationalLanguage = drivingCategoriesNationalLanguage;
        return this;
    }

    @JsonProperty("education")
    public String getEducation() {
        return education;
    }

    @JsonProperty("education")
    public void setEducation(String education) {
        this.education = education;
    }

    public CustomDetails withEducation(String education) {
        this.education = education;
        return this;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    public CustomDetails withEmail(String email) {
        this.email = email;
        return this;
    }

    @JsonProperty("emergencyAddress")
    public String getEmergencyAddress() {
        return emergencyAddress;
    }

    @JsonProperty("emergencyAddress")
    public void setEmergencyAddress(String emergencyAddress) {
        this.emergencyAddress = emergencyAddress;
    }

    public CustomDetails withEmergencyAddress(String emergencyAddress) {
        this.emergencyAddress = emergencyAddress;
        return this;
    }

    @JsonProperty("emergencyName")
    public String getEmergencyName() {
        return emergencyName;
    }

    @JsonProperty("emergencyName")
    public void setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName;
    }

    public CustomDetails withEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName;
        return this;
    }

    @JsonProperty("emergencyPhoneNumber")
    public String getEmergencyPhoneNumber() {
        return emergencyPhoneNumber;
    }

    @JsonProperty("emergencyPhoneNumber")
    public void setEmergencyPhoneNumber(String emergencyPhoneNumber) {
        this.emergencyPhoneNumber = emergencyPhoneNumber;
    }

    public CustomDetails withEmergencyPhoneNumber(String emergencyPhoneNumber) {
        this.emergencyPhoneNumber = emergencyPhoneNumber;
        return this;
    }

    @JsonProperty("employer")
    public String getEmployer() {
        return employer;
    }

    @JsonProperty("employer")
    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public CustomDetails withEmployer(String employer) {
        this.employer = employer;
        return this;
    }

    @JsonProperty("encounterMissionType")
    public String getEncounterMissionType() {
        return encounterMissionType;
    }

    @JsonProperty("encounterMissionType")
    public void setEncounterMissionType(String encounterMissionType) {
        this.encounterMissionType = encounterMissionType;
    }

    public CustomDetails withEncounterMissionType(String encounterMissionType) {
        this.encounterMissionType = encounterMissionType;
        return this;
    }

    @JsonProperty("estimatedDate")
    public String getEstimatedDate() {
        return estimatedDate;
    }

    @JsonProperty("estimatedDate")
    public void setEstimatedDate(String estimatedDate) {
        this.estimatedDate = estimatedDate;
    }

    public CustomDetails withEstimatedDate(String estimatedDate) {
        this.estimatedDate = estimatedDate;
        return this;
    }

    @JsonProperty("ethnicType")
    public String getEthnicType() {
        return ethnicType;
    }

    @JsonProperty("ethnicType")
    public void setEthnicType(String ethnicType) {
        this.ethnicType = ethnicType;
    }

    public CustomDetails withEthnicType(String ethnicType) {
        this.ethnicType = ethnicType;
        return this;
    }

    @JsonProperty("eyesColor")
    public String getEyesColor() {
        return eyesColor;
    }

    @JsonProperty("eyesColor")
    public void setEyesColor(String eyesColor) {
        this.eyesColor = eyesColor;
    }

    public CustomDetails withEyesColor(String eyesColor) {
        this.eyesColor = eyesColor;
        return this;
    }

    @JsonProperty("faceFeatures")
    public String getFaceFeatures() {
        return faceFeatures;
    }

    @JsonProperty("faceFeatures")
    public void setFaceFeatures(String faceFeatures) {
        this.faceFeatures = faceFeatures;
    }

    public CustomDetails withFaceFeatures(String faceFeatures) {
        this.faceFeatures = faceFeatures;
        return this;
    }

    @JsonProperty("faceMarks")
    public String getFaceMarks() {
        return faceMarks;
    }

    @JsonProperty("faceMarks")
    public void setFaceMarks(String faceMarks) {
        this.faceMarks = faceMarks;
    }

    public CustomDetails withFaceMarks(String faceMarks) {
        this.faceMarks = faceMarks;
        return this;
    }

    @JsonProperty("fathersName")
    public String getFathersName() {
        return fathersName;
    }

    @JsonProperty("fathersName")
    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public CustomDetails withFathersName(String fathersName) {
        this.fathersName = fathersName;
        return this;
    }

    @JsonProperty("fathersNameNationalLanguage")
    public String getFathersNameNationalLanguage() {
        return fathersNameNationalLanguage;
    }

    @JsonProperty("fathersNameNationalLanguage")
    public void setFathersNameNationalLanguage(String fathersNameNationalLanguage) {
        this.fathersNameNationalLanguage = fathersNameNationalLanguage;
    }

    public CustomDetails withFathersNameNationalLanguage(String fathersNameNationalLanguage) {
        this.fathersNameNationalLanguage = fathersNameNationalLanguage;
        return this;
    }

    @JsonProperty("fin")
    public String getFin() {
        return fin;
    }

    @JsonProperty("fin")
    public void setFin(String fin) {
        this.fin = fin;
    }

    public CustomDetails withFin(String fin) {
        this.fin = fin;
        return this;
    }

    @JsonProperty("fpClassificationLeft")
    public String getFpClassificationLeft() {
        return fpClassificationLeft;
    }

    @JsonProperty("fpClassificationLeft")
    public void setFpClassificationLeft(String fpClassificationLeft) {
        this.fpClassificationLeft = fpClassificationLeft;
    }

    public CustomDetails withFpClassificationLeft(String fpClassificationLeft) {
        this.fpClassificationLeft = fpClassificationLeft;
        return this;
    }

    @JsonProperty("fpClassificationRight")
    public String getFpClassificationRight() {
        return fpClassificationRight;
    }

    @JsonProperty("fpClassificationRight")
    public void setFpClassificationRight(String fpClassificationRight) {
        this.fpClassificationRight = fpClassificationRight;
    }

    public CustomDetails withFpClassificationRight(String fpClassificationRight) {
        this.fpClassificationRight = fpClassificationRight;
        return this;
    }

    @JsonProperty("fullName")
    public String getFullName() {
        return fullName;
    }

    @JsonProperty("fullName")
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public CustomDetails withFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    @JsonProperty("fullNameNationalLanguage")
    public String getFullNameNationalLanguage() {
        return fullNameNationalLanguage;
    }

    @JsonProperty("fullNameNationalLanguage")
    public void setFullNameNationalLanguage(String fullNameNationalLanguage) {
        this.fullNameNationalLanguage = fullNameNationalLanguage;
    }

    public CustomDetails withFullNameNationalLanguage(String fullNameNationalLanguage) {
        this.fullNameNationalLanguage = fullNameNationalLanguage;
        return this;
    }

    @JsonProperty("givenNames")
    public String getGivenNames() {
        return givenNames;
    }

    @JsonProperty("givenNames")
    public void setGivenNames(String givenNames) {
        this.givenNames = givenNames;
    }

    public CustomDetails withGivenNames(String givenNames) {
        this.givenNames = givenNames;
        return this;
    }

    @JsonProperty("givenNamesNationalLanguage")
    public String getGivenNamesNationalLanguage() {
        return givenNamesNationalLanguage;
    }

    @JsonProperty("givenNamesNationalLanguage")
    public void setGivenNamesNationalLanguage(String givenNamesNationalLanguage) {
        this.givenNamesNationalLanguage = givenNamesNationalLanguage;
    }

    public CustomDetails withGivenNamesNationalLanguage(String givenNamesNationalLanguage) {
        this.givenNamesNationalLanguage = givenNamesNationalLanguage;
        return this;
    }

    @JsonProperty("hairColor")
    public String getHairColor() {
        return hairColor;
    }

    @JsonProperty("hairColor")
    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public CustomDetails withHairColor(String hairColor) {
        this.hairColor = hairColor;
        return this;
    }

    @JsonProperty("healthNumber")
    public String getHealthNumber() {
        return healthNumber;
    }

    @JsonProperty("healthNumber")
    public void setHealthNumber(String healthNumber) {
        this.healthNumber = healthNumber;
    }

    public CustomDetails withHealthNumber(String healthNumber) {
        this.healthNumber = healthNumber;
        return this;
    }

    @JsonProperty("height")
    public String getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(String height) {
        this.height = height;
    }

    public CustomDetails withHeight(String height) {
        this.height = height;
        return this;
    }

    @JsonProperty("immigrationStatus")
    public String getImmigrationStatus() {
        return immigrationStatus;
    }

    @JsonProperty("immigrationStatus")
    public void setImmigrationStatus(String immigrationStatus) {
        this.immigrationStatus = immigrationStatus;
    }

    public CustomDetails withImmigrationStatus(String immigrationStatus) {
        this.immigrationStatus = immigrationStatus;
        return this;
    }

    @JsonProperty("issuingAuthority")
    public String getIssuingAuthority() {
        return issuingAuthority;
    }

    @JsonProperty("issuingAuthority")
    public void setIssuingAuthority(String issuingAuthority) {
        this.issuingAuthority = issuingAuthority;
    }

    public CustomDetails withIssuingAuthority(String issuingAuthority) {
        this.issuingAuthority = issuingAuthority;
        return this;
    }

    @JsonProperty("job")
    public String getJob() {
        return job;
    }

    @JsonProperty("job")
    public void setJob(String job) {
        this.job = job;
    }

    public CustomDetails withJob(String job) {
        this.job = job;
        return this;
    }

    @JsonProperty("licenceDate")
    public String getLicenceDate() {
        return licenceDate;
    }

    @JsonProperty("licenceDate")
    public void setLicenceDate(String licenceDate) {
        this.licenceDate = licenceDate;
    }

    public CustomDetails withLicenceDate(String licenceDate) {
        this.licenceDate = licenceDate;
        return this;
    }

    @JsonProperty("licenceVersion")
    public String getLicenceVersion() {
        return licenceVersion;
    }

    @JsonProperty("licenceVersion")
    public void setLicenceVersion(String licenceVersion) {
        this.licenceVersion = licenceVersion;
    }

    public CustomDetails withLicenceVersion(String licenceVersion) {
        this.licenceVersion = licenceVersion;
        return this;
    }

    @JsonProperty("licenseNumber")
    public String getLicenseNumber() {
        return licenseNumber;
    }

    @JsonProperty("licenseNumber")
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public CustomDetails withLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
        return this;
    }

    @JsonProperty("limbsMarks")
    public String getLimbsMarks() {
        return limbsMarks;
    }

    @JsonProperty("limbsMarks")
    public void setLimbsMarks(String limbsMarks) {
        this.limbsMarks = limbsMarks;
    }

    public CustomDetails withLimbsMarks(String limbsMarks) {
        this.limbsMarks = limbsMarks;
        return this;
    }

    @JsonProperty("literate")
    public String getLiterate() {
        return literate;
    }

    @JsonProperty("literate")
    public void setLiterate(String literate) {
        this.literate = literate;
    }

    public CustomDetails withLiterate(String literate) {
        this.literate = literate;
        return this;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    public CustomDetails withLocation(String location) {
        this.location = location;
        return this;
    }

    @JsonProperty("lockVersion")
    public String getLockVersion() {
        return lockVersion;
    }

    @JsonProperty("lockVersion")
    public void setLockVersion(String lockVersion) {
        this.lockVersion = lockVersion;
    }

    public CustomDetails withLockVersion(String lockVersion) {
        this.lockVersion = lockVersion;
        return this;
    }

    @JsonProperty("machineReadableZone")
    public String getMachineReadableZone() {
        return machineReadableZone;
    }

    @JsonProperty("machineReadableZone")
    public void setMachineReadableZone(String machineReadableZone) {
        this.machineReadableZone = machineReadableZone;
    }

    public CustomDetails withMachineReadableZone(String machineReadableZone) {
        this.machineReadableZone = machineReadableZone;
        return this;
    }

    @JsonProperty("middleName")
    public String getMiddleName() {
        return middleName;
    }

    @JsonProperty("middleName")
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public CustomDetails withMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    @JsonProperty("modification")
    public String getModification() {
        return modification;
    }

    @JsonProperty("modification")
    public void setModification(String modification) {
        this.modification = modification;
    }

    public CustomDetails withModification(String modification) {
        this.modification = modification;
        return this;
    }

    @JsonProperty("monthOfBirth")
    public String getMonthOfBirth() {
        return monthOfBirth;
    }

    @JsonProperty("monthOfBirth")
    public void setMonthOfBirth(String monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public CustomDetails withMonthOfBirth(String monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
        return this;
    }

    @JsonProperty("mothersName")
    public String getMothersName() {
        return mothersName;
    }

    @JsonProperty("mothersName")
    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public CustomDetails withMothersName(String mothersName) {
        this.mothersName = mothersName;
        return this;
    }

    @JsonProperty("mothersNameNationalLanguage")
    public String getMothersNameNationalLanguage() {
        return mothersNameNationalLanguage;
    }

    @JsonProperty("mothersNameNationalLanguage")
    public void setMothersNameNationalLanguage(String mothersNameNationalLanguage) {
        this.mothersNameNationalLanguage = mothersNameNationalLanguage;
    }

    public CustomDetails withMothersNameNationalLanguage(String mothersNameNationalLanguage) {
        this.mothersNameNationalLanguage = mothersNameNationalLanguage;
        return this;
    }

    @JsonProperty("mothersSurnameAtBirth")
    public String getMothersSurnameAtBirth() {
        return mothersSurnameAtBirth;
    }

    @JsonProperty("mothersSurnameAtBirth")
    public void setMothersSurnameAtBirth(String mothersSurnameAtBirth) {
        this.mothersSurnameAtBirth = mothersSurnameAtBirth;
    }

    public CustomDetails withMothersSurnameAtBirth(String mothersSurnameAtBirth) {
        this.mothersSurnameAtBirth = mothersSurnameAtBirth;
        return this;
    }

    @JsonProperty("municipality")
    public String getMunicipality() {
        return municipality;
    }

    @JsonProperty("municipality")
    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public CustomDetails withMunicipality(String municipality) {
        this.municipality = municipality;
        return this;
    }

    @JsonProperty("nameAndSurnameOfKids")
    public String getNameAndSurnameOfKids() {
        return nameAndSurnameOfKids;
    }

    @JsonProperty("nameAndSurnameOfKids")
    public void setNameAndSurnameOfKids(String nameAndSurnameOfKids) {
        this.nameAndSurnameOfKids = nameAndSurnameOfKids;
    }

    public CustomDetails withNameAndSurnameOfKids(String nameAndSurnameOfKids) {
        this.nameAndSurnameOfKids = nameAndSurnameOfKids;
        return this;
    }

    @JsonProperty("nameAndSurnameOfSpouse")
    public String getNameAndSurnameOfSpouse() {
        return nameAndSurnameOfSpouse;
    }

    @JsonProperty("nameAndSurnameOfSpouse")
    public void setNameAndSurnameOfSpouse(String nameAndSurnameOfSpouse) {
        this.nameAndSurnameOfSpouse = nameAndSurnameOfSpouse;
    }

    public CustomDetails withNameAndSurnameOfSpouse(String nameAndSurnameOfSpouse) {
        this.nameAndSurnameOfSpouse = nameAndSurnameOfSpouse;
        return this;
    }

    @JsonProperty("nationalId")
    public String getNationalId() {
        return nationalId;
    }

    @JsonProperty("nationalId")
    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public CustomDetails withNationalId(String nationalId) {
        this.nationalId = nationalId;
        return this;
    }

    @JsonProperty("nationality")
    public String getNationality() {
        return nationality;
    }

    @JsonProperty("nationality")
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public CustomDetails withNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    @JsonProperty("nationalityFreeText")
    public String getNationalityFreeText() {
        return nationalityFreeText;
    }

    @JsonProperty("nationalityFreeText")
    public void setNationalityFreeText(String nationalityFreeText) {
        this.nationalityFreeText = nationalityFreeText;
    }

    public CustomDetails withNationalityFreeText(String nationalityFreeText) {
        this.nationalityFreeText = nationalityFreeText;
        return this;
    }

    @JsonProperty("nationalityNationalLanguage")
    public String getNationalityNationalLanguage() {
        return nationalityNationalLanguage;
    }

    @JsonProperty("nationalityNationalLanguage")
    public void setNationalityNationalLanguage(String nationalityNationalLanguage) {
        this.nationalityNationalLanguage = nationalityNationalLanguage;
    }

    public CustomDetails withNationalityNationalLanguage(String nationalityNationalLanguage) {
        this.nationalityNationalLanguage = nationalityNationalLanguage;
        return this;
    }

    @JsonProperty("nickname")
    public String getNickname() {
        return nickname;
    }

    @JsonProperty("nickname")
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public CustomDetails withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    @JsonProperty("notes")
    public String getNotes() {
        return notes;
    }

    @JsonProperty("notes")
    public void setNotes(String notes) {
        this.notes = notes;
    }

    public CustomDetails withNotes(String notes) {
        this.notes = notes;
        return this;
    }

    @JsonProperty("notesNationalLanguage")
    public String getNotesNationalLanguage() {
        return notesNationalLanguage;
    }

    @JsonProperty("notesNationalLanguage")
    public void setNotesNationalLanguage(String notesNationalLanguage) {
        this.notesNationalLanguage = notesNationalLanguage;
    }

    public CustomDetails withNotesNationalLanguage(String notesNationalLanguage) {
        this.notesNationalLanguage = notesNationalLanguage;
        return this;
    }

    @JsonProperty("observations")
    public String getObservations() {
        return observations;
    }

    @JsonProperty("observations")
    public void setObservations(String observations) {
        this.observations = observations;
    }

    public CustomDetails withObservations(String observations) {
        this.observations = observations;
        return this;
    }

    @JsonProperty("occupation")
    public String getOccupation() {
        return occupation;
    }

    @JsonProperty("occupation")
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public CustomDetails withOccupation(String occupation) {
        this.occupation = occupation;
        return this;
    }

    @JsonProperty("organDonation")
    public String getOrganDonation() {
        return organDonation;
    }

    @JsonProperty("organDonation")
    public void setOrganDonation(String organDonation) {
        this.organDonation = organDonation;
    }

    public CustomDetails withOrganDonation(String organDonation) {
        this.organDonation = organDonation;
        return this;
    }

    @JsonProperty("ori")
    public String getOri() {
        return ori;
    }

    @JsonProperty("ori")
    public void setOri(String ori) {
        this.ori = ori;
    }

    public CustomDetails withOri(String ori) {
        this.ori = ori;
        return this;
    }

    @JsonProperty("otherFeatures")
    public String getOtherFeatures() {
        return otherFeatures;
    }

    @JsonProperty("otherFeatures")
    public void setOtherFeatures(String otherFeatures) {
        this.otherFeatures = otherFeatures;
    }

    public CustomDetails withOtherFeatures(String otherFeatures) {
        this.otherFeatures = otherFeatures;
        return this;
    }

    @JsonProperty("parentNames")
    public String getParentNames() {
        return parentNames;
    }

    @JsonProperty("parentNames")
    public void setParentNames(String parentNames) {
        this.parentNames = parentNames;
    }

    public CustomDetails withParentNames(String parentNames) {
        this.parentNames = parentNames;
        return this;
    }

    @JsonProperty("parentsGivenNames")
    public String getParentsGivenNames() {
        return parentsGivenNames;
    }

    @JsonProperty("parentsGivenNames")
    public void setParentsGivenNames(String parentsGivenNames) {
        this.parentsGivenNames = parentsGivenNames;
    }

    public CustomDetails withParentsGivenNames(String parentsGivenNames) {
        this.parentsGivenNames = parentsGivenNames;
        return this;
    }

    @JsonProperty("passportNumber")
    public String getPassportNumber() {
        return passportNumber;
    }

    @JsonProperty("passportNumber")
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public CustomDetails withPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
        return this;
    }

    @JsonProperty("personCategoryCode")
    public String getPersonCategoryCode() {
        return personCategoryCode;
    }

    @JsonProperty("personCategoryCode")
    public void setPersonCategoryCode(String personCategoryCode) {
        this.personCategoryCode = personCategoryCode;
    }

    public CustomDetails withPersonCategoryCode(String personCategoryCode) {
        this.personCategoryCode = personCategoryCode;
        return this;
    }

    @JsonProperty("personalNumber")
    public String getPersonalNumber() {
        return personalNumber;
    }

    @JsonProperty("personalNumber")
    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public CustomDetails withPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
        return this;
    }

    @JsonProperty("personalNumberNationalLanguage")
    public String getPersonalNumberNationalLanguage() {
        return personalNumberNationalLanguage;
    }

    @JsonProperty("personalNumberNationalLanguage")
    public void setPersonalNumberNationalLanguage(String personalNumberNationalLanguage) {
        this.personalNumberNationalLanguage = personalNumberNationalLanguage;
    }

    public CustomDetails withPersonalNumberNationalLanguage(String personalNumberNationalLanguage) {
        this.personalNumberNationalLanguage = personalNumberNationalLanguage;
        return this;
    }

    @JsonProperty("personalNumberOfKids")
    public String getPersonalNumberOfKids() {
        return personalNumberOfKids;
    }

    @JsonProperty("personalNumberOfKids")
    public void setPersonalNumberOfKids(String personalNumberOfKids) {
        this.personalNumberOfKids = personalNumberOfKids;
    }

    public CustomDetails withPersonalNumberOfKids(String personalNumberOfKids) {
        this.personalNumberOfKids = personalNumberOfKids;
        return this;
    }

    @JsonProperty("personalNumberOfSpouse")
    public String getPersonalNumberOfSpouse() {
        return personalNumberOfSpouse;
    }

    @JsonProperty("personalNumberOfSpouse")
    public void setPersonalNumberOfSpouse(String personalNumberOfSpouse) {
        this.personalNumberOfSpouse = personalNumberOfSpouse;
    }

    public CustomDetails withPersonalNumberOfSpouse(String personalNumberOfSpouse) {
        this.personalNumberOfSpouse = personalNumberOfSpouse;
        return this;
    }

    @JsonProperty("phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @JsonProperty("phoneNumber")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CustomDetails withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @JsonProperty("placeOfBirth")
    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    @JsonProperty("placeOfBirth")
    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public CustomDetails withPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
        return this;
    }

    @JsonProperty("placeOfBirthNationalLanguage")
    public String getPlaceOfBirthNationalLanguage() {
        return placeOfBirthNationalLanguage;
    }

    @JsonProperty("placeOfBirthNationalLanguage")
    public void setPlaceOfBirthNationalLanguage(String placeOfBirthNationalLanguage) {
        this.placeOfBirthNationalLanguage = placeOfBirthNationalLanguage;
    }

    public CustomDetails withPlaceOfBirthNationalLanguage(String placeOfBirthNationalLanguage) {
        this.placeOfBirthNationalLanguage = placeOfBirthNationalLanguage;
        return this;
    }

    @JsonProperty("placeOfIssue")
    public String getPlaceOfIssue() {
        return placeOfIssue;
    }

    @JsonProperty("placeOfIssue")
    public void setPlaceOfIssue(String placeOfIssue) {
        this.placeOfIssue = placeOfIssue;
    }

    public CustomDetails withPlaceOfIssue(String placeOfIssue) {
        this.placeOfIssue = placeOfIssue;
        return this;
    }

    @JsonProperty("postmaster")
    public String getPostmaster() {
        return postmaster;
    }

    @JsonProperty("postmaster")
    public void setPostmaster(String postmaster) {
        this.postmaster = postmaster;
    }

    public CustomDetails withPostmaster(String postmaster) {
        this.postmaster = postmaster;
        return this;
    }

    @JsonProperty("procedure")
    public String getProcedure() {
        return procedure;
    }

    @JsonProperty("procedure")
    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public CustomDetails withProcedure(String procedure) {
        this.procedure = procedure;
        return this;
    }

    @JsonProperty("profession")
    public String getProfession() {
        return profession;
    }

    @JsonProperty("profession")
    public void setProfession(String profession) {
        this.profession = profession;
    }

    public CustomDetails withProfession(String profession) {
        this.profession = profession;
        return this;
    }

    @JsonProperty("professionFreeText")
    public String getProfessionFreeText() {
        return professionFreeText;
    }

    @JsonProperty("professionFreeText")
    public void setProfessionFreeText(String professionFreeText) {
        this.professionFreeText = professionFreeText;
    }

    public CustomDetails withProfessionFreeText(String professionFreeText) {
        this.professionFreeText = professionFreeText;
        return this;
    }

    @JsonProperty("professionNationalLanguage")
    public String getProfessionNationalLanguage() {
        return professionNationalLanguage;
    }

    @JsonProperty("professionNationalLanguage")
    public void setProfessionNationalLanguage(String professionNationalLanguage) {
        this.professionNationalLanguage = professionNationalLanguage;
    }

    public CustomDetails withProfessionNationalLanguage(String professionNationalLanguage) {
        this.professionNationalLanguage = professionNationalLanguage;
        return this;
    }

    @JsonProperty("province")
    public String getProvince() {
        return province;
    }

    @JsonProperty("province")
    public void setProvince(String province) {
        this.province = province;
    }

    public CustomDetails withProvince(String province) {
        this.province = province;
        return this;
    }

    @JsonProperty("provinceOfBirth")
    public String getProvinceOfBirth() {
        return provinceOfBirth;
    }

    @JsonProperty("provinceOfBirth")
    public void setProvinceOfBirth(String provinceOfBirth) {
        this.provinceOfBirth = provinceOfBirth;
    }

    public CustomDetails withProvinceOfBirth(String provinceOfBirth) {
        this.provinceOfBirth = provinceOfBirth;
        return this;
    }

    @JsonProperty("race")
    public String getRace() {
        return race;
    }

    @JsonProperty("race")
    public void setRace(String race) {
        this.race = race;
    }

    public CustomDetails withRace(String race) {
        this.race = race;
        return this;
    }

    @JsonProperty("racialCharacteristic")
    public String getRacialCharacteristic() {
        return racialCharacteristic;
    }

    @JsonProperty("racialCharacteristic")
    public void setRacialCharacteristic(String racialCharacteristic) {
        this.racialCharacteristic = racialCharacteristic;
    }

    public CustomDetails withRacialCharacteristic(String racialCharacteristic) {
        this.racialCharacteristic = racialCharacteristic;
        return this;
    }

    @JsonProperty("recordedAt")
    public String getRecordedAt() {
        return recordedAt;
    }

    @JsonProperty("recordedAt")
    public void setRecordedAt(String recordedAt) {
        this.recordedAt = recordedAt;
    }

    public CustomDetails withRecordedAt(String recordedAt) {
        this.recordedAt = recordedAt;
        return this;
    }

    @JsonProperty("recordedBy")
    public String getRecordedBy() {
        return recordedBy;
    }

    @JsonProperty("recordedBy")
    public void setRecordedBy(String recordedBy) {
        this.recordedBy = recordedBy;
    }

    public CustomDetails withRecordedBy(String recordedBy) {
        this.recordedBy = recordedBy;
        return this;
    }

    @JsonProperty("recordedOn")
    public String getRecordedOn() {
        return recordedOn;
    }

    @JsonProperty("recordedOn")
    public void setRecordedOn(String recordedOn) {
        this.recordedOn = recordedOn;
    }

    public CustomDetails withRecordedOn(String recordedOn) {
        this.recordedOn = recordedOn;
        return this;
    }

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    public CustomDetails withRegion(String region) {
        this.region = region;
        return this;
    }

    @JsonProperty("registrationCentreCode")
    public String getRegistrationCentreCode() {
        return registrationCentreCode;
    }

    @JsonProperty("registrationCentreCode")
    public void setRegistrationCentreCode(String registrationCentreCode) {
        this.registrationCentreCode = registrationCentreCode;
    }

    public CustomDetails withRegistrationCentreCode(String registrationCentreCode) {
        this.registrationCentreCode = registrationCentreCode;
        return this;
    }

    @JsonProperty("registrationCentreName")
    public String getRegistrationCentreName() {
        return registrationCentreName;
    }

    @JsonProperty("registrationCentreName")
    public void setRegistrationCentreName(String registrationCentreName) {
        this.registrationCentreName = registrationCentreName;
    }

    public CustomDetails withRegistrationCentreName(String registrationCentreName) {
        this.registrationCentreName = registrationCentreName;
        return this;
    }

    @JsonProperty("registrationConstituencyCode")
    public String getRegistrationConstituencyCode() {
        return registrationConstituencyCode;
    }

    @JsonProperty("registrationConstituencyCode")
    public void setRegistrationConstituencyCode(String registrationConstituencyCode) {
        this.registrationConstituencyCode = registrationConstituencyCode;
    }

    public CustomDetails withRegistrationConstituencyCode(String registrationConstituencyCode) {
        this.registrationConstituencyCode = registrationConstituencyCode;
        return this;
    }

    @JsonProperty("registrationConstituencyName")
    public String getRegistrationConstituencyName() {
        return registrationConstituencyName;
    }

    @JsonProperty("registrationConstituencyName")
    public void setRegistrationConstituencyName(String registrationConstituencyName) {
        this.registrationConstituencyName = registrationConstituencyName;
    }

    public CustomDetails withRegistrationConstituencyName(String registrationConstituencyName) {
        this.registrationConstituencyName = registrationConstituencyName;
        return this;
    }

    @JsonProperty("registrationCountryCode")
    public String getRegistrationCountryCode() {
        return registrationCountryCode;
    }

    @JsonProperty("registrationCountryCode")
    public void setRegistrationCountryCode(String registrationCountryCode) {
        this.registrationCountryCode = registrationCountryCode;
    }

    public CustomDetails withRegistrationCountryCode(String registrationCountryCode) {
        this.registrationCountryCode = registrationCountryCode;
        return this;
    }

    @JsonProperty("registrationCountryName")
    public String getRegistrationCountryName() {
        return registrationCountryName;
    }

    @JsonProperty("registrationCountryName")
    public void setRegistrationCountryName(String registrationCountryName) {
        this.registrationCountryName = registrationCountryName;
    }

    public CustomDetails withRegistrationCountryName(String registrationCountryName) {
        this.registrationCountryName = registrationCountryName;
        return this;
    }

    @JsonProperty("registrationCountyCode")
    public String getRegistrationCountyCode() {
        return registrationCountyCode;
    }

    @JsonProperty("registrationCountyCode")
    public void setRegistrationCountyCode(String registrationCountyCode) {
        this.registrationCountyCode = registrationCountyCode;
    }

    public CustomDetails withRegistrationCountyCode(String registrationCountyCode) {
        this.registrationCountyCode = registrationCountyCode;
        return this;
    }

    @JsonProperty("registrationCountyName")
    public String getRegistrationCountyName() {
        return registrationCountyName;
    }

    @JsonProperty("registrationCountyName")
    public void setRegistrationCountyName(String registrationCountyName) {
        this.registrationCountyName = registrationCountyName;
    }

    public CustomDetails withRegistrationCountyName(String registrationCountyName) {
        this.registrationCountyName = registrationCountyName;
        return this;
    }

    @JsonProperty("registrationNumber")
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @JsonProperty("registrationNumber")
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public CustomDetails withRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
        return this;
    }

    @JsonProperty("registrationType")
    public String getRegistrationType() {
        return registrationType;
    }

    @JsonProperty("registrationType")
    public void setRegistrationType(String registrationType) {
        this.registrationType = registrationType;
    }

    public CustomDetails withRegistrationType(String registrationType) {
        this.registrationType = registrationType;
        return this;
    }

    @JsonProperty("registrationWardCode")
    public String getRegistrationWardCode() {
        return registrationWardCode;
    }

    @JsonProperty("registrationWardCode")
    public void setRegistrationWardCode(String registrationWardCode) {
        this.registrationWardCode = registrationWardCode;
    }

    public CustomDetails withRegistrationWardCode(String registrationWardCode) {
        this.registrationWardCode = registrationWardCode;
        return this;
    }

    @JsonProperty("registrationWardName")
    public String getRegistrationWardName() {
        return registrationWardName;
    }

    @JsonProperty("registrationWardName")
    public void setRegistrationWardName(String registrationWardName) {
        this.registrationWardName = registrationWardName;
    }

    public CustomDetails withRegistrationWardName(String registrationWardName) {
        this.registrationWardName = registrationWardName;
        return this;
    }

    @JsonProperty("religion")
    public String getReligion() {
        return religion;
    }

    @JsonProperty("religion")
    public void setReligion(String religion) {
        this.religion = religion;
    }

    public CustomDetails withReligion(String religion) {
        this.religion = religion;
        return this;
    }

    @JsonProperty("remarks")
    public String getRemarks() {
        return remarks;
    }

    @JsonProperty("remarks")
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public CustomDetails withRemarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    @JsonProperty("reportReason")
    public String getReportReason() {
        return reportReason;
    }

    @JsonProperty("reportReason")
    public void setReportReason(String reportReason) {
        this.reportReason = reportReason;
    }

    public CustomDetails withReportReason(String reportReason) {
        this.reportReason = reportReason;
        return this;
    }

    @JsonProperty("restrictions")
    public String getRestrictions() {
        return restrictions;
    }

    @JsonProperty("restrictions")
    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    public CustomDetails withRestrictions(String restrictions) {
        this.restrictions = restrictions;
        return this;
    }

    @JsonProperty("secondSurname")
    public String getSecondSurname() {
        return secondSurname;
    }

    @JsonProperty("secondSurname")
    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public CustomDetails withSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
        return this;
    }

    @JsonProperty("section")
    public String getSection() {
        return section;
    }

    @JsonProperty("section")
    public void setSection(String section) {
        this.section = section;
    }

    public CustomDetails withSection(String section) {
        this.section = section;
        return this;
    }

    @JsonProperty("securityNumber")
    public String getSecurityNumber() {
        return securityNumber;
    }

    @JsonProperty("securityNumber")
    public void setSecurityNumber(String securityNumber) {
        this.securityNumber = securityNumber;
    }

    public CustomDetails withSecurityNumber(String securityNumber) {
        this.securityNumber = securityNumber;
        return this;
    }

    @JsonProperty("sex")
    public String getSex() {
        return sex;
    }

    @JsonProperty("sex")
    public void setSex(String sex) {
        this.sex = sex;
    }

    public CustomDetails withSex(String sex) {
        this.sex = sex;
        return this;
    }

    @JsonProperty("sexFreeText")
    public String getSexFreeText() {
        return sexFreeText;
    }

    @JsonProperty("sexFreeText")
    public void setSexFreeText(String sexFreeText) {
        this.sexFreeText = sexFreeText;
    }

    public CustomDetails withSexFreeText(String sexFreeText) {
        this.sexFreeText = sexFreeText;
        return this;
    }

    @JsonProperty("sexNationalLanguage")
    public String getSexNationalLanguage() {
        return sexNationalLanguage;
    }

    @JsonProperty("sexNationalLanguage")
    public void setSexNationalLanguage(String sexNationalLanguage) {
        this.sexNationalLanguage = sexNationalLanguage;
    }

    public CustomDetails withSexNationalLanguage(String sexNationalLanguage) {
        this.sexNationalLanguage = sexNationalLanguage;
        return this;
    }

    @JsonProperty("snapshot")
    public String getSnapshot() {
        return snapshot;
    }

    @JsonProperty("snapshot")
    public void setSnapshot(String snapshot) {
        this.snapshot = snapshot;
    }

    public CustomDetails withSnapshot(String snapshot) {
        this.snapshot = snapshot;
        return this;
    }

    @JsonProperty("sourceSystem")
    public String getSourceSystem() {
        return sourceSystem;
    }

    @JsonProperty("sourceSystem")
    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public CustomDetails withSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
        return this;
    }

    @JsonProperty("spassNumber")
    public String getSpassNumber() {
        return spassNumber;
    }

    @JsonProperty("spassNumber")
    public void setSpassNumber(String spassNumber) {
        this.spassNumber = spassNumber;
    }

    public CustomDetails withSpassNumber(String spassNumber) {
        this.spassNumber = spassNumber;
        return this;
    }

    @JsonProperty("specialNeeds")
    public String getSpecialNeeds() {
        return specialNeeds;
    }

    @JsonProperty("specialNeeds")
    public void setSpecialNeeds(String specialNeeds) {
        this.specialNeeds = specialNeeds;
    }

    public CustomDetails withSpecialNeeds(String specialNeeds) {
        this.specialNeeds = specialNeeds;
        return this;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    public CustomDetails withState(String state) {
        this.state = state;
        return this;
    }

    @JsonProperty("surname")
    public String getSurname() {
        return surname;
    }

    @JsonProperty("surname")
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public CustomDetails withSurname(String surname) {
        this.surname = surname;
        return this;
    }

    @JsonProperty("surnameAtBirth")
    public String getSurnameAtBirth() {
        return surnameAtBirth;
    }

    @JsonProperty("surnameAtBirth")
    public void setSurnameAtBirth(String surnameAtBirth) {
        this.surnameAtBirth = surnameAtBirth;
    }

    public CustomDetails withSurnameAtBirth(String surnameAtBirth) {
        this.surnameAtBirth = surnameAtBirth;
        return this;
    }

    @JsonProperty("surnameNationalLanguage")
    public String getSurnameNationalLanguage() {
        return surnameNationalLanguage;
    }

    @JsonProperty("surnameNationalLanguage")
    public void setSurnameNationalLanguage(String surnameNationalLanguage) {
        this.surnameNationalLanguage = surnameNationalLanguage;
    }

    public CustomDetails withSurnameNationalLanguage(String surnameNationalLanguage) {
        this.surnameNationalLanguage = surnameNationalLanguage;
        return this;
    }

    @JsonProperty("taxNo")
    public String getTaxNo() {
        return taxNo;
    }

    @JsonProperty("taxNo")
    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    public CustomDetails withTaxNo(String taxNo) {
        this.taxNo = taxNo;
        return this;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public CustomDetails withTitle(String title) {
        this.title = title;
        return this;
    }

    @JsonProperty("torsoMarks")
    public String getTorsoMarks() {
        return torsoMarks;
    }

    @JsonProperty("torsoMarks")
    public void setTorsoMarks(String torsoMarks) {
        this.torsoMarks = torsoMarks;
    }

    public CustomDetails withTorsoMarks(String torsoMarks) {
        this.torsoMarks = torsoMarks;
        return this;
    }

    @JsonProperty("transactionNumber")
    public String getTransactionNumber() {
        return transactionNumber;
    }

    @JsonProperty("transactionNumber")
    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public CustomDetails withTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
        return this;
    }

    @JsonProperty("transactionType")
    public String getTransactionType() {
        return transactionType;
    }

    @JsonProperty("transactionType")
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public CustomDetails withTransactionType(String transactionType) {
        this.transactionType = transactionType;
        return this;
    }

    @JsonProperty("updateType")
    public String getUpdateType() {
        return updateType;
    }

    @JsonProperty("updateType")
    public void setUpdateType(String updateType) {
        this.updateType = updateType;
    }

    public CustomDetails withUpdateType(String updateType) {
        this.updateType = updateType;
        return this;
    }

    @JsonProperty("voice")
    public String getVoice() {
        return voice;
    }

    @JsonProperty("voice")
    public void setVoice(String voice) {
        this.voice = voice;
    }

    public CustomDetails withVoice(String voice) {
        this.voice = voice;
        return this;
    }

    @JsonProperty("votersIdentificationNumber")
    public String getVotersIdentificationNumber() {
        return votersIdentificationNumber;
    }

    @JsonProperty("votersIdentificationNumber")
    public void setVotersIdentificationNumber(String votersIdentificationNumber) {
        this.votersIdentificationNumber = votersIdentificationNumber;
    }

    public CustomDetails withVotersIdentificationNumber(String votersIdentificationNumber) {
        this.votersIdentificationNumber = votersIdentificationNumber;
        return this;
    }

    @JsonProperty("votingCentreCode")
    public String getVotingCentreCode() {
        return votingCentreCode;
    }

    @JsonProperty("votingCentreCode")
    public void setVotingCentreCode(String votingCentreCode) {
        this.votingCentreCode = votingCentreCode;
    }

    public CustomDetails withVotingCentreCode(String votingCentreCode) {
        this.votingCentreCode = votingCentreCode;
        return this;
    }

    @JsonProperty("votingCentreName")
    public String getVotingCentreName() {
        return votingCentreName;
    }

    @JsonProperty("votingCentreName")
    public void setVotingCentreName(String votingCentreName) {
        this.votingCentreName = votingCentreName;
    }

    public CustomDetails withVotingCentreName(String votingCentreName) {
        this.votingCentreName = votingCentreName;
        return this;
    }

    @JsonProperty("votingConstituencyCode")
    public String getVotingConstituencyCode() {
        return votingConstituencyCode;
    }

    @JsonProperty("votingConstituencyCode")
    public void setVotingConstituencyCode(String votingConstituencyCode) {
        this.votingConstituencyCode = votingConstituencyCode;
    }

    public CustomDetails withVotingConstituencyCode(String votingConstituencyCode) {
        this.votingConstituencyCode = votingConstituencyCode;
        return this;
    }

    @JsonProperty("votingConstituencyName")
    public String getVotingConstituencyName() {
        return votingConstituencyName;
    }

    @JsonProperty("votingConstituencyName")
    public void setVotingConstituencyName(String votingConstituencyName) {
        this.votingConstituencyName = votingConstituencyName;
    }

    public CustomDetails withVotingConstituencyName(String votingConstituencyName) {
        this.votingConstituencyName = votingConstituencyName;
        return this;
    }

    @JsonProperty("votingCountryCode")
    public String getVotingCountryCode() {
        return votingCountryCode;
    }

    @JsonProperty("votingCountryCode")
    public void setVotingCountryCode(String votingCountryCode) {
        this.votingCountryCode = votingCountryCode;
    }

    public CustomDetails withVotingCountryCode(String votingCountryCode) {
        this.votingCountryCode = votingCountryCode;
        return this;
    }

    @JsonProperty("votingCountryName")
    public String getVotingCountryName() {
        return votingCountryName;
    }

    @JsonProperty("votingCountryName")
    public void setVotingCountryName(String votingCountryName) {
        this.votingCountryName = votingCountryName;
    }

    public CustomDetails withVotingCountryName(String votingCountryName) {
        this.votingCountryName = votingCountryName;
        return this;
    }

    @JsonProperty("votingCountyCode")
    public String getVotingCountyCode() {
        return votingCountyCode;
    }

    @JsonProperty("votingCountyCode")
    public void setVotingCountyCode(String votingCountyCode) {
        this.votingCountyCode = votingCountyCode;
    }

    public CustomDetails withVotingCountyCode(String votingCountyCode) {
        this.votingCountyCode = votingCountyCode;
        return this;
    }

    @JsonProperty("votingCountyName")
    public String getVotingCountyName() {
        return votingCountyName;
    }

    @JsonProperty("votingCountyName")
    public void setVotingCountyName(String votingCountyName) {
        this.votingCountyName = votingCountyName;
    }

    public CustomDetails withVotingCountyName(String votingCountyName) {
        this.votingCountyName = votingCountyName;
        return this;
    }

    @JsonProperty("votingWardCode")
    public String getVotingWardCode() {
        return votingWardCode;
    }

    @JsonProperty("votingWardCode")
    public void setVotingWardCode(String votingWardCode) {
        this.votingWardCode = votingWardCode;
    }

    public CustomDetails withVotingWardCode(String votingWardCode) {
        this.votingWardCode = votingWardCode;
        return this;
    }

    @JsonProperty("votingWardName")
    public String getVotingWardName() {
        return votingWardName;
    }

    @JsonProperty("votingWardName")
    public void setVotingWardName(String votingWardName) {
        this.votingWardName = votingWardName;
    }

    public CustomDetails withVotingWardName(String votingWardName) {
        this.votingWardName = votingWardName;
        return this;
    }

    @JsonProperty("weight")
    public String getWeight() {
        return weight;
    }

    @JsonProperty("weight")
    public void setWeight(String weight) {
        this.weight = weight;
    }

    public CustomDetails withWeight(String weight) {
        this.weight = weight;
        return this;
    }

    @JsonProperty("workPermitNumber")
    public String getWorkPermitNumber() {
        return workPermitNumber;
    }

    @JsonProperty("workPermitNumber")
    public void setWorkPermitNumber(String workPermitNumber) {
        this.workPermitNumber = workPermitNumber;
    }

    public CustomDetails withWorkPermitNumber(String workPermitNumber) {
        this.workPermitNumber = workPermitNumber;
        return this;
    }

    @JsonProperty("yearOfBirth")
    public String getYearOfBirth() {
        return yearOfBirth;
    }

    @JsonProperty("yearOfBirth")
    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public CustomDetails withYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
        return this;
    }

    @JsonProperty("yearOfRegistration")
    public String getYearOfRegistration() {
        return yearOfRegistration;
    }

    @JsonProperty("yearOfRegistration")
    public void setYearOfRegistration(String yearOfRegistration) {
        this.yearOfRegistration = yearOfRegistration;
    }

    public CustomDetails withYearOfRegistration(String yearOfRegistration) {
        this.yearOfRegistration = yearOfRegistration;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public CustomDetails withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return "CustomDetails{" +
                "address='" + address + '\'' +
                ", addressCountry='" + addressCountry + '\'' +
                ", addressPlace='" + addressPlace + '\'' +
                ", age='" + age + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", can='" + can + '\'' +
                ", chairman='" + chairman + '\'' +
                ", citizenship='" + citizenship + '\'' +
                ", citizenshipStatus='" + citizenshipStatus + '\'' +
                ", city='" + city + '\'' +
                ", civilStatus='" + civilStatus + '\'' +
                ", commercialTelegraphicCode='" + commercialTelegraphicCode + '\'' +
                ", conditions='" + conditions + '\'' +
                ", corpulence='" + corpulence + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", dateAndPlaceOfBirth='" + dateAndPlaceOfBirth + '\'' +
                ", dateAndPlaceOfIssue='" + dateAndPlaceOfIssue + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", dateOfBirthNationalLanguage='" + dateOfBirthNationalLanguage + '\'' +
                ", dateOfExpiry='" + dateOfExpiry + '\'' +
                ", dateOfExpiryNationalLanguage='" + dateOfExpiryNationalLanguage + '\'' +
                ", dateOfFirstRegistration='" + dateOfFirstRegistration + '\'' +
                ", dateOfIssue='" + dateOfIssue + '\'' +
                ", dateOfIssueNationalLanguage='" + dateOfIssueNationalLanguage + '\'' +
                ", dateOfModification='" + dateOfModification + '\'' +
                ", dateOfRegistration='" + dateOfRegistration + '\'' +
                ", dayOfBirth='" + dayOfBirth + '\'' +
                ", district='" + district + '\'' +
                ", division='" + division + '\'' +
                ", documentIssuedBy='" + documentIssuedBy + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", documentType='" + documentType + '\'' +
                ", documentTypeCode='" + documentTypeCode + '\'' +
                ", documentTypeNationalLanguage='" + documentTypeNationalLanguage + '\'' +
                ", donor='" + donor + '\'' +
                ", drivingCategories='" + drivingCategories + '\'' +
                ", drivingCategoriesNationalLanguage='" + drivingCategoriesNationalLanguage + '\'' +
                ", education='" + education + '\'' +
                ", email='" + email + '\'' +
                ", emergencyAddress='" + emergencyAddress + '\'' +
                ", emergencyName='" + emergencyName + '\'' +
                ", emergencyPhoneNumber='" + emergencyPhoneNumber + '\'' +
                ", employer='" + employer + '\'' +
                ", encounterMissionType='" + encounterMissionType + '\'' +
                ", estimatedDate='" + estimatedDate + '\'' +
                ", ethnicType='" + ethnicType + '\'' +
                ", eyesColor='" + eyesColor + '\'' +
                ", faceFeatures='" + faceFeatures + '\'' +
                ", faceMarks='" + faceMarks + '\'' +
                ", fathersName='" + fathersName + '\'' +
                ", fathersNameNationalLanguage='" + fathersNameNationalLanguage + '\'' +
                ", fin='" + fin + '\'' +
                ", fpClassificationLeft='" + fpClassificationLeft + '\'' +
                ", fpClassificationRight='" + fpClassificationRight + '\'' +
                ", fullName='" + fullName + '\'' +
                ", fullNameNationalLanguage='" + fullNameNationalLanguage + '\'' +
                ", givenNames='" + givenNames + '\'' +
                ", givenNamesNationalLanguage='" + givenNamesNationalLanguage + '\'' +
                ", hairColor='" + hairColor + '\'' +
                ", healthNumber='" + healthNumber + '\'' +
                ", height='" + height + '\'' +
                ", immigrationStatus='" + immigrationStatus + '\'' +
                ", issuingAuthority='" + issuingAuthority + '\'' +
                ", job='" + job + '\'' +
                ", licenceDate='" + licenceDate + '\'' +
                ", licenceVersion='" + licenceVersion + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", limbsMarks='" + limbsMarks + '\'' +
                ", literate='" + literate + '\'' +
                ", location='" + location + '\'' +
                ", lockVersion='" + lockVersion + '\'' +
                ", machineReadableZone='" + machineReadableZone + '\'' +
                ", middleName='" + middleName + '\'' +
                ", modification='" + modification + '\'' +
                ", monthOfBirth='" + monthOfBirth + '\'' +
                ", mothersName='" + mothersName + '\'' +
                ", mothersNameNationalLanguage='" + mothersNameNationalLanguage + '\'' +
                ", mothersSurnameAtBirth='" + mothersSurnameAtBirth + '\'' +
                ", municipality='" + municipality + '\'' +
                ", nameAndSurnameOfKids='" + nameAndSurnameOfKids + '\'' +
                ", nameAndSurnameOfSpouse='" + nameAndSurnameOfSpouse + '\'' +
                ", nationalId='" + nationalId + '\'' +
                ", nationality='" + nationality + '\'' +
                ", nationalityFreeText='" + nationalityFreeText + '\'' +
                ", nationalityNationalLanguage='" + nationalityNationalLanguage + '\'' +
                ", nickname='" + nickname + '\'' +
                ", notes='" + notes + '\'' +
                ", notesNationalLanguage='" + notesNationalLanguage + '\'' +
                ", observations='" + observations + '\'' +
                ", occupation='" + occupation + '\'' +
                ", organDonation='" + organDonation + '\'' +
                ", ori='" + ori + '\'' +
                ", otherFeatures='" + otherFeatures + '\'' +
                ", parentNames='" + parentNames + '\'' +
                ", parentsGivenNames='" + parentsGivenNames + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", personCategoryCode='" + personCategoryCode + '\'' +
                ", personalNumber='" + personalNumber + '\'' +
                ", personalNumberNationalLanguage='" + personalNumberNationalLanguage + '\'' +
                ", personalNumberOfKids='" + personalNumberOfKids + '\'' +
                ", personalNumberOfSpouse='" + personalNumberOfSpouse + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", placeOfBirthNationalLanguage='" + placeOfBirthNationalLanguage + '\'' +
                ", placeOfIssue='" + placeOfIssue + '\'' +
                ", postmaster='" + postmaster + '\'' +
                ", procedure='" + procedure + '\'' +
                ", profession='" + profession + '\'' +
                ", professionFreeText='" + professionFreeText + '\'' +
                ", professionNationalLanguage='" + professionNationalLanguage + '\'' +
                ", province='" + province + '\'' +
                ", provinceOfBirth='" + provinceOfBirth + '\'' +
                ", race='" + race + '\'' +
                ", racialCharacteristic='" + racialCharacteristic + '\'' +
                ", recordedAt='" + recordedAt + '\'' +
                ", recordedBy='" + recordedBy + '\'' +
                ", recordedOn='" + recordedOn + '\'' +
                ", region='" + region + '\'' +
                ", registrationCentreCode='" + registrationCentreCode + '\'' +
                ", registrationCentreName='" + registrationCentreName + '\'' +
                ", registrationConstituencyCode='" + registrationConstituencyCode + '\'' +
                ", registrationConstituencyName='" + registrationConstituencyName + '\'' +
                ", registrationCountryCode='" + registrationCountryCode + '\'' +
                ", registrationCountryName='" + registrationCountryName + '\'' +
                ", registrationCountyCode='" + registrationCountyCode + '\'' +
                ", registrationCountyName='" + registrationCountyName + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", registrationType='" + registrationType + '\'' +
                ", registrationWardCode='" + registrationWardCode + '\'' +
                ", registrationWardName='" + registrationWardName + '\'' +
                ", religion='" + religion + '\'' +
                ", remarks='" + remarks + '\'' +
                ", reportReason='" + reportReason + '\'' +
                ", restrictions='" + restrictions + '\'' +
                ", secondSurname='" + secondSurname + '\'' +
                ", section='" + section + '\'' +
                ", securityNumber='" + securityNumber + '\'' +
                ", sex='" + sex + '\'' +
                ", sexFreeText='" + sexFreeText + '\'' +
                ", sexNationalLanguage='" + sexNationalLanguage + '\'' +
                ", snapshot='" + snapshot + '\'' +
                ", sourceSystem='" + sourceSystem + '\'' +
                ", spassNumber='" + spassNumber + '\'' +
                ", specialNeeds='" + specialNeeds + '\'' +
                ", state='" + state + '\'' +
                ", surname='" + surname + '\'' +
                ", surnameAtBirth='" + surnameAtBirth + '\'' +
                ", surnameNationalLanguage='" + surnameNationalLanguage + '\'' +
                ", taxNo='" + taxNo + '\'' +
                ", title='" + title + '\'' +
                ", torsoMarks='" + torsoMarks + '\'' +
                ", transactionNumber='" + transactionNumber + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", updateType='" + updateType + '\'' +
                ", voice='" + voice + '\'' +
                ", votersIdentificationNumber='" + votersIdentificationNumber + '\'' +
                ", votingCentreCode='" + votingCentreCode + '\'' +
                ", votingCentreName='" + votingCentreName + '\'' +
                ", votingConstituencyCode='" + votingConstituencyCode + '\'' +
                ", votingConstituencyName='" + votingConstituencyName + '\'' +
                ", votingCountryCode='" + votingCountryCode + '\'' +
                ", votingCountryName='" + votingCountryName + '\'' +
                ", votingCountyCode='" + votingCountyCode + '\'' +
                ", votingCountyName='" + votingCountyName + '\'' +
                ", votingWardCode='" + votingWardCode + '\'' +
                ", votingWardName='" + votingWardName + '\'' +
                ", weight='" + weight + '\'' +
                ", workPermitNumber='" + workPermitNumber + '\'' +
                ", yearOfBirth='" + yearOfBirth + '\'' +
                ", yearOfRegistration='" + yearOfRegistration + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }

}
