package org.example.springmongodb.services;

import org.example.springmongodb.domain.Post;
import org.example.springmongodb.domain.User;
import org.example.springmongodb.dto.UserDTO;
import org.example.springmongodb.repository.PostRepository;
import org.example.springmongodb.repository.UserRepository;
import org.example.springmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public List<Post> findAll(){
        return repo.findAll();
    }

    public Post findById(String id){
        Optional<Post> user = repo.findById(id);

        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto nâo encontrado"));
    }
}
