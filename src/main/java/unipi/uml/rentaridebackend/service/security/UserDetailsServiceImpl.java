package unipi.uml.rentaridebackend.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import unipi.uml.rentaridebackend.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    private final UserRepository repository;

    public UserDetailsServiceImpl(final UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<unipi.uml.rentaridebackend.model.User> userDetail = repository.findByUserName(username);
        if (userDetail == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        List<SimpleGrantedAuthority> authorities = userDetail.get().getUserRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getValue()))
                .collect(Collectors.toList());
        return new User(userDetail.get().getUserName(), userDetail.get().getPassword(), authorities);
    }

}
