package tn.sesame.smartTourism.dto;

public record RegisterRequest(String email, String password, String firstName, String lastName, String phone) {
}
