package org.mcyldz.questapp.controller;

import org.mcyldz.questapp.model.Like;
import org.mcyldz.questapp.request.LikeCreateRequest;
import org.mcyldz.questapp.response.LikeResponse;
import org.mcyldz.questapp.service.LikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/api/likes")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService){
        this.likeService = likeService;
    }
    @GetMapping
    public List<LikeResponse> getAllLikes(@RequestParam Optional<Integer> userId, @RequestParam Optional<Integer> postId){
        return likeService.getAllLikesWithParam(userId, postId);
    }
    @PostMapping
    public Like createOneLike(@RequestBody LikeCreateRequest likeCreateRequest){
        return likeService.createOneLike(likeCreateRequest);
    }

    @DeleteMapping("/{likeId}")
    public void deleteOneLike(@PathVariable Integer likeId){
        likeService.deleteOneLikeById(likeId);
    }


}
