package uz.isystem.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        user.setCreatedAt(LocalDateTime.now());
        user.setStatus(true);
        user.setUserType(UserType.VISITOR);
        userRepository.save(user);
        return user;
    }

    public User get(Integer id) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isEmpty()){
            throw new BadRequest("User not found");
        }
        return optional.get();
    }


    public User update(Integer id, User user) {
        User oldUser = get(id);
        oldUser.setFirstname(user.getFirstname());
        oldUser.setLastname(user.getLastname());
        oldUser.setAvatar(user.getAvatar());
        oldUser.setAddress(user.getAddress());
        oldUser.setAddress2(user.getAddress2());
        oldUser.setCityId(user.getCityId());
        oldUser.setUpdatedAt(LocalDateTime.now());
        userRepository.save(oldUser);
        return oldUser;
    }

    public String delete(Integer id) {
        User user = get(id);
        userRepository.delete(user);
        return "User deleted";
    }
}
