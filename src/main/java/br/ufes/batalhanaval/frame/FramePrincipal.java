package br.ufes.batalhanaval.frame;

import javax.swing.JFrame;

public class FramePrincipal extends JFrame {
    
    public FramePrincipal() {
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Batalha Naval");
        this.setSize(640, 480);
        this.setLocationRelativeTo(getParent());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
}
