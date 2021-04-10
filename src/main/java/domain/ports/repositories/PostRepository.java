package domain.ports.repositories;

import domain.Post;

public interface PostRepository {
  void publish(Post post);
}
