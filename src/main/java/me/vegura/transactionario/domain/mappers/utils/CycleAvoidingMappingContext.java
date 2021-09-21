package me.vegura.transactionario.domain.mappers.utils;

import java.util.IdentityHashMap;
import java.util.Map;

import org.mapstruct.BeforeMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.TargetType;

public class CycleAvoidingMappingContext {
	private Map<Object, Object> knownInstances = new IdentityHashMap<>();
	
	@BeforeMapping
	public <T> T getMappedInstance(Object source, @TargetType Class<T> targetClass) {
		return targetClass.cast(knownInstances.get(source));
	}
	
	@BeforeMapping
	public void storeMappedInstances(Object source, @MappingTarget Object target) {
		knownInstances.put(source, target);
	}
}
