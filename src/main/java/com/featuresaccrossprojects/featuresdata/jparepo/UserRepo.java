package com.featuresaccrossprojects.featuresdata.jparepo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.featuresaccrossprojects.featuresdata.dao.User;

public interface UserRepo extends JpaRepository<User, String> {

}
