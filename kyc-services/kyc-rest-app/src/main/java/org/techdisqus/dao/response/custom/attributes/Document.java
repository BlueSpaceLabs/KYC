
package org.techdisqus.dao.response.custom.attributes;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "can",
    "conditions",
    "country",
    "dateAndPlaceOfIssue",
    "dateOfExpiry",
    "dateOfExpiryNationalLanguage",
    "dateOfExpiryText",
    "dateOfFirstRegistration",
    "dateOfFirstRegistrationText",
    "dateOfIssue",
    "dateOfIssueNationalLanguage",
    "dateOfIssueText",
    "documentPages",
    "drivingCategories",
    "drivingCategoriesNationalLanguage",
    "drivingLicenceVersion",
    "edition",
    "endorsements",
    "ghostPortraitVsPortraitSimilarityScore",
    "issuingAuthority",
    "issuingAuthorityNationalLanguage",
    "mrz",
    "notes",
    "notesNationalLanguage",
    "number",
    "placeOfIssue",
    "placeOfIssueNationalLanguage",
    "portraitVsPrimarySelfieSimilarityScore",
    "primary",
    "remarks",
    "restrictions",
    "section",
    "travelDocumentType",
    "trustFactors",
    "type"
})
@Generated("jsonschema2pojo")
public class Document {

    @JsonProperty("can")
    private String can;
    @JsonProperty("conditions")
    private String conditions;
    @JsonProperty("country")
    private String country;
    @JsonProperty("dateAndPlaceOfIssue")
    private String dateAndPlaceOfIssue;
    @JsonProperty("dateOfExpiry")
    private String dateOfExpiry;
    @JsonProperty("dateOfExpiryNationalLanguage")
    private String dateOfExpiryNationalLanguage;
    @JsonProperty("dateOfExpiryText")
    private String dateOfExpiryText;
    @JsonProperty("dateOfFirstRegistration")
    private String dateOfFirstRegistration;
    @JsonProperty("dateOfFirstRegistrationText")
    private String dateOfFirstRegistrationText;
    @JsonProperty("dateOfIssue")
    private String dateOfIssue;
    @JsonProperty("dateOfIssueNationalLanguage")
    private String dateOfIssueNationalLanguage;
    @JsonProperty("dateOfIssueText")
    private String dateOfIssueText;
    @JsonProperty("documentPages")
    private List<DocumentPage> documentPages;
    @JsonProperty("drivingCategories")
    private String drivingCategories;
    @JsonProperty("drivingCategoriesNationalLanguage")
    private String drivingCategoriesNationalLanguage;
    @JsonProperty("drivingLicenceVersion")
    private String drivingLicenceVersion;
    @JsonProperty("edition")
    private String edition;
    @JsonProperty("endorsements")
    private String endorsements;
    @JsonProperty("ghostPortraitVsPortraitSimilarityScore")
    private String ghostPortraitVsPortraitSimilarityScore;
    @JsonProperty("issuingAuthority")
    private String issuingAuthority;
    @JsonProperty("issuingAuthorityNationalLanguage")
    private String issuingAuthorityNationalLanguage;
    @JsonProperty("mrz")
    private String mrz;
    @JsonProperty("notes")
    private String notes;
    @JsonProperty("notesNationalLanguage")
    private String notesNationalLanguage;
    @JsonProperty("number")
    private String number;
    @JsonProperty("placeOfIssue")
    private String placeOfIssue;
    @JsonProperty("placeOfIssueNationalLanguage")
    private String placeOfIssueNationalLanguage;
    @JsonProperty("portraitVsPrimarySelfieSimilarityScore")
    private String portraitVsPrimarySelfieSimilarityScore;
    @JsonProperty("primary")
    private String primary;
    @JsonProperty("remarks")
    private String remarks;
    @JsonProperty("restrictions")
    private String restrictions;
    @JsonProperty("section")
    private String section;
    @JsonProperty("travelDocumentType")
    private String travelDocumentType;
    @JsonProperty("trustFactors")
    private List<TrustFactor> trustFactors;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("can")
    public String getCan() {
        return can;
    }

    @JsonProperty("can")
    public void setCan(String can) {
        this.can = can;
    }

    public Document withCan(String can) {
        this.can = can;
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

    public Document withConditions(String conditions) {
        this.conditions = conditions;
        return this;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    public Document withCountry(String country) {
        this.country = country;
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

    public Document withDateAndPlaceOfIssue(String dateAndPlaceOfIssue) {
        this.dateAndPlaceOfIssue = dateAndPlaceOfIssue;
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

    public Document withDateOfExpiry(String dateOfExpiry) {
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

    public Document withDateOfExpiryNationalLanguage(String dateOfExpiryNationalLanguage) {
        this.dateOfExpiryNationalLanguage = dateOfExpiryNationalLanguage;
        return this;
    }

    @JsonProperty("dateOfExpiryText")
    public String getDateOfExpiryText() {
        return dateOfExpiryText;
    }

    @JsonProperty("dateOfExpiryText")
    public void setDateOfExpiryText(String dateOfExpiryText) {
        this.dateOfExpiryText = dateOfExpiryText;
    }

    public Document withDateOfExpiryText(String dateOfExpiryText) {
        this.dateOfExpiryText = dateOfExpiryText;
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

    public Document withDateOfFirstRegistration(String dateOfFirstRegistration) {
        this.dateOfFirstRegistration = dateOfFirstRegistration;
        return this;
    }

    @JsonProperty("dateOfFirstRegistrationText")
    public String getDateOfFirstRegistrationText() {
        return dateOfFirstRegistrationText;
    }

    @JsonProperty("dateOfFirstRegistrationText")
    public void setDateOfFirstRegistrationText(String dateOfFirstRegistrationText) {
        this.dateOfFirstRegistrationText = dateOfFirstRegistrationText;
    }

    public Document withDateOfFirstRegistrationText(String dateOfFirstRegistrationText) {
        this.dateOfFirstRegistrationText = dateOfFirstRegistrationText;
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

    public Document withDateOfIssue(String dateOfIssue) {
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

    public Document withDateOfIssueNationalLanguage(String dateOfIssueNationalLanguage) {
        this.dateOfIssueNationalLanguage = dateOfIssueNationalLanguage;
        return this;
    }

    @JsonProperty("dateOfIssueText")
    public String getDateOfIssueText() {
        return dateOfIssueText;
    }

    @JsonProperty("dateOfIssueText")
    public void setDateOfIssueText(String dateOfIssueText) {
        this.dateOfIssueText = dateOfIssueText;
    }

    public Document withDateOfIssueText(String dateOfIssueText) {
        this.dateOfIssueText = dateOfIssueText;
        return this;
    }

    @JsonProperty("documentPages")
    public List<DocumentPage> getDocumentPages() {
        return documentPages;
    }

    @JsonProperty("documentPages")
    public void setDocumentPages(List<DocumentPage> documentPages) {
        this.documentPages = documentPages;
    }

    public Document withDocumentPages(List<DocumentPage> documentPages) {
        this.documentPages = documentPages;
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

    public Document withDrivingCategories(String drivingCategories) {
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

    public Document withDrivingCategoriesNationalLanguage(String drivingCategoriesNationalLanguage) {
        this.drivingCategoriesNationalLanguage = drivingCategoriesNationalLanguage;
        return this;
    }

    @JsonProperty("drivingLicenceVersion")
    public String getDrivingLicenceVersion() {
        return drivingLicenceVersion;
    }

    @JsonProperty("drivingLicenceVersion")
    public void setDrivingLicenceVersion(String drivingLicenceVersion) {
        this.drivingLicenceVersion = drivingLicenceVersion;
    }

    public Document withDrivingLicenceVersion(String drivingLicenceVersion) {
        this.drivingLicenceVersion = drivingLicenceVersion;
        return this;
    }

    @JsonProperty("edition")
    public String getEdition() {
        return edition;
    }

    @JsonProperty("edition")
    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Document withEdition(String edition) {
        this.edition = edition;
        return this;
    }

    @JsonProperty("endorsements")
    public String getEndorsements() {
        return endorsements;
    }

    @JsonProperty("endorsements")
    public void setEndorsements(String endorsements) {
        this.endorsements = endorsements;
    }

    public Document withEndorsements(String endorsements) {
        this.endorsements = endorsements;
        return this;
    }

    @JsonProperty("ghostPortraitVsPortraitSimilarityScore")
    public String getGhostPortraitVsPortraitSimilarityScore() {
        return ghostPortraitVsPortraitSimilarityScore;
    }

    @JsonProperty("ghostPortraitVsPortraitSimilarityScore")
    public void setGhostPortraitVsPortraitSimilarityScore(String ghostPortraitVsPortraitSimilarityScore) {
        this.ghostPortraitVsPortraitSimilarityScore = ghostPortraitVsPortraitSimilarityScore;
    }

    public Document withGhostPortraitVsPortraitSimilarityScore(String ghostPortraitVsPortraitSimilarityScore) {
        this.ghostPortraitVsPortraitSimilarityScore = ghostPortraitVsPortraitSimilarityScore;
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

    public Document withIssuingAuthority(String issuingAuthority) {
        this.issuingAuthority = issuingAuthority;
        return this;
    }

    @JsonProperty("issuingAuthorityNationalLanguage")
    public String getIssuingAuthorityNationalLanguage() {
        return issuingAuthorityNationalLanguage;
    }

    @JsonProperty("issuingAuthorityNationalLanguage")
    public void setIssuingAuthorityNationalLanguage(String issuingAuthorityNationalLanguage) {
        this.issuingAuthorityNationalLanguage = issuingAuthorityNationalLanguage;
    }

    public Document withIssuingAuthorityNationalLanguage(String issuingAuthorityNationalLanguage) {
        this.issuingAuthorityNationalLanguage = issuingAuthorityNationalLanguage;
        return this;
    }

    @JsonProperty("mrz")
    public String getMrz() {
        return mrz;
    }

    @JsonProperty("mrz")
    public void setMrz(String mrz) {
        this.mrz = mrz;
    }

    public Document withMrz(String mrz) {
        this.mrz = mrz;
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

    public Document withNotes(String notes) {
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

    public Document withNotesNationalLanguage(String notesNationalLanguage) {
        this.notesNationalLanguage = notesNationalLanguage;
        return this;
    }

    @JsonProperty("number")
    public String getNumber() {
        return number;
    }

    @JsonProperty("number")
    public void setNumber(String number) {
        this.number = number;
    }

    public Document withNumber(String number) {
        this.number = number;
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

    public Document withPlaceOfIssue(String placeOfIssue) {
        this.placeOfIssue = placeOfIssue;
        return this;
    }

    @JsonProperty("placeOfIssueNationalLanguage")
    public String getPlaceOfIssueNationalLanguage() {
        return placeOfIssueNationalLanguage;
    }

    @JsonProperty("placeOfIssueNationalLanguage")
    public void setPlaceOfIssueNationalLanguage(String placeOfIssueNationalLanguage) {
        this.placeOfIssueNationalLanguage = placeOfIssueNationalLanguage;
    }

    public Document withPlaceOfIssueNationalLanguage(String placeOfIssueNationalLanguage) {
        this.placeOfIssueNationalLanguage = placeOfIssueNationalLanguage;
        return this;
    }

    @JsonProperty("portraitVsPrimarySelfieSimilarityScore")
    public String getPortraitVsPrimarySelfieSimilarityScore() {
        return portraitVsPrimarySelfieSimilarityScore;
    }

    @JsonProperty("portraitVsPrimarySelfieSimilarityScore")
    public void setPortraitVsPrimarySelfieSimilarityScore(String portraitVsPrimarySelfieSimilarityScore) {
        this.portraitVsPrimarySelfieSimilarityScore = portraitVsPrimarySelfieSimilarityScore;
    }

    public Document withPortraitVsPrimarySelfieSimilarityScore(String portraitVsPrimarySelfieSimilarityScore) {
        this.portraitVsPrimarySelfieSimilarityScore = portraitVsPrimarySelfieSimilarityScore;
        return this;
    }

    @JsonProperty("primary")
    public String getPrimary() {
        return primary;
    }

    @JsonProperty("primary")
    public void setPrimary(String primary) {
        this.primary = primary;
    }

    public Document withPrimary(String primary) {
        this.primary = primary;
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

    public Document withRemarks(String remarks) {
        this.remarks = remarks;
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

    public Document withRestrictions(String restrictions) {
        this.restrictions = restrictions;
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

    public Document withSection(String section) {
        this.section = section;
        return this;
    }

    @JsonProperty("travelDocumentType")
    public String getTravelDocumentType() {
        return travelDocumentType;
    }

    @JsonProperty("travelDocumentType")
    public void setTravelDocumentType(String travelDocumentType) {
        this.travelDocumentType = travelDocumentType;
    }

    public Document withTravelDocumentType(String travelDocumentType) {
        this.travelDocumentType = travelDocumentType;
        return this;
    }

    @JsonProperty("trustFactors")
    public List<TrustFactor> getTrustFactors() {
        return trustFactors;
    }

    @JsonProperty("trustFactors")
    public void setTrustFactors(List<TrustFactor> trustFactors) {
        this.trustFactors = trustFactors;
    }

    public Document withTrustFactors(List<TrustFactor> trustFactors) {
        this.trustFactors = trustFactors;
        return this;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Document withType(String type) {
        this.type = type;
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

    public Document withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
