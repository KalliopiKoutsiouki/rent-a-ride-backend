package unipi.uml.rentaridebackend.controller;

//import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import unipi.uml.rentaridebackend.exception.UserNotFoundException;
import unipi.uml.rentaridebackend.model.security.AuthRequest;
import unipi.uml.rentaridebackend.service.JwtService;

@CrossOrigin(maxAge = 3600)
@RestController
//@SecurityRequirement(name = "Authorization")
@RequestMapping({"/auth"})
public class AuthController {

//    private final JwtService jwtService;
//
//    private final AuthenticationManager authenticationManager;
//
//    public AuthController(final JwtService jwtService,final AuthenticationManager authenticationManager) {
//        this.jwtService = jwtService;
//        this.authenticationManager = authenticationManager;
//    }

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) throws UserNotFoundException {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UserNotFoundException("invalid user request !");
        }

    }
}
