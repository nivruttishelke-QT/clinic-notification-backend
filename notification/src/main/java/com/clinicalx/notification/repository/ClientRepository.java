
package com.clinicalx.notification.repository;

import com.clinicalx.notification.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findAll();
}