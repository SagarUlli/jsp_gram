package org.jsp.jsp_gram.service;

import org.jsp.jsp_gram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	UserRepository repository;

}
