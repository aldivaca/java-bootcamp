package com.services.ShopCart;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import services.ServiceShopCart;
import services.ServiceShopCartFactory;

@Configuration
@ComponentScan
public class Main {

	@Bean
	ServiceShopCart mockLocalService() {
		ServiceShopCart service = ServiceShopCartFactory.getLocalService();
		return service;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
		ServiceShopCart service = context.getBean(ServiceShopCart.class);
		service.createCart();
		service.addItem();
		service.detailCart();
		service.makePurchase();
	}

}