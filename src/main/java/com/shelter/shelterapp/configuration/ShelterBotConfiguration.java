package com.animalshelter.animalshelterapp.configuration;

import com.animalshelter.animalshelterapp.entity.CatShelter;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.DeleteMyCommands;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
// extends EnumStateMachineConfigurerAdapter<CommandState, CommandEvent>
@Configuration
@EnableStateMachineFactory
//@EnableJpaRepositories
public class ShelterBotConfiguration{

    @Value("${telegram.bot.token}")
    private String token;

    public ShelterBotConfiguration() {
    }
    @Bean
    public TelegramBot telegramBot() {
        TelegramBot bot = new TelegramBot(token);
        bot.execute(new DeleteMyCommands());
        return bot;
    }

    @Bean
    public CatShelter catShelter() {
        return new CatShelter(0L, "aaaaa", "bbbbb", "ccccc", "ddsdgsdgsd");
    }
}
//    @Override
//    public void configure(StateMachineConfigurationConfigurer<CommandState, CommandEvent> config)
//            throws Exception {
//        config
//                .withConfiguration()
//                .autoStartup(true)
//                .listener(listener());
//    }
//
//    @Override
//    public void configure(StateMachineStateConfigurer<CommandState, CommandEvent> states)
//            throws Exception {
//        states
//                .withStates()
//                .initial(CommandState.INFO)
//                .states(EnumSet.allOf(CommandState.class));
//    }
//
//    @Override
//    public void configure(StateMachineTransitionConfigurer<CommandState, CommandEvent> transitions)
//            throws Exception {
//        transitions
//                .withExternal()
//                .source(CommandState.INFO).target(CommandState.GUARD).event(CommandEvent.GET_INFO)
//                .and()
//                .withExternal()
//                .source(CommandState.GUARD).target(CommandState.RECOMMEND).event(CommandEvent.GET_GUARD);
//    }
//
//    @Bean
//    public StateMachineListener<CommandState, CommandEvent> listener() {
//        return new StateMachineListenerAdapter<CommandState, CommandEvent>() {
//            @Override
//            public void stateChanged(State<CommandState, CommandEvent> from, State<CommandState, CommandEvent> to) {
//                System.out.println("State change to " + to.getId());
//            }
//        };
//    }



