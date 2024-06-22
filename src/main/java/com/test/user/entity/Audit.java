package com.test.user.entity;

import java.time.Instant;

public abstract class Audit {
    private Instant createdAt;
    private Instant updatedAt;
    private String createdBy;
    private String updatedBy;
}
