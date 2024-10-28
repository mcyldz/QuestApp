package org.mcyldz.questapp.service;

import org.mcyldz.questapp.model.Comment;
import org.mcyldz.questapp.model.Post;
import org.mcyldz.questapp.model.User;
import org.mcyldz.questapp.repository.CommentRepository;
import org.mcyldz.questapp.request.CommentCreateRequest;
import org.mcyldz.questapp.request.CommentUpdateRequest;
import org.mcyldz.questapp.response.CommentResponse;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserService userService;
    private final PostService postService;

    public CommentService(CommentRepository commentRepository, UserService userService, PostService postService){
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.postService = postService;
    }

    public List<CommentResponse> getAllCommentsWithParam(Optional<Integer> userId, Optional<Integer> postId) {

        List<Comment> comments;

        if (userId.isPresent() && postId.isPresent()){
            comments = commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
        }
        else if(userId.isPresent()){
            comments = commentRepository.findByUserId(userId.get());
        }
        else if(postId.isPresent()){
            comments = commentRepository.findByPostId(postId.get());
        }
        else {
            comments = commentRepository.findAll();
        }

        return comments.stream().map(comment -> new CommentResponse(comment)).collect(Collectors.toList());
    }

    public Comment getOneCommentById(Integer commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment createOneComment(CommentCreateRequest commentCreateRequest) {

        User user = userService.getOneUserById(commentCreateRequest.getUserId());
        Post post = postService.getOnePostById(commentCreateRequest.getPostId());

        if (user != null && post != null){

            Comment toSaveComment = new Comment();
            toSaveComment.setText(commentCreateRequest.getText());
            toSaveComment.setPost(post);
            toSaveComment.setUser(user);
            toSaveComment.setCreateDate(new Date());

            return commentRepository.save(toSaveComment);
        }
        else
            return null;
    }

    public Comment updateOneComment(Integer commentId, CommentUpdateRequest commentUpdateRequest) {

        Optional<Comment> comment = commentRepository.findById(commentId);

        if (comment.isPresent()){

            Comment toUpdateComment = comment.get();

            toUpdateComment.setText(commentUpdateRequest.getText());

            return commentRepository.save(toUpdateComment);
        }

        else return null;
    }

    public void deleteOneCommentById(Integer commentId) {
        commentRepository.deleteById(commentId);
    }

}
