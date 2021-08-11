package com.shaja.springjwt.bezkoderbackend.services.interfaces;

import com.shaja.springjwt.bezkoderbackend.models.User;

import java.util.Optional;

public interface IAdminService {
    User createUser(User user);

    Optional<User> findByUsernameOREmail(String userNameorEmail);

//    TODO: DELETE USER
//    TODO: BLOCK USER
//    TODO: SAVEALL USERS
//    TODO: CHANGE PASSWORD
//    TODO: FORGT USERNAME OR PASSWORD



}
