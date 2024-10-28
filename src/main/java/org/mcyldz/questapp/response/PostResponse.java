package org.mcyldz.questapp.response;

import lombok.Data;
import org.mcyldz.questapp.model.Post;

import java.util.List;

@Data
public class PostResponse {

    private Integer id;
    private Integer userId;
    private String userName;
    private String title;
    private String text;
    private List<LikeResponse> postLikes;

    public PostResponse(Post entity, List<LikeResponse> likes){
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.userName = entity.getUser().getUserName();
        this.title = entity.getTitle();
        this.text = entity.getText();
        this.postLikes = likes;
    }
}
