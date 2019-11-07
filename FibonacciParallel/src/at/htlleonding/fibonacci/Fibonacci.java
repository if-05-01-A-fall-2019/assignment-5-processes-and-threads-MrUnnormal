/*
 * Copyright ©2015. Created by P. Bauer <p.bauer@htl-leonding.ac.at>, Department
 * of Informatics and Media Technique and Design, HTBLA Leonding, Limesstr. 12 - 14,
 * 4060 Leonding, AUSTRIA. All Rights Reserved. Permission to use, copy, modify,
 * and distribute this software and its documentation for educational,
 * research, and not-for-profit purposes, without fee and without a signed
 * licensing agreement, is hereby granted, provided that the above copyright
 * notice, this paragraph and the following two paragraphs appear in all
 * copies, modifications, and distributions. Contact the Head of Informatics,
 * Media Technique and Design, HTBLA Leonding, Limesstr. 12 - 14, 4060 Leonding,
 * Austria, for commercial licensing opportunities.
 * 
 * IN NO EVENT SHALL HTBLA LEONDING BE  LIABLE TO ANY PARTY FOR DIRECT,
 * INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES, INCLUDING LOST
 * PROFITS, ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION,
 * EVEN IF HTBLA LEONDING HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 * HTBLA LEONDING SPECIFICALLY DISCLAIMS ANY WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE. THE SOFTWARE AND ACCOMPANYING DOCUMENTATION, IF ANY,
 * PROVIDED HEREUNDER IS PROVIDED "AS IS". HTBLA LEONDING HAS NO OBLIGATION
 * TO PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS, OR MODIFICATIONS.
 */
package at.htlleonding.fibonacci;

/**
 *
 * @author P. Bauer <p.bauer@htl-leonding.ac.at>
 */
public class Fibonacci {
    static int n;
    static public int result;

    public Fibonacci(int n)  {
        this.n = n;
    }
    
    static int getNumberSingle(int n) {
        if (n < 2)
            return 1;
        else
            return getNumberSingle(n - 1) + getNumberSingle(n - 2);
    }
    
    static int getNumberParallel(int num) { // ???
	// While building throws weird error -> could not verify
       if(num < 2) {
           return 1;
       }
       Fibonnaci_Runnable runnable1 = new Fibonnaci_Runnable(num - 1);
       Fibonnaci_Runnable runnable2 = new Fibonnaci_Runnable(num - 2);
       Thread thread1 = new Thread(runnable1);
       Thread thread2 = new Thread(runnable2);
       thread1.start();
       thread2.start();
       try {
           thread1.join();
           thread2.join();
       }
       catch (Exception e) {
           System.out.println("Error occured: " + e.getMessage());
       }
       return runnable1.result + runnable2.result;
    }
}


