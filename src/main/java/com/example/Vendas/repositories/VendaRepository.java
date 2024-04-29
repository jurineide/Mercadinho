package com.example.Vendas.repositories;

import com.example.Vendas.models.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VendaRepository extends JpaRepository<Venda,Long> {
}
