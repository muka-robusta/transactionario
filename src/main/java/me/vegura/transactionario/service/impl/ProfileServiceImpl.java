package me.vegura.transactionario.service.impl;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.vegura.transactionario.domain.dbmodel.Profile;
import me.vegura.transactionario.domain.dto.ProfileDto;
import me.vegura.transactionario.domain.mappers.ProfileMapper;
import me.vegura.transactionario.exceptions.UnknownResourceException;
import me.vegura.transactionario.repository.ProfileRepository;
import me.vegura.transactionario.service.ProfileService;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
	
	private static final Integer NUMBER_OF_PROFILES_ON_PAGE = 10;
	
	private final ProfileRepository profileRepository;
	private final ProfileMapper profileMapper;
	
	public Set<ProfileDto> findAllProfiles(int pageOrderNumber) {	
		final Page<Profile> allProfilesPage = profileRepository.findAll(generatePageRequest(pageOrderNumber));
		
		return allProfilesPage
				.map(el -> profileMapper.profileToProfileDto(el))
				.get()
				.collect(Collectors.toSet());
	}
	
	@Override
	public Set<ProfileDto> findAllProfilesByFullName(String fullNameRequest, int pageOrderNumber) {
		final Page<Profile> allFoundProfiles = 
				profileRepository.findByFullName(fullNameRequest, generatePageRequest(pageOrderNumber));
		
		return allFoundProfiles
				.map(el -> profileMapper.profileToProfileDto(el))
				.get()
				.collect(Collectors.toSet());
	}
	
	@Override
	public Optional<ProfileDto> findProfileByIdentifier(UUID profileId) {
		final Optional<Profile> foundByIdOptional = profileRepository.findById(profileId);
		
		if (foundByIdOptional.isEmpty())
			return Optional.empty();
		
		return foundByIdOptional
				.map(value -> profileMapper.profileToProfileDto(value));
	}

	@Override
	public ProfileDto updateProfile(ProfileDto profileDto) {
		final Profile profileDomainModel = profileMapper.profileDtoToProfile(profileDto);
		if (profileRepository.findById(profileDomainModel.getProfileIdentifier()).isEmpty())
			throw new UnknownResourceException("Unable to find resource with such id: " + profileDomainModel.getProfileIdentifier());
		
		final Profile savedProfile = profileRepository.save(profileDomainModel);
		
		return profileMapper.profileToProfileDto(savedProfile);
	}

	@Override
	public void deleteProfileById(UUID profileIdentifier) {
		profileRepository.deleteById(profileIdentifier);		
	}
	
	// Private
	
	private PageRequest generatePageRequest(int pageOrderNumber) {
		return PageRequest.of(pageOrderNumber, NUMBER_OF_PROFILES_ON_PAGE);
	}

	
}
