package tn.sesame.smartTourism.dto;

import lombok.NonNull;

public record LoginRequest(@NonNull String email, @NonNull String password) {
}
