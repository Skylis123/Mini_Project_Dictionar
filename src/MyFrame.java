import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class ReadFromTxt {
   public boolean exist(String arg) {
       Scanner scanner;
       try {
           scanner = new Scanner(new File("Dictionar.txt"));
       } catch (FileNotFoundException e) {
           throw new RuntimeException(e);
       }
       while(scanner.hasNextLine()) {
           String line = scanner.nextLine();
           if (arg.equals(line)) {
               return true;
           }
       }
       return false;
   }
}
public class MyFrame extends JFrame implements ActionListener {
    JTextField textField;
    JButton textFieldButton;
    JTextArea textArea;
    MyFrame() {
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(300,40));
        textFieldButton = new JButton("Submit");
        textFieldButton.addActionListener(this);
        this.add(textField);
        this.add(textFieldButton);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(400,400);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.textFieldButton) {
            ReadFromTxt text = new ReadFromTxt();
            if(text.exist(this.textField.getText())){
                textArea = new JTextArea("Exist");
                this.add(textArea);
            } else {
                textArea = new JTextArea("Does not exist");
                this.add(textArea);
            }
            this.validate();
            this.repaint();
        }
    }
}
