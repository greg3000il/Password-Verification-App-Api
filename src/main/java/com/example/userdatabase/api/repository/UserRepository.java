package com.example.userdatabase.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.userdatabase.api.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    public boolean existsByUsernameAndPassword(String username, String password);
    public boolean existsById(int id);
    
    
    
}
