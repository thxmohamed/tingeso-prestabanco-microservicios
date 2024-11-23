package com.tutorial.documentservice.repository;



import com.tutorial.documentservice.entity.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<DocumentEntity, Long> {
    public List<DocumentEntity> findByCreditID(Long id);

    public DocumentEntity findByFileData(byte[] filedata);

    public void deleteAllByCreditID(Long id);
}

