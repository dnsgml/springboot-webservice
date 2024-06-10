package com.dnsgml.service.posts;

import com.dnsgml.domain.posts.Posts;
import com.dnsgml.domain.posts.PostsRepository;
import com.dnsgml.web.dto.PostsResponseDto;
import com.dnsgml.web.dto.PostsSaveRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto postsSaveRequestDto) {
        return postsRepository.save(postsSaveRequestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsSaveRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new
                IllegalArgumentException("해당 사용자가 없습니다. id="+ id));
        posts.update(requestDto.getTitle(), requestDto.getContent(), requestDto.getAuthor());

        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new
                IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        return new PostsResponseDto(entity);
    }
}
