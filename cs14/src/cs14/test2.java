/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs14;
import javax.swing.JFrame;
public class test2{
    public static void main(String[] args) {
        JFrame frame = new test1();
        frame.setTitle("Swing Example");
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}