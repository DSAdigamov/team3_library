package ru.aston.trainee.team3_library.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.trainee.team3_library.entities.User;
import ru.aston.trainee.team3_library.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class JwtUserDetails implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return getJwtUser(username);
    }

    private List<GrantedAuthority> mapToGrantedAuthority(User user) {
        return user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    private JwtUser getJwtUser(String username) {
        User user = userRepository.findByUsername(username);
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                mapToGrantedAuthority(user),
                true,
                true,
                true,
                true
        );
    }

}
