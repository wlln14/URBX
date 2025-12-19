package com.URBX.URBX.Repository;

import com.URBX.URBX.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,  Long> {
}
