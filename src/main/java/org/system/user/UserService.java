package org.system.user;

import org.springframework.stereotype.Service;
import org.system.user.dtos.UserDto;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto getUserInfo(String name) {
        return userRepository.getUserInfoByLogin(name);
    }
}
