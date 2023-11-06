package com.animalshelter.animalshelterapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnimalShelterAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimalShelterAppApplication.class, args);
	}

//	@Autowired
//	private StateMachine<CommandState, CommandEvent> stateMachine;
//	@Override
//	public void run(String... args) throws Exception {
//		stateMachine.sendEvent(CommandEvent.GET_INFO);
//		stateMachine.sendEvent(CommandEvent.GET_GUARD);
//	}
}
