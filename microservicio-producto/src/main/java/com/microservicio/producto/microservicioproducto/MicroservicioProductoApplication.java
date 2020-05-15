package com.microservicio.producto.microservicioproducto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroservicioProductoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioProductoApplication.class, args);
	}

}
