package com.onetone.reporitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onetone.entities.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long>{

}
