package com.roger.kmsconsumer.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<WikimediaRecord, Long> {
}
