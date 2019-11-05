package com.peterguo.interview;


import com.peterguo.interview.spi.IRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Iterator;
import java.util.ServiceLoader;

@SpringBootApplication
public class InterviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewApplication.class, args);

        ServiceLoader<IRepository> serviceLoader = ServiceLoader.load(IRepository.class);
        Iterator<IRepository> it = serviceLoader.iterator();
        while (it != null && it.hasNext()){
            IRepository demoService = it.next();
            System.out.println("class:" + demoService.getClass().getName());
            demoService.save("tom");
        }
	}

}
