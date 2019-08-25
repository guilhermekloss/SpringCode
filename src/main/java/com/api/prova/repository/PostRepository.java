package com.api.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.prova.model.PostTexto;

public interface PostRepository extends JpaRepository<PostTexto, Long>{
	PostTexto findById(long id);
}
