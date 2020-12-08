package com.atarraya.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atarraya.model.ResetToken;

public interface IResetTokenRepo extends JpaRepository<ResetToken, Integer> {

}
