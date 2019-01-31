package com.epam.ta.reportportal;

import com.epam.ta.reportportal.core.analyzer.client.RabbitMqManagementClient;
import com.epam.ta.reportportal.core.analyzer.client.RabbitMqManagementClientTemplate;
import com.epam.ta.reportportal.job.SaveBinaryDataJob;
import com.epam.ta.reportportal.core.integration.plugin.PluginUploadingCache;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.rabbitmq.http.client.Client;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.*;

/**
 * @author <a href="mailto:ihar_kahadouski@epam.com">Ihar Kahadouski</a>
 */
@Configuration
@EnableAutoConfiguration(exclude = QuartzAutoConfiguration.class)
@ComponentScan(value = "com.epam.ta.reportportal", excludeFilters = {
		@ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.epam.ta.reportportal.ws.rabbit.*"),
		@ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.epam.ta.reportportal.job.*") }, includeFilters = {
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = { SaveBinaryDataJob.class, PluginUploadingCache.class }) })
@PropertySource("classpath:test-application.properties")
public class TestConfig {

	@MockBean
	protected Client rabbitClient;

	@MockBean(name = "analyzerRabbitTemplate")
	protected RabbitTemplate rabbitTemplate;

	@Bean
	@Profile("unittest")
	protected RabbitMqManagementClient managementTemplate() {
		return new RabbitMqManagementClientTemplate(rabbitClient);
	}

	@Bean
	public ObjectMapper testObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();

		objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		objectMapper.registerModule(new JavaTimeModule());

		return objectMapper;
	}
}