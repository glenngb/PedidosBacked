package com.atarraya.service;

import com.atarraya.model.ResetToken;

public interface IResetTokenService {
	
	ResetToken findByToken(String token);
	void guardar (ResetToken token);
	void eliminar (ResetToken token);

}
