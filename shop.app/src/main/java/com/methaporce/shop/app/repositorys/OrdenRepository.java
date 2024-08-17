package com.methaporce.shop.app.repositorys;

import com.methaporce.shop.app.entities.Orden;
import com.methaporce.shop.app.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrdenRepository extends JpaRepository<Orden, Integer> {
    List<Orden> findByUsuario (Usuario usuario);

}
