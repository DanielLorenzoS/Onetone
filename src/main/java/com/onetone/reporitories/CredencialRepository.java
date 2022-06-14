package com.onetone.reporitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onetone.entities.Credencial;

@Repository
public interface CredencialRepository extends JpaRepository<Credencial, Long>{

}
