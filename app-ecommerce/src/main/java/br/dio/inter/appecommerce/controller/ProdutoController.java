package br.dio.inter.appecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.dio.inter.appecommerce.model.Produto;
import br.dio.inter.appecommerce.repository.ProdutoRepository;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping(name = "/")
	public List<Produto> todosProduto() {
		
		List<Produto> produtos =  (List<Produto>) produtoRepository.findAll();
		
		return produtos;
	}
	
	@PostMapping
	public Produto salvar(@RequestBody Produto produto) {

		return produtoRepository.save(produto);
		
	}
	
	@GetMapping(value="{id}")
	public Optional<Produto> buscarProduto(@PathVariable("id") Long id) {
		
		Optional<Produto> produto = produtoRepository.findById(id);
		
		return produto;
	}
	
	@DeleteMapping
	public  ResponseEntity<Void> deletarProduto(@RequestBody Produto prod) {
		
		Optional<Produto> produto = produtoRepository.findById(prod.getId());
		
		if(produto.isPresent()) {
			produtoRepository.deleteById(prod.getId());
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PutMapping
	public ResponseEntity<Void> editarProduto(@RequestBody Produto prod){
		
		Optional<Produto> produto = produtoRepository.findById(prod.getId());
		
		if(produto.isPresent()) {
			produtoRepository.save(prod);
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/nome/{nome}")
	public List<Produto> buscarPorNome(@PathVariable("nome") String nome){
		
		List<Produto> produtos = produtoRepository.findByNomeContainingIgnoreCase(nome);
		
		return produtos;
	}
	
	
	
	

}
