/**
 * 
 */
package com.alejandro.restauranteweb.controllers;

/**
 * @author Horiz
 *
 */
import javax.faces.bean.ManagedBean;

@ManagedBean
public class WelcomeBean {
	public WelcomeBean() {
		System.out.println("WelcomeBean instantiated");
	}

	public String getMessage() {
		return "I'm alive!";
	}
}
