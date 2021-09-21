package me.vegura.transactionario.domain.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import me.vegura.transactionario.domain.dbmodel.Profile;
import me.vegura.transactionario.domain.dto.ProfileDto;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

	@Mappings({
		@Mapping(source = "profileIdentifier", target = "profileIdentifier"),
		@Mapping(source = "firstName", target = "firstName"),
		@Mapping(source = "lastName", target = "lastName"),
		@Mapping(source = "birthDate", target = "birthDate"),
		@Mapping(source = "description", target = "description"),
		@Mapping(source = "creationDateTime", target = "creationDateTime")
	})
	ProfileDto profileToProfileDto(Profile profile);
	
	@InheritInverseConfiguration
	Profile profileDtoToProfile(ProfileDto profileDto);
	
}
