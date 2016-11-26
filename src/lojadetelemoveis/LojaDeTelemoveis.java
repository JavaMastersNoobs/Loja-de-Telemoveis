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
        Produto Tech = new Produto("samsung", "arroz", 2014, "lol", 12,16, 3,16,13, "toto", 100);
        Tech.setMarca("wt");
        Tech.setModelo("arroz");
        Tech.setAno(2014);
        Tech.setProcessador("SD 801"); 
        Tech.setRom(16);
        Tech.setRam(2);
        Tech.setTraseira(13);
        Tech.setFrontal(5);
        Tech.setSo("Android 4.4 KitKat");
        Tech.setPreco(199);
        /*not*/
        /*ficheiros*/
        
    }
    
}
