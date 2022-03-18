package br.com.allteck.login.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.allteck.login.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
