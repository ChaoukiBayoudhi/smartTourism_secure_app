package tn.sesame.smartTourism.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.sesame.smartTourism.Repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


}
