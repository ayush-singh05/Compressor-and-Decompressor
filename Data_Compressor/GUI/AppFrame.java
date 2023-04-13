package GUI;

import comp_decomp.compressor;
import comp_decomp.decompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public  class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;
    AppFrame() {

        // exit out from application
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set title of application
        this.setTitle(" File Compressor and Decompressor");

        // Creating an Icon Logo
        ImageIcon image = new ImageIcon("GUI/logo.png");

        // Change icon frame
        this.setIconImage(image.getImage());



        // set size of Frame
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screensize.width;
        int height = screensize.height;
        this.setSize(width/2,600);
        this.setResizable(false);
        this.setLocationRelativeTo(null); // put frame into the circle

         // Set Background color
        this.getContentPane().setBackground(new Color(137, 235, 238));


        // Compress Button
        compressButton = new JButton("Select file to Compress ");
        compressButton.setFocusPainted(false);
        compressButton.setBounds(250,290,240,40);
        compressButton.setFont(new Font("comic sans",Font.LAYOUT_LEFT_TO_RIGHT,15));
        compressButton.setBackground(Color.lightGray);
        compressButton.setBorder(BorderFactory.createEtchedBorder());
        compressButton.addActionListener(this); // act when we perform any opration
        this.add(compressButton);

        // Decompress Button
        decompressButton = new JButton("Select file to Decompress");
        decompressButton.setFocusPainted(false);
        decompressButton.setBounds(250,90,240,40);
        decompressButton.setFont(new Font("comic sans",Font.LAYOUT_LEFT_TO_RIGHT,15));
        decompressButton.setBackground(Color.lightGray);
        decompressButton.setBorder(BorderFactory.createEtchedBorder());
        decompressButton.addActionListener(this);
        this.add(decompressButton);

        // Button Layout
        this.setLayout(null);

        // make frame visible
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // compression
        if(e.getSource() == compressButton) {
           JFileChooser fileChooser = new JFileChooser();
           int respond = fileChooser.showSaveDialog(null);
           if(respond == JFileChooser.APPROVE_OPTION) {
               File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
               System.out.print(file);
               try{
                   compressor.method(file);
               }
               catch(Exception es) {
                   JOptionPane.showMessageDialog(null,es.toString());
               }
           }
        }
        // Decompression
        if(e.getSource() == decompressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int respond = fileChooser.showSaveDialog(null);
            if(respond == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    decompressor.method(file);
                }
                catch(Exception es) {
                    JOptionPane.showMessageDialog(null,es.toString());
                }
            }
        }
    }
}
