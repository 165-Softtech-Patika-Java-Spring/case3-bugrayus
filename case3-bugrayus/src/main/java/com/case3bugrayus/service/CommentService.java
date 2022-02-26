package com.case3bugrayus.service;

import com.case3bugrayus.model.Comment;
import com.case3bugrayus.model.request.CreateCommentRequestModel;
import com.case3bugrayus.model.response.GetCommentsByProductResponseModel;
import com.case3bugrayus.model.response.GetCommentsByUserResponseModel;
import com.case3bugrayus.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ModelMapper mapper;

    public List<GetCommentsByUserResponseModel> getCommentsByUser(long userId) {
        List<Comment> comments = commentRepository.getAllByUserId(userId);
        if (comments.size() == 0)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, userId + " Id username does not have any comments");

        return comments
                .stream()
                .map(comment -> mapper.map(comment, GetCommentsByUserResponseModel.class))
                .collect(Collectors.toList());
    }

    public List<GetCommentsByProductResponseModel> getCommentsByProduct(long productId) {
        List<Comment> comments = commentRepository.getAllByProductId(productId);
        if (comments.size() == 0)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, productId + " Id product does not have any comments");

        return comments
                .stream()
                .map(comment -> mapper.map(comment, GetCommentsByProductResponseModel.class))
                .collect(Collectors.toList());
    }

    public boolean createComment(CreateCommentRequestModel requestModel) {
        mapper.getConfiguration().setAmbiguityIgnored(true);
        commentRepository.save(mapper.map(requestModel, Comment.class));
        return true;
    }

    public boolean deleteComment(long id) {
        if (!commentRepository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found by that id");
        commentRepository.deleteById(id);
        return true;
    }
}
