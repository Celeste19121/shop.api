package com.methaporce.shop.app.repositorys;

import com.methaporce.shop.app.entities.Reseña;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReseñaRepository extends JpaRepository<Reseña, Long> {
}
