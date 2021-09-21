package me.vegura.transactionario.service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import me.vegura.transactionario.domain.dto.ProfileDto;

public interface ProfileService {
	Optional<ProfileDto> findProfileByIdentifier(UUID profileId);
	Set<ProfileDto> findAllProfiles(int pageNumber);
	Set<ProfileDto> findAllProfilesByFullName(String fullNameRequest, int pageNumber);
	ProfileDto updateProfile(ProfileDto profileDto);
	void deleteProfileById(UUID profileIdentifier);
}
