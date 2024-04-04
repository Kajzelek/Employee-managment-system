package com.JavaExampleProjects.emsbackend.Repository;

import com.JavaExampleProjects.emsbackend.Entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
}
