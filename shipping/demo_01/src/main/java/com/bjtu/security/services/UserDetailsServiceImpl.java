package com.bjtu.security.services;

import com.bjtu.dao.RolesDao;
import com.bjtu.dao.UsersDao;
import com.bjtu.domain.ERole;
import com.bjtu.domain.Roles;
import com.bjtu.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UsersDao usersDao;
	@Autowired
	RolesDao rolesDao;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users = usersDao.getByName(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		Set<Roles> roles = new HashSet<>();
		int oneRole=users.getIdentity();
		if (oneRole == 0) {
			Roles userRole = rolesDao.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: the role roll is not found."));
			roles.add(userRole);
		}
		else if(oneRole == 1)
		{
			Roles userRole = rolesDao.findByName(ERole.ROLE_CARRIER)
					.orElseThrow(() -> new RuntimeException("Error: the role roll is not found."));
			roles.add(userRole);
		}
		users.setRoles(roles);
		return UserDetailsImpl.build(users);
	}

}
