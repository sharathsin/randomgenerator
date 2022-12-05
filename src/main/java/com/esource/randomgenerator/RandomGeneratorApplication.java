package com.esource.randomgenerator;

import com.esource.model.RandomModel;
import com.esource.service.RandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class RandomGeneratorApplication implements CommandLineRunner {
	@Autowired
	private ApplicationContext applicationContext;
	public static void main(String[] args) {
		SpringApplication.run(RandomGeneratorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		RandomService randomService = applicationContext.getBean(RandomService.class);
		RandomModel randomModel = randomService.generateRandomModel();
		System.out.println("First Array");
		Arrays.stream(randomModel.getArray1()).forEach(e -> System.out.print(e + " "));
		System.out.println("Second Array");
		Arrays.stream(randomModel.getArray2()).forEach(e -> System.out.print(e + " "));
		System.out.println("Third Array");
		Arrays.stream(randomModel.getArray3()).forEach(e -> System.out.print(e + " "));
		System.out.println("Missing Numbers:");
		List<Integer> missingList = randomService.getMissingNumbers(randomModel);
		System.out.print(missingList);
		Integer []a = new Integer[missingList.size()];
		int primeNumber = randomService.getLargestPrimeNumber(missingList.toArray(a));
		if(primeNumber !=0) {
			System.out.println("Largest prime Number:"+ primeNumber);
		}
		else {
			System.out.println("Prime Number not found");
		}
	}

@Bean
public RandomService randomService (){
		return new RandomService();
	}
}
