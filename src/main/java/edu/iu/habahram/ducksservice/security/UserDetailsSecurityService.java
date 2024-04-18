package edu.iu.habahram.ducksservice.security;

import edu.iu.habahram.ducksservice.model.Customer;
import edu.iu.habahram.ducksservice.repository.CustomerFileRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsSecurityService implements
        UserDetailsService {
    CustomerFileRepository customerFileRepository;

    public UserDetailsSecurityService(CustomerFileRepository
                                              customerFileRepository) {
        this.customerFileRepository = customerFileRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        try {
            Customer customer =
                    customerFileRepository.findByUsername(username);
            if(customer == null) {
                throw new UsernameNotFoundException("");
            }
            return User
                    .withUsername(username)
                    .password(customer.getPassword())
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
