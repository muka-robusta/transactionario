package me.vegura.transactionario.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import me.vegura.transactionario.domain.dto.ProfileDto;
import me.vegura.transactionario.service.impl.ProfileServiceImpl;

@Slf4j
@Component
@RequiredArgsConstructor
public class AppBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private final ProfileServiceImpl profileService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		final Set<ProfileDto> findAllProfilesByFullName = profileService.findAllProfilesByFullName("Gniedykh", 0);
		// final Set<ProfileDto> foundAllProfiles = profileService.findAllProfiles(0);
		log.info("=======================" + findAllProfilesByFullName);	
	}

}
