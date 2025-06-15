package com.mycompany.trabalhofinalpoo.view;

public class TelaPrincipal extends javax.swing.JFrame {

    public TelaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        btnNovaReceita = new javax.swing.JButton();
        btnNovaDespesa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Controle Financeiro");

        btnNovaReceita.setText("Nova Receita");
        btnNovaReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaReceitaActionPerformed(evt);
            }
        });

        btnNovaDespesa.setText("Nova Despesa");
        btnNovaDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaDespesaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(btnNovaReceita)
                .addGap(40, 40, 40)
                .addComponent(btnNovaDespesa)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovaReceita)
                    .addComponent(btnNovaDespesa))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void btnNovaReceitaActionPerformed(java.awt.event.ActionEvent evt) {
        new FormReceita().setVisible(true);
    }

    private void btnNovaDespesaActionPerformed(java.awt.event.ActionEvent evt) {
        new FormDespesa().setVisible(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new TelaPrincipal().setVisible(true));
    }

    private javax.swing.JButton btnNovaReceita;
    private javax.swing.JButton btnNovaDespesa;
}