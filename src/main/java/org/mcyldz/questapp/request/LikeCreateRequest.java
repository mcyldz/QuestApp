package org.mcyldz.questapp.request;

import lombok.Data;

@Data
public class LikeCreateRequest {

    private Integer userId;
    private Integer postId;
}
