package org.rf.test.main;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class ActivemqSenderQueueApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ActivemqSenderQueueApplication.class, args);

		// get JmsTemplate bean and send message to queue
		JmsTemplate jms = ctx.getBean(JmsTemplate.class);

		System.out.println("Type bye to exit");
		String message = "";
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("Type message : ");
			message = sc.nextLine();
			jms.convertAndSend("queue1", message);
		} while (!message.equalsIgnoreCase("bye"));
	}
}
