package org.mcyldz.questapp.response;

import lombok.Data;
import org.mcyldz.questapp.model.User;

@Data
public class UserResponse {

    private Integer id;
    private int avatarId;
    String userName;

    public UserResponse(User entity) {
        this.id = entity.getId();
        this.avatarId = entity.getAvatar();
        this.userName = entity.getUserName();
    }
}
