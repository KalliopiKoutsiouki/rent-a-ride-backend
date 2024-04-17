//package unipi.uml.rentacarbackend.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserRepository repository;
//
//    @Autowired
//    private PasswordEncoder encoder;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<com.papei.movie_ticket_reservations.model.User> userDetail = repository.findByUserName(username);
//        if (userDetail == null) {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//        List<SimpleGrantedAuthority> authorities = userDetail.get().getUserRoles().stream()
//                .map(role -> new SimpleGrantedAuthority(role.getValue()))
//                .collect(Collectors.toList());
//        return new User(userDetail.get().getUserName(), userDetail.get().getPassword(), authorities);
//    }
//
//}
//
