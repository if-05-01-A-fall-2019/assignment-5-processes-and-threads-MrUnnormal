/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlleonding.fibonacci;

/**
 *
 * @author Jan Kaufmann 3AHIF
 */
public class Fibonnaci_Runnable implements Runnable{
    public int result;
    int number;
    Fibonnaci_Runnable (int num) {
        this.number = num;
    }
    
    @Override
    public void run() {
        result = Fibonacci.getNumberSingle(n);
    }
}
