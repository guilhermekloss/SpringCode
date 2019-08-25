package com.api.prova.resources;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.prova.exception.IdNotFoundException;
import com.api.prova.model.PostTexto;
import com.api.prova.repository.PostRepository;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST de post de prdutos")
public class PostResources {
	
	@Autowired
	PostRepository postRepository;
	
	@ApiOperation(value="Retorna uma lista de Posts")
	@GetMapping("/textos")
	public List<PostTexto> listaTextos(){
		return postRepository.findAll();
	}
	
	@ApiOperation(value="Retorna um post a partir do id")
	@GetMapping("/textos/{id}")
	public PostTexto listaProdutoUnico(@PathVariable(value="id") long id){
		return postRepository.findById(id);
	}

	@ApiOperation(value="Salva um novo post")
	@PostMapping("/textos")
	public PostTexto salvaTexto(@RequestBody @Valid PostTexto texto) {
		return postRepository.save(texto);
	}
	@ApiOperation(value="Salva um novo upvote de um post especifico")
	@PostMapping("/textos/{postId}/upvote")
	public PostTexto salvaUpvote(@PathVariable (value = "postId") long postId, @RequestBody @Valid PostTexto upvotes) throws IdNotFoundException {
		PostTexto post = postRepository.findById(postId);
		long value = post.getUpvotes();
		post.setUpvotes(value + 1);
		return postRepository.save(post);
	}


}
