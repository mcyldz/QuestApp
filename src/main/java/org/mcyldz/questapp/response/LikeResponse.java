package org.mcyldz.questapp.response;

import lombok.Data;
import org.mcyldz.questapp.model.Like;

@Data
public class LikeResponse {

    private Integer id;
    private Integer userId;
    private Integer postId;

    public LikeResponse(Like entity){
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.postId = entity.getPost().getId();
    }
}
