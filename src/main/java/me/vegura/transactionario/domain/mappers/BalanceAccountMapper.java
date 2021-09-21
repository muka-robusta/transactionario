package me.vegura.transactionario.domain.mappers;

import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import me.vegura.transactionario.domain.dbmodel.BalanceAccount;
import me.vegura.transactionario.domain.dto.BalanceAccountDto;
import me.vegura.transactionario.domain.mappers.utils.CycleAvoidingMappingContext;
import me.vegura.transactionario.domain.mappers.utils.DoIgnore;

@Mapper(componentModel = "spring", uses = {IdentityMapper.class, SnapshotMapper.class})
public interface BalanceAccountMapper {
	@Mappings({
		@Mapping(source = "balanceAccountIdentifier", target = "accountIdentifier"),
		@Mapping(source = "balanceStatus", target = "balanceStatus"),
		@Mapping(source = "balanceCreationDate", target = "balanceCreationDate"),
		@Mapping(source = "balanceValue", target = "balanceValue"), 
		@Mapping(source = "identity", target = "identityDto"),
		@Mapping(source = "snapshots", target = "snapshots"),
		@Mapping(source = "activeSnapshot", target = "activeSnapshot"),
		@Mapping(source = "balanceType", target = "balanceType")
	}) 
	BalanceAccountDto balanceAccountToBalanceAccountDto(BalanceAccount balanceAccount, 
			@Context CycleAvoidingMappingContext cycleAvoidingContext);
	
	@InheritInverseConfiguration
	BalanceAccount balanceAccountDtoToBalanceAccount(BalanceAccountDto balanceAccountDto, 
			@Context CycleAvoidingMappingContext cycleAvoidingContext);
	
	@DoIgnore
	default BalanceAccountDto balanceAccountToBalanceAccountDto(BalanceAccount balanceAccount) {
		return balanceAccountToBalanceAccountDto(balanceAccount, new CycleAvoidingMappingContext());
	}
	
	@DoIgnore
	default BalanceAccount balanceAccountDtoToBalanceAccount(BalanceAccountDto balanceAccountDto) {
		return balanceAccountDtoToBalanceAccount(balanceAccountDto, new CycleAvoidingMappingContext());
	}
}
