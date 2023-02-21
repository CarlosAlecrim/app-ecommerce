package br.dio.inter.appecommerce.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.dio.inter.appecommerce.model.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

	List<Produto> findByNomeContainingIgnoreCase(String nome);

}
