package com.hibernate.manytomany.repository;

import com.hibernate.manytomany.entity.Iuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IuserRepository extends JpaRepository<Iuser, Integer> {
}
