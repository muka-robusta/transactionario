package me.vegura.transactionario.domain.mappers;

import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import me.vegura.transactionario.domain.dbmodel.Identity;
import me.vegura.transactionario.domain.dto.IdentityDto;
import me.vegura.transactionario.domain.mappers.utils.CycleAvoidingMappingContext;
import me.vegura.transactionario.domain.mappers.utils.DoIgnore;

@Mapper(componentModel = "spring", uses = {ProfileMapper.class, BalanceAccountMapper.class})
public interface IdentityMapper {
	@Mappings({
		@Mapping(source = "identityIdentifier", target = "identityIdentifier"),
		@Mapping(source = "profile", target = "profileDto"),
		@Mapping(source = "email", target = "email"),
		@Mapping(source = "balances", target = "balanceAccounts"),
		@Mapping(source = "identityRole", target = "identityRole")
	})
	IdentityDto identityToIdentityDto(Identity identity, 
			@Context CycleAvoidingMappingContext cycleAvoidingContext);
	
	@InheritInverseConfiguration
	Identity identityDtoToIdentity(IdentityDto identotyDto, 
			@Context CycleAvoidingMappingContext cycleAvoidingContext);
	
	@DoIgnore
	default IdentityDto identityToIdentityDto(Identity identity) {
		return identityToIdentityDto(identity, new CycleAvoidingMappingContext());
	}
	
	@DoIgnore
	default Identity identityDtoToIdentity(IdentityDto identityDto) {
		return identityDtoToIdentity(identityDto, new CycleAvoidingMappingContext());
	}
}
