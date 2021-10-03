package ch.hslu.ad.sw02.stack;

import static javax.swing.JOptionPane.*;
import javax.swing.JOptionPane;


public class MainStack {
    public static void main(String[] args) {
        StackArray meinStack = new StackArray(4);

        meinStack.push("toll");
        meinStack.push("sind ");
        meinStack.push("Datenstrukturen ");

        String title = "OUTPUT";

        JOptionPane.showMessageDialog(null, meinStack.pop(), title, INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, meinStack.pop(), title, ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null, meinStack.pop(), title, WARNING_MESSAGE);

    }
}
