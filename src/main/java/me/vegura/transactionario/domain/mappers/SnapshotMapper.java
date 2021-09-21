package me.vegura.transactionario.domain.mappers;

import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import me.vegura.transactionario.domain.dbmodel.Snapshot;
import me.vegura.transactionario.domain.dto.SnapshotDto;
import me.vegura.transactionario.domain.mappers.utils.CycleAvoidingMappingContext;
import me.vegura.transactionario.domain.mappers.utils.DoIgnore;

@Mapper(componentModel = "spring")
public interface SnapshotMapper {
	@Mappings({
		@Mapping(source = "snapshotIdentifier", target = "id"),
		@Mapping(source = "snapshotStatus", target = "snapshotStatus"),
		@Mapping(source = "snapshotTimeStart", target = "snapshotTimeStart"),
		@Mapping(source = "snapshotBalanceValueStart", target = "balanceValueStart"),
		@Mapping(source = "snapshotTimeEnd", target = "snapshotTimeEnd"),
		@Mapping(source = "snapshotBalanceValueEnd", target = "balanceValueEnd"),
		@Mapping(source = "balanceAccount", target = "balanceAccountDto"),
		@Mapping(source = "transactions", target = "transactions")
	})
	SnapshotDto snapshotToSnapshotDto(Snapshot snapshot, 
			@Context CycleAvoidingMappingContext cyclingAvoidingContext);
	
	@InheritInverseConfiguration
	Snapshot snaphotDtoToSnapshot(SnapshotDto snapshotDto,
			@Context CycleAvoidingMappingContext cyclingAvoidingContext);

	@DoIgnore
	default SnapshotDto snapshotToSnapshotDto(Snapshot snapshot) {
		return snapshotToSnapshotDto(snapshot, new CycleAvoidingMappingContext());
	}
	
	@DoIgnore
	default Snapshot snapshotDtoToSnapshot(SnapshotDto snapshotDto) {
		return snaphotDtoToSnapshot(snapshotDto, new CycleAvoidingMappingContext());
	}
}
