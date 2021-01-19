package com.kafka.local;

import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HelloStreams {

	static final Logger logger = LoggerFactory.getLogger(HelloStreams.class);

	public static void main(String[] args) {
		Properties props = new Properties();
		props.put(StreamsConfig.APPLICATION_ID_CONFIG, AppConfigs.applicationName);
		props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, AppConfigs.bootStrapServers);
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, AppConfigs.offsetConfigEarliest);
		props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
		props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

		StreamsBuilder builder = new StreamsBuilder();
		KStream<String, String> KS0 = builder.stream(AppConfigs.usersTopicName);
		KS0.foreach((k, v) -> {
			System.out.println("Hello DSL user " + v);
		});

		KafkaStreams streams = new KafkaStreams(builder.build(), props);
		streams.start();

		Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
	}

}
