package domain;

import domain.ports.repositories.PostRepository;

public class User {

  private final PostRepository postRepository;

  public User(Name name, PostRepository postRepository) {

    this.postRepository = postRepository;
  }

  public void post(Message message) {
    postRepository.publish(new Post(message, this));
  }
}
