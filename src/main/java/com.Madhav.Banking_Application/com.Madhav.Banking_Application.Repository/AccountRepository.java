//Interface
package com.Madhav.Banking_Application.Repository;

import com.Madhav.Banking_Application.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
