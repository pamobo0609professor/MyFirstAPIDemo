/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstapidemo;

import api.WeatherAPI;

/**
 *
 * @author laboratorio
 */
public class MyFirstAPIDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        final Thread aThread = new Thread(new WeatherAPI());
        aThread.start();
    }
    
}
