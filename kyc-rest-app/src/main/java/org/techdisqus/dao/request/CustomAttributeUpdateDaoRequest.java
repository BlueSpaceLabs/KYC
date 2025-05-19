
package org.techdisqus.dao.request;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.techdisqus.dao.response.custom.attributes.*;

import javax.annotation.Generated;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "attachments",
    "customDetails",
    "documents",
    "enrolledAt",
    "enrolledBy",
    "enrollmentDevice",
    "exportedAt",
    "exportedBy",
    "externalId",
    "gallery",
    "identifyCandidates",
    "livenessPhotos",
    "selfies",
    "status",
    "trustFactors"
})
@Generated("jsonschema2pojo")
public class CustomAttributeUpdateDaoRequest {

    @JsonProperty("attachments")
    private List<Attachment> attachments;
    @JsonProperty("customDetails")
    private CustomDetails customDetails;
    @JsonProperty("documents")
    private List<Document> documents;
    @JsonProperty("enrolledAt")
    private String enrolledAt;
    @JsonProperty("enrolledBy")
    private String enrolledBy;
    @JsonProperty("enrollmentDevice")
    private String enrollmentDevice;
    @JsonProperty("exportedAt")
    private String exportedAt;
    @JsonProperty("exportedBy")
    private String exportedBy;
    @JsonProperty("externalId")
    private String externalId;
    @JsonProperty("gallery")
    private String gallery;
    @JsonProperty("identifyCandidates")
    private List<IdentifyCandidate> identifyCandidates;
    @JsonProperty("livenessPhotos")
    private List<LivenessPhoto> livenessPhotos;
    @JsonProperty("selfies")
    private List<Selfy> selfies;
    @JsonProperty("status")
    private String status;
    @JsonProperty("trustFactors")
    private List<TrustFactor> trustFactors;
    @JsonProperty("attachments")
    public List<Attachment> getAttachments() {
        return attachments;
    }

    @JsonProperty("attachments")
    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public CustomAttributeUpdateDaoRequest withAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
        return this;
    }

    @JsonProperty("customDetails")
    public CustomDetails getCustomDetails() {
        return customDetails;
    }

    @JsonProperty("customDetails")
    public void setCustomDetails(CustomDetails customDetails) {
        this.customDetails = customDetails;
    }

    public CustomAttributeUpdateDaoRequest withCustomDetails(CustomDetails customDetails) {
        this.customDetails = customDetails;
        return this;
    }

    @JsonProperty("documents")
    public List<Document> getDocuments() {
        return documents;
    }

    @JsonProperty("documents")
    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public CustomAttributeUpdateDaoRequest withDocuments(List<Document> documents) {
        this.documents = documents;
        return this;
    }

    @JsonProperty("enrolledAt")
    public String getEnrolledAt() {
        return enrolledAt;
    }

    @JsonProperty("enrolledAt")
    public void setEnrolledAt(String enrolledAt) {
        this.enrolledAt = enrolledAt;
    }

    public CustomAttributeUpdateDaoRequest withEnrolledAt(String enrolledAt) {
        this.enrolledAt = enrolledAt;
        return this;
    }

    @JsonProperty("enrolledBy")
    public String getEnrolledBy() {
        return enrolledBy;
    }

    @JsonProperty("enrolledBy")
    public void setEnrolledBy(String enrolledBy) {
        this.enrolledBy = enrolledBy;
    }

    public CustomAttributeUpdateDaoRequest withEnrolledBy(String enrolledBy) {
        this.enrolledBy = enrolledBy;
        return this;
    }

    @JsonProperty("enrollmentDevice")
    public String getEnrollmentDevice() {
        return enrollmentDevice;
    }

    @JsonProperty("enrollmentDevice")
    public void setEnrollmentDevice(String enrollmentDevice) {
        this.enrollmentDevice = enrollmentDevice;
    }

    public CustomAttributeUpdateDaoRequest withEnrollmentDevice(String enrollmentDevice) {
        this.enrollmentDevice = enrollmentDevice;
        return this;
    }

    @JsonProperty("exportedAt")
    public String getExportedAt() {
        return exportedAt;
    }

    @JsonProperty("exportedAt")
    public void setExportedAt(String exportedAt) {
        this.exportedAt = exportedAt;
    }

    public CustomAttributeUpdateDaoRequest withExportedAt(String exportedAt) {
        this.exportedAt = exportedAt;
        return this;
    }

    @JsonProperty("exportedBy")
    public String getExportedBy() {
        return exportedBy;
    }

    @JsonProperty("exportedBy")
    public void setExportedBy(String exportedBy) {
        this.exportedBy = exportedBy;
    }

    public CustomAttributeUpdateDaoRequest withExportedBy(String exportedBy) {
        this.exportedBy = exportedBy;
        return this;
    }

    @JsonProperty("externalId")
    public String getExternalId() {
        return externalId;
    }

    @JsonProperty("externalId")
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public CustomAttributeUpdateDaoRequest withExternalId(String externalId) {
        this.externalId = externalId;
        return this;
    }

    @JsonProperty("gallery")
    public String getGallery() {
        return gallery;
    }

    @JsonProperty("gallery")
    public void setGallery(String gallery) {
        this.gallery = gallery;
    }

    public CustomAttributeUpdateDaoRequest withGallery(String gallery) {
        this.gallery = gallery;
        return this;
    }

    @JsonProperty("identifyCandidates")
    public List<IdentifyCandidate> getIdentifyCandidates() {
        return identifyCandidates;
    }

    @JsonProperty("identifyCandidates")
    public void setIdentifyCandidates(List<IdentifyCandidate> identifyCandidates) {
        this.identifyCandidates = identifyCandidates;
    }

    public CustomAttributeUpdateDaoRequest withIdentifyCandidates(List<IdentifyCandidate> identifyCandidates) {
        this.identifyCandidates = identifyCandidates;
        return this;
    }

    @JsonProperty("livenessPhotos")
    public List<LivenessPhoto> getLivenessPhotos() {
        return livenessPhotos;
    }

    @JsonProperty("livenessPhotos")
    public void setLivenessPhotos(List<LivenessPhoto> livenessPhotos) {
        this.livenessPhotos = livenessPhotos;
    }

    public CustomAttributeUpdateDaoRequest withLivenessPhotos(List<LivenessPhoto> livenessPhotos) {
        this.livenessPhotos = livenessPhotos;
        return this;
    }

    @JsonProperty("selfies")
    public List<Selfy> getSelfies() {
        return selfies;
    }

    @JsonProperty("selfies")
    public void setSelfies(List<Selfy> selfies) {
        this.selfies = selfies;
    }

    public CustomAttributeUpdateDaoRequest withSelfies(List<Selfy> selfies) {
        this.selfies = selfies;
        return this;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    public CustomAttributeUpdateDaoRequest withStatus(String status) {
        this.status = status;
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

    public CustomAttributeUpdateDaoRequest withTrustFactors(List<TrustFactor> trustFactors) {
        this.trustFactors = trustFactors;
        return this;
    }

}
