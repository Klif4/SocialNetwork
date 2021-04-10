package domain;

import static org.mockito.BDDMockito.then;

import domain.ports.repositories.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserTest {

  @Mock
  PostRepository postRepository;
  private User alice;

  @BeforeEach
  void setUp() {
    alice = new User(new Name("Alice"), postRepository);
  }

  @Test
  void post_should_publish_a_post() {
    Message message = new Message("What a wonderfully sunny day!");
    alice.post(message);
    Post post = new Post(message, alice);
    then(postRepository).should().publish(post);
  }
}