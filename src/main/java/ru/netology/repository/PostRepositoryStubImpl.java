package ru.netology.repository;

import org.springframework.stereotype.Repository;
import ru.netology.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PostRepositoryStubImpl implements PostRepository {
    private List<Post> posts = new ArrayList<>();
    private AtomicLong count = new AtomicLong(0);

    public List<Post> all() {
        return posts;
    }

    public Optional<Post> getById(long id) {
        for (Post element : posts) {
            if (element.getId() == id) {
                return Optional.of(element);
            }
        }
        return Optional.empty();
    }

    public Post save(Post post) {
        if (post.getId() != 0) {
            for (Post element : posts) {
                if (element.getId() == post.getId()) {
                    return post;
                }
            }
        }
        long id = count.incrementAndGet();
        post.setId(id);
        posts.add(post);
        return post;
    }

    public void removeById(long id) {
        for (Post element : posts) {
            if (element.getId() == id) {
                posts.remove(element);
                break;
            }
        }
    }
}
