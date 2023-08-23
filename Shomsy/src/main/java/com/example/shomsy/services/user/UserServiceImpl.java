package com.example.shomsy.services.user;

        import com.example.shomsy.dtos.UserDTO;
        import com.example.shomsy.entities.User;
        import com.example.shomsy.repositories.UserRepository;
        import com.example.shomsy.util.Helper;
        import lombok.AllArgsConstructor;
        import org.springframework.cache.annotation.CacheEvict;
        import org.springframework.cache.annotation.Cacheable;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.domain.Sort;
        import org.springframework.security.crypto.password.PasswordEncoder;
        import org.springframework.stereotype.Service;


        import java.util.List;
        import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository repositoryUser;
    private final Helper helper;
    


    /*
     * with SecurityConfig we can use passwordEncoder
     * */
    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    @CacheEvict(value="user",allEntries = true)
    public void saveUser(List<UserDTO> dtos) {
        for (UserDTO dto:dtos){

            User user = new User();
            user.setFirstName(dto.getFirstName());
            user.setLastName(dto.getLastName());
            user.setAge(dto.getAge());
            user.setEmail(dto.getEmail());
            user.setUserRole(dto.getUserRole());
            String encodedPassword = this.passwordEncoder.encode(dto.getPassword());
            user.setPassword(encodedPassword);

            repositoryUser.save(user);
        }
        System.out.println(helper.addSuccess()+repositoryUser.count()+" user");
    }
    @Override
    @CacheEvict(value="user",allEntries = true)
    public void updateUser(List<UserDTO> dtos) {
        for (UserDTO dto : dtos) {
            Optional<User> optionalUser = repositoryUser.findById(dto.getId());
            if (optionalUser.isPresent()) {
                User userToUpdate = optionalUser.get();
                userToUpdate.setFirstName(dto.getFirstName());
                userToUpdate.setLastName(dto.getLastName());
                userToUpdate.setAge(dto.getAge());
                userToUpdate.setEmail(dto.getEmail());

                String encodedPassword = this.passwordEncoder.encode(dto.getPassword());
                userToUpdate.setPassword(encodedPassword);

                repositoryUser.save(userToUpdate);
                System.out.println(helper.updateSuccess() + "id: " + dto.getId());
            } else {
                System.out.println("not found person. id:" + dto.getId());
            }
        }
    }


    @Override
    @CacheEvict(value="user",allEntries = true)
    public void deleteUser(List<UserDTO> dtos) {
        for (UserDTO dto : dtos) {
            //System.out.println(helper.deleteSuccess()+"Name: "+dto.getName()+"    Age: "+dto.getAge());

            Optional<User> optionalUser = repositoryUser.findById(dto.getId());

            if (optionalUser.isPresent()) {
                System.out.println("name: "+optionalUser.get().getFirstName()+" "+optionalUser.get().getLastName());
                User userToDelete = optionalUser.get();
                repositoryUser.delete(userToDelete);
            } else {
                System.out.println("not found person. id:" + dto.getId());
            }
        }
    }
    @Override
    @Cacheable("user")
    public Long countUsers() {
        return repositoryUser.count();
    }
    @Override
    @Cacheable("user")
    public List<User> getAllUsers() {
        return repositoryUser.findAll();
    }

    public void deleteAllUsers() {repositoryUser.deleteAll();}

    @Override
    @Cacheable("user")
    public User getOneUser(Long sid) {
        //return repository.getReferenceById(id);
        try{
            return repositoryUser.findById(sid).get();
        }catch (Exception e){
            System.err.println(e);
            return null;
        }
    }
    @Override
    @Cacheable("user")
    public List<User> findUsersByFirstName(String firstName) {

        if (firstName == null) {
            System.out.println("keyword is null");
            return null;
        }

        List<User> allUsers = repositoryUser.findByFirstName(firstName);

        return allUsers;
    }
        @Override
        @Cacheable("user")
        public List<User> findUsersByLastName(String lastName) {

        if (lastName == null) {
            System.out.println("keyword is null");
            return null;
        }

        List<User> allUsers = repositoryUser.findByLastName(lastName);

        return allUsers;
    }
    @Override
    @Cacheable("user")
    public List<User> findUsersByDesiredAge(int age){

        if (age <= 0) {
            System.out.println("age cant be negative");
            return null;
        }

        List<User> allUsers= repositoryUser.findByAge(age);

        return allUsers;

    }

    @Override
    @Cacheable("user")
    public List<User> findUsersByYoungerThenDesiredAge(int age){

        if (age <= 0) {
            System.out.println("age cant be negative");
            return null;
        }

        List<User> allUsers= repositoryUser.findByAgeLessThan(age);

        return allUsers;
    }

    @Override
    @Cacheable("user")
    public List<User> findUsersByOlderThenDesiredAge(int age){

        if (age <= 0) {
            System.out.println("age cant be negative");
            return null;
        }

        List<User> allUsers= repositoryUser.findByAgeGreaterThan(age);

        return allUsers;
    }
    @Override
    @Cacheable("user")
    public List<User> sortAscUsersByAge() {
        List<User> sortedUsers = repositoryUser.findAll(Sort.by(Sort.Direction.ASC, "age"));
        return sortedUsers;
    }
    @Override
    @Cacheable("user")
    public List<User> sortDescUsersByAge() {
        List<User> sortedUsers = repositoryUser.findAll(Sort.by(Sort.Direction.DESC, "age"));
        return sortedUsers;
    }

    @Override
    @Cacheable("user")
    public User getUserByEmail(String email) {
        return repositoryUser.findByEmail(email);
    }

    /*
    @Override
    public Person getPersonByEmailAndPassword(String email, String password) throws UserNotFoundException {
        String encodePassword = passwordEncoder.encode(password);
        Person person = repositoryUser.findByEmailAndPassword(email, encodePassword);
        if(person == null){
            throw new UserNotFoundException("Invalid id and password");
        }
        return person;
    }

    @Override
    public boolean isPasswordMatch(Person person, String password) {
        String encodedPassword = person.getPassword(); // veritabanındaki şifre (encoded)
        return passwordEncoder.matches(password, encodedPassword);
    }
    */

}




