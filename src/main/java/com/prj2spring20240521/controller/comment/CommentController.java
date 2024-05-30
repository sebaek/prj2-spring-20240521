package com.prj2spring20240521.controller.comment;

import com.prj2spring20240521.domain.comment.Comment;
import com.prj2spring20240521.service.comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {
    final CommentService service;

    @PostMapping("add")
    @PreAuthorize("isAuthenticated()")
    public void addComment(@RequestBody Comment comment,
                           Authentication authentication) {
        service.add(comment, authentication);
    }
}
