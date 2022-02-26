package com.case3bugrayus.controller;

import com.case3bugrayus.model.request.CreateCommentRequestModel;
import com.case3bugrayus.model.response.GetCommentsByProductResponseModel;
import com.case3bugrayus.model.response.GetCommentsByUserResponseModel;
import com.case3bugrayus.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/comments/{id}/user")
    public List<GetCommentsByUserResponseModel> getCommentsByUser(@PathVariable long id) {
        return commentService.getCommentsByUser(id);
    }

    @GetMapping("/comments/{id}/product")
    public List<GetCommentsByProductResponseModel> getCommentsByProduct(@PathVariable long id) {
        return commentService.getCommentsByProduct(id);
    }

    @PostMapping("/comment")
    public boolean createComment(@RequestBody CreateCommentRequestModel requestModel) {
        return commentService.createComment(requestModel);
    }

    @DeleteMapping("/comment/{id}")
    public boolean createComment(@PathVariable long id) {
        return commentService.deleteComment(id);
    }
}
