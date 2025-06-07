package org.techdisqus.db.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.techdisqus.db.model.ApplicantDocument;

public interface ApplicantDocumentRepository extends JpaRepository<ApplicantDocument, Integer> {
    // Add custom queries if needed
}

