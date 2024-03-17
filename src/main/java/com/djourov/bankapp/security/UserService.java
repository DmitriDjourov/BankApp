package com.djourov.bankapp.security;


import com.djourov.bankapp.entity.User;
import com.djourov.bankapp.entity.enums.Role;
import com.djourov.bankapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public User create(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            // Заменить на свои исключения
            throw new RuntimeException("Пользователь с таким именем уже существует");
        }
        return save(user);
    }
    //Получение пользователя по имени пользователя
    public User getByUsername(String userName) {
        return userRepository.findByUsername(userName)
                       .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
    }
    // Получение пользователя по имени пользователя Нужен для Spring Security
    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }
    // Получение текущего пользователя
    public User getCurrentUser() {
        // Получение имени пользователя из контекста Spring Security
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUsername(username);
    }
    //Выдача прав администратора текущему пользователю Нужен для демонстрации
    @Deprecated
    public void getAdmin() {
        var user = getCurrentUser();
        user.setRole(Role.ROLE_ADMIN);
        save(user);
    }
}
