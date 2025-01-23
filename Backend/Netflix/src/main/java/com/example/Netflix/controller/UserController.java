package com.example.Netflix.controller;

        import com.example.Netflix.model.User;
        import com.example.Netflix.service.UserService;
        import com.example.Netflix.service.impl.UserServiceImpl;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;
        import java.util.List;
@RestController//convert json format
@RequestMapping("/api/User")//map http requset
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService UserService;
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User User){
        return new
                ResponseEntity<User>(UserService.saveUser(User),
                HttpStatus.CREATED);
    }
    //GetAll Rest Api
    @GetMapping
    public List<User> getAllUser(){
        return UserService.getAllUser();
    }

    @GetMapping("{id}")
// localhost:8080/api/User/1
    public ResponseEntity<User> getUserById(@PathVariable("id") long
                                                            UserID){
        return new
                ResponseEntity<User>(UserService.getUserById(UserID),HttpStatus.OK);
    }
    //Update Rest Api@PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User User){
        return new
                ResponseEntity<User>(UserService.updateUser(User,id),HttpStatus.OK);
    }
    //Delete Rest Api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id){
//delete User from db
        UserService.deleteUser(id);
        return new ResponseEntity<String>("User deleted Successfully.",HttpStatus.OK);
    }

    // User login
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User loginUser) {
        User User = UserService.getUserByEmail(loginUser.getEmail());
        if (User != null && User.getPassword().equals(loginUser.getPassword())) {
            // Handle successful login (e.g., generate a token or set session data)
            return new ResponseEntity<>("Login successful!", HttpStatus.OK);
        } else {
            // Handle login failure
            return new ResponseEntity<>("Invalid email or password.", HttpStatus.UNAUTHORIZED);
        }
    }
}

