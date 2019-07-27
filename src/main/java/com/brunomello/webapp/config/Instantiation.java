package com.brunomello.webapp.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.brunomello.webapp.domain.Post;
import com.brunomello.webapp.domain.User;
import com.brunomello.webapp.dto.AuthorDTO;
import com.brunomello.webapp.dto.CommentDTO;
import com.brunomello.webapp.repository.PostRepository;
import com.brunomello.webapp.repository.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private PostRepository postRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown","maria@gmail.com");
		User alex = new User(null, "Alex Green","alex@gmail.com");
		User bob = new User(null, "Bob Grey","bob@gmail.com");
		
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Hello World", "Teste de publicação", new AuthorDTO (maria));
		
		CommentDTO c1 = new CommentDTO("Testando comentario", sdf.parse("21/03/2019"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Testando comentario2", sdf.parse("30/04/2019"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Testando comentario3", sdf.parse("06/06/2019"), new AuthorDTO(maria));
		
		post1.getComments().addAll(Arrays.asList(c1, c2, c3));
		
		postRepository.saveAll(Arrays.asList(post1));
		
		maria.getPosts().addAll(Arrays.asList(post1));
		userRepository.save(maria);
		
	}

}
