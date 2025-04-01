package com.example.pironeer4.service;

import com.example.pironeer4.dto.request.PostCreateReq;
import com.example.pironeer4.dto.request.PostUpdateReq;
import com.example.pironeer4.dto.response.CommentRes;
import com.example.pironeer4.dto.response.PostDetailRes;
import com.example.pironeer4.dto.response.PostSearchRes;
import com.example.pironeer4.entity.Post;
import com.example.pironeer4.entity.PostStatus;
import com.example.pironeer4.entity.User;
import com.example.pironeer4.repository.CommentRepository;
import com.example.pironeer4.repository.PostRepository;
import com.example.pironeer4.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    public Long create(PostCreateReq req) {
        User user = userRepository.findById(req.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("조회된 유저가 없습니다."));

        Post post = Post.create(user, req.getTitle(), req.getContent(), req.getStatus());
        post = postRepository.save(post);

        return post.getId();
    }

    public List<PostSearchRes> search() {
        // PostStatus가 public인 게시글만 조회할 수 있다.
        List<Post> posts = postRepository.findAllByStatus(PostStatus.PUBLIC); // DB에서 Post 엔티티 리스트를 받아왔어 (List<Post>) -> 근데 클라이언트에 그대로 넘기면 안 돼 → **DTO(PostSearchRes)**로 변환 필요
        return posts.stream() // 리스트 가공(map)
                .map(post ->  // map = 각 요소를 변환(transform)하는 함수! , Post → PostSearchRes로 바꾸고 있어
                        new PostSearchRes(post.getUser().getId(), post.getId(), post.getTitle(),
                                post.getContent(), post.getCreatedAt())
                )
                .toList();  // 변환된 결과들을 다시 List로 수집
    }

    // 단일 포스트
    public PostDetailRes detail(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("조회된 게시글이 없습니다."));

        // 댓글 리스트 조회
        List<CommentRes> comments = commentRepository.findAllByPost(post).stream()
                .map(c -> new CommentRes(
                        c.getId(),
                        c.getUser().getId(),
                        c.getPost().getId(),
                        c.getContent(),
                        c.getCreatedAt()
                ))
                .toList();

        return new PostDetailRes(
                post.getId(),
                post.getUser().getId(),
                post.getTitle(),
                post.getContent(),
                post.getCreatedAt(),
                comments // 👈 같이 넣어준다!
        );
    }

    public Long update(Long postId, PostUpdateReq req) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("조회된 게시글이 없습니다."));

        post.update(req.getTitle(), req.getContent(), req.getStatus());
        postRepository.save(post);

        return post.getId();
    }

    public Long delete(Long postId) {
        postRepository.deleteById(postId);
        return postId;
    }
}