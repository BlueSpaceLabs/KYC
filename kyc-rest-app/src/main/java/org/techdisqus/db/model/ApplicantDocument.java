package org.techdisqus.db.model;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Table(name = "applicant_documents", schema = "public")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String type;

    @Column(name = "support_level")
    private String supportLevel;

    private String country;
    private String edition;

    @Column(name = "machine_readable_travel_document")
    private Boolean machineReadableTravelDocument;

    private Integer age;
    private String gender;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "document_number")
    private String documentNumber;

    @Column(name = "date_of_expiry")
    private LocalDate dateOfExpiry;

    @Column(name = "issuing_authority")
    private String issuingAuthority;

    @Column(name = "nationality")
    private String nationality;

    @Type(JsonType.class)
    @Column(name = "additional_data", columnDefinition = "jsonb")
    private Map<String, Object> additionalData;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;


    // Getters and setters omitted for brevity
}
