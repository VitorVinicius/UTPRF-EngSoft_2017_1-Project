/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Classes.Concessionaria;
import Classes.Equipamento;
import Classes.StatusEquipamento;
import Database.Persistencia;
import java.awt.Frame;
import java.text.Format;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Vitor
 */
public class TelaCadastroEquipamento extends javax.swing.JDialog {

    /**
     * Creates new form TelaCadastroEquipamentoJD
     * @param parent
     * @param modal
     */
    public TelaCadastroEquipamento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    private Equipamento equipamentoEdicao;

    TelaCadastroEquipamento(TelaVisualizarEquipamentos parent, boolean modal, Equipamento equipamento) {
        super(parent, modal);
        initComponents();
        this.equipamentoEdicao = equipamento;
        this.jbRemover.setEnabled(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jbRemover = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jtfEAN = new javax.swing.JTextField();
        jtfValidade = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtfCategoria = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfFabricante = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfDataCompra = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jtfId = new javax.swing.JTextField();
        jtfStatus = new javax.swing.JTextField();
        jtfValorDiaria = new javax.swing.JTextField();
        jtfValorPatrimonio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfDataProxRevisao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfConcessionaria = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jtfNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaDescricao = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Equipamento");
        setResizable(false);

        jButton2.setText("Salvar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jbRemover.setText("Remover");

        jtfEAN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfEANFocusLost(evt);
            }
        });

        jtfValidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfValidadeFocusLost(evt);
            }
        });

        jLabel1.setText("Id:");

        jtfCategoria.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfCategoriaFocusLost(evt);
            }
        });

        jLabel2.setText("Nome:");

        jtfFabricante.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfFabricanteFocusLost(evt);
            }
        });

        jLabel3.setText("EAN/Cód. Barras:");

        jtfDataCompra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfDataCompraFocusLost(evt);
            }
        });

        jLabel8.setText("Data da Compra:");

        jLabel9.setText("Próxima Revisão:");

        jLabel10.setText("Validade:");

        jLabel11.setText("Valor Diária (R$):");

        jLabel12.setText("Valor do Patrimônio (R$):");

        jLabel13.setText("Status:");

        jtfId.setEditable(false);

        jtfStatus.setEditable(false);

        jtfValorDiaria.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfValorDiariaFocusLost(evt);
            }
        });

        jtfValorPatrimonio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfValorPatrimonioFocusLost(evt);
            }
        });

        jLabel4.setText("Concessionária:");

        jtfDataProxRevisao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfDataProxRevisaoFocusLost(evt);
            }
        });

        jLabel5.setText("Descrição:");

        jtfConcessionaria.setEditable(false);

        jLabel6.setText("Categoria:");

        jLabel7.setText("Fabricante:");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jtfNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfNomeFocusLost(evt);
            }
        });

        jtaDescricao.setColumns(20);
        jtaDescricao.setRows(5);
        jtaDescricao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtaDescricaoFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(jtaDescricao);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jtfFabricante))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel9))))
                    .addComponent(jScrollPane1)
                    .addComponent(jtfNome)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(78, 78, 78)
                                        .addComponent(jLabel3))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtfStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtfEAN, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(90, 90, 90))
                            .addComponent(jtfValidade)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jtfValorDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel11)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfValorPatrimonio, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addGap(222, 222, 222))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtfDataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtfDataProxRevisao, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtfConcessionaria, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel13)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfEAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfValidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDataProxRevisao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfConcessionaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfValorDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfValorPatrimonio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Dados Cadastrais", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 411, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Histórico", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jbRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbRemover)
                    .addComponent(jButton2)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DialogoBuscarConcessionaria dialogo = new DialogoBuscarConcessionaria((Frame) null, true);
        dialogo.setVisible(true);
        Concessionaria conc = dialogo.getConcessionariaSelecionada();
        if (conc != null) {
            jtfConcessionaria.setText(String.valueOf(conc.getNome()));
            if (equipamentoEdicao == null) {
                equipamentoEdicao = new Equipamento();
            }
            try {
                equipamentoEdicao.setConcessionaria(conc);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.toString(), "Validação", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (equipamentoEdicao == null) {
            return;
        }
        try {
            if (equipamentoEdicao.getId() == 0) {
                equipamentoEdicao.setStatus(StatusEquipamento.Disponivel);
                equipamentoEdicao = (Equipamento)Persistencia.salvar(equipamentoEdicao);
                jtfId.setText(String.valueOf(equipamentoEdicao.getId()));
                jtfStatus.setText(equipamentoEdicao.getStatus().name());

            } else {

                Persistencia.atualizar(equipamentoEdicao);
            }
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Salvar Equipamento", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jtaDescricaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtaDescricaoFocusLost
        if(equipamentoEdicao== null){
            equipamentoEdicao = new Equipamento();
        }
        try{
            equipamentoEdicao.setDescricao(this.jtaDescricao.getText());
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Validação", JOptionPane.ERROR_MESSAGE);           
        }
    }//GEN-LAST:event_jtaDescricaoFocusLost

    private void jtfEANFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfEANFocusLost
        if (equipamentoEdicao == null) {
            equipamentoEdicao = new Equipamento();
        }
        try {
            equipamentoEdicao.setEan(jtfEAN.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Validação", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jtfEANFocusLost

    private void jtfValidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfValidadeFocusLost
        if (equipamentoEdicao == null) {
                equipamentoEdicao = new Equipamento();
            }
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
java.sql.Date data = new java.sql.Date(format.parse(jtfValidade.getText()).getTime());
            equipamentoEdicao.setValidade(data);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Validação", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jtfValidadeFocusLost

    private void jtfNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfNomeFocusLost
        if(equipamentoEdicao== null){
            equipamentoEdicao = new Equipamento();
        }
        try{
            equipamentoEdicao.setNome(jtfNome.getText());
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Validação", JOptionPane.ERROR_MESSAGE);           
        }
    }//GEN-LAST:event_jtfNomeFocusLost

    private void jtfCategoriaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfCategoriaFocusLost
        if(equipamentoEdicao== null){
            equipamentoEdicao = new Equipamento();
        }
        try{
            equipamentoEdicao.setCategoria(this.jtfCategoria.getText());
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Validação", JOptionPane.ERROR_MESSAGE);           
        }
    }//GEN-LAST:event_jtfCategoriaFocusLost

    private void jtfFabricanteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfFabricanteFocusLost
         if(equipamentoEdicao== null){
            equipamentoEdicao = new Equipamento();
        }
        try{
            equipamentoEdicao.setFabricante(this.jtfFabricante.getText());
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Validação", JOptionPane.ERROR_MESSAGE);           
        }
    }//GEN-LAST:event_jtfFabricanteFocusLost

    private void jtfDataCompraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfDataCompraFocusLost
        if (equipamentoEdicao == null) {
            equipamentoEdicao = new Equipamento();
        }
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date data = new java.sql.Date(format.parse(jtfDataCompra.getText()).getTime());
            equipamentoEdicao.setDataCompra(data);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Validação", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jtfDataCompraFocusLost

    private void jtfDataProxRevisaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfDataProxRevisaoFocusLost
       if (equipamentoEdicao == null) {
            equipamentoEdicao = new Equipamento();
        }
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date data = new java.sql.Date(format.parse(jtfDataProxRevisao.getText()).getTime());
            equipamentoEdicao.setProximaRevisao(data);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Validação", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jtfDataProxRevisaoFocusLost

    private void jtfValorDiariaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfValorDiariaFocusLost
        if (equipamentoEdicao == null) {
                equipamentoEdicao = new Equipamento();
            }
            try {
                equipamentoEdicao.setValorDiaria(Float.parseFloat(jtfValorDiaria.getText()));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.toString(), "Validação", JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_jtfValorDiariaFocusLost

    private void jtfValorPatrimonioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfValorPatrimonioFocusLost
       if (equipamentoEdicao == null) {
                equipamentoEdicao = new Equipamento();
            }
        try {
            equipamentoEdicao.setValorPatrimonio(Float.parseFloat(jtfValorPatrimonio.getText()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Validação", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jtfValorPatrimonioFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroEquipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroEquipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroEquipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroEquipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaCadastroEquipamento dialog = new TelaCadastroEquipamento(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbRemover;
    private javax.swing.JTextArea jtaDescricao;
    private javax.swing.JTextField jtfCategoria;
    private javax.swing.JTextField jtfConcessionaria;
    private javax.swing.JTextField jtfDataCompra;
    private javax.swing.JTextField jtfDataProxRevisao;
    private javax.swing.JTextField jtfEAN;
    private javax.swing.JTextField jtfFabricante;
    private javax.swing.JTextField jtfId;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfStatus;
    private javax.swing.JTextField jtfValidade;
    private javax.swing.JTextField jtfValorDiaria;
    private javax.swing.JTextField jtfValorPatrimonio;
    // End of variables declaration//GEN-END:variables

   public void carregarDadosEquipamentoEdicao() {
        
        jtfId.setText(String.valueOf(equipamentoEdicao.getId()));
        jtfStatus.setText(equipamentoEdicao.getStatus().name());
        jtfEAN.setText(equipamentoEdicao.getEan());
        Format formatter = new SimpleDateFormat("dd/MM/yyyy");
        String data = formatter.format(equipamentoEdicao.getValidade());
        jtfValidade.setText(data);
        jtfNome.setText(equipamentoEdicao.getNome());
        jtaDescricao.setText(equipamentoEdicao.getDescricao());
        jtfCategoria.setText(equipamentoEdicao.getCategoria());
        jtfFabricante.setText(equipamentoEdicao.getFabricante());
        data = formatter.format(equipamentoEdicao.getDataCompra());
        jtfDataCompra.setText(data);
        data = formatter.format(equipamentoEdicao.getProximaRevisao());
        jtfDataProxRevisao.setText(data);
        jtfConcessionaria.setText(equipamentoEdicao.getConcessionaria().getNome());
        jtfValorDiaria.setText(String.valueOf(equipamentoEdicao.getValorDiaria()));
        jtfValorPatrimonio.setText(String.valueOf(equipamentoEdicao.getValorPatrimonio()));
        
    }
}
