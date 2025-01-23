package com.example.Netflix.service.impl;
        import com.example.Netflix.model.User;
        import com.example.Netflix.repository.UserRepository;
        import com.example.Netflix.service.UserService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import java.util.List;
        import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository UserRepository;
    //save User in database
    @Override
    public User saveUser(User User){
        return UserRepository.save(User);
    }
    //get all users form database
    @Override
    public List<User> getAllUser() {
        return UserRepository.findAll();
    }
    //get user using id
    @Override
    public User getUserById(long id) {
        Optional<User> User = UserRepository.findById(id);
        if(User.isPresent()){
            return User.get();
        }else {
            throw new RuntimeException();
        }
    }
    //update employee
    @Override
    public User updateUser(User User, long id) {
        User existingUser =
                UserRepository.findById(id).orElseThrow(
                        ()-> new RuntimeException()
                );
        existingUser.setFirstName(User.getFirstName());
        existingUser.setLastName(User.getLastName());
        existingUser.setEmail(User.getEmail());
        existingUser.setPassword(User.getPassword());
// save
        UserRepository.save(existingUser);
        return existingUser;
    }//delete User
    @Override
    public void deleteUser(long id) {
//check
        UserRepository.findById(id).orElseThrow(()-> new
                RuntimeException());
//delete
        UserRepository.deleteById(id);
    }

    public User getUserByEmail(String email) {
        Optional<User> User = UserRepository.findByEmail(email);
        if(User.isPresent()){
            return User.get();
        }else {
            throw new RuntimeException();
        } // Or handle user not found case
    }

}