package org.tuxdevelop.spring.batch.lightmin.address_migrator.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class AddressFileLogJobConfiguration {

    @Bean
    public Job addressLogJob(final Step addressLogStep,
                             final JobBuilderFactory jobBuilderFactory) {
        return jobBuilderFactory
                .get("addressLogJob")
                .start(addressLogStep)
                .build();
    }

    @Bean
    public Step addressLogStep(
            final Tasklet addressLogTasklet,
            final StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory
                .get("addressLogTasklet")
                .tasklet(addressLogTasklet)
                .build();
    }

    @Bean
    @StepScope
    public Tasklet addressLogTasklet(@Value("#{jobParameters['fileSource']}") final String pathToFile) {
        return (stepContribution, chunkContext) -> {
            log.info("New File appeared {} ", pathToFile);
            return RepeatStatus.FINISHED;
        };
    }

}
