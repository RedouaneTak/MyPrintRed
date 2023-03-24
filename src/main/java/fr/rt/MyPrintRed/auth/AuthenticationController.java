package fr.rt.MyPrintRed.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;





    @PostMapping("register")
    public ResponseEntity<AuthenticationResponse> registerUser(@RequestBody RegisterRequest request){

        return ResponseEntity.ok(service.registerUser(request));

    }

    @PostMapping("register/admin")
    public ResponseEntity<AuthenticationResponse> registerAdmin(@RequestBody RegisterRequest request){

        return ResponseEntity.ok(service.registerAdmin(request));

    }


    @PostMapping("authenticate")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest request){

        return ResponseEntity.ok(service.authenticate(request));
    }




}