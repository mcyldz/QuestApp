package org.mcyldz.questapp.response;

import lombok.Data;
import org.mcyldz.questapp.model.Comment;

@Data
public class CommentResponse {

    Integer id;
    Integer userId;
    String userName;
    String text;

    public CommentResponse(Comment entity){
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.userName = entity.getUser().getUserName();
        this.text = entity.getText();
    }
}
