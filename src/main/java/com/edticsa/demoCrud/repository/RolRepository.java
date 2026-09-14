package com.edticsa.demoCrud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edticsa.demoCrud.models.Rol;

public interface RolRepository  extends JpaRepository<Rol, Long>  {
    Optional<Rol> findByNombre(String nombre);

}
