package com.alice.controller;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.alibaba.fastjson.JSON;
import com.alice.entity.Student;

public class TestKafka {

	public static void main(String[] args) {
		Properties properties = new Properties();
		properties.put("bootstrap.servers", "192.168.126.128:9092");
		properties.put("acks", "all");
		properties.put("retries", 0);
		properties.put("batch.size", 16384);
		properties.put("linger.ms", 1);
		properties.put("buffer.memory", 33554432);
		properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		Producer<String, String> producer = null;
		try {
			producer = new KafkaProducer<String, String>(properties);
			for (int i = 0; i < 1000000; i++) {
//				String msg = "Message==> " + i;
				
				Student student = new Student();
				student.setId(i);
				student.setName("niklaus_"+i);
				student.setAge(i);
				student.setAddress("china_"+i);
				String stuJson = JSON.toJSON(student).toString();
				
				producer.send(new ProducerRecord<String, String>("alice", stuJson));
				System.out.println("Sent:" + stuJson);
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			producer.close();
		}

	}

}
