package com.test.user.dto.response;

import com.test.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
public class UserResponse {
    private UUID id;
    private String userName;
    private String fullName;
    private String phoneNumber;
    private Instant createdAt;
    private Instant updatedAt;

    public UserResponse(User user) {
        if (user != null) {
            this.id = user.getId();
            this.userName = user.getUserName();
            this.fullName = user.getFullName();
            this.phoneNumber = user.getPhoneNumber();
            this.createdAt = user.getCreatedAt();
            this.updatedAt = user.getUpdatedAt();
        }
    }
}
