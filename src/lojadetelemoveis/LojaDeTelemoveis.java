/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojadetelemoveis;

/**
 *
 * @author andra
 */
public class LojaDeTelemoveis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("test");
        System.out.println("test2");
        System.out.println("Final test");
        Produto Tech = new Produto();
        Tech.setmarca("wt");
        Tech.setmodelo("arroz");
        Tech.setano(2014);
        Tech.setprocessador("SD 801");
        Tech.setrom(16);
        Tech.setram(2);
        Tech.settraseira(13);
        Tech.setfrontal(5);
        Tech.setso("Android 4.4 KitKat");
        Tech.setpreco(199);
        
    }
    
}
