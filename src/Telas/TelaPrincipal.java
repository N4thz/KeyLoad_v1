package Telas;

import Gerador.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


public final class TelaPrincipal extends javax.swing.JFrame {

    StringBuilder StringMontada;
    SQLiteConexao con = new SQLiteConexao();
    Acessos_DAO dados = new Acessos_DAO();
    GerarNotificacao notificacao = new GerarNotificacao();
    String NovoApelido, NovoLogin, NovaSenha, SenhaMaster;
    String[] valorcolunas = {"apelido","nome", "senha"};
    
    public TelaPrincipal() throws ParseException, SQLException {
        initComponents();
        jTable1.setRowHeight(25);
        con.conectar();
        String[] criarTableasUsuario = {"id INTEGER PRIMARY KEY", "senha TEXT"};
        con.createTableIfNotExists("dados_de_usuario", criarTableasUsuario);
        String[] criarTableasSalvarSenhas = {"id INTEGER PRIMARY KEY", "apelido TEXT", "nome TEXT", "senha TEXT"};
        con.createTableIfNotExists("dados_de_acesso", criarTableasSalvarSenhas);
        carregarValoresdaTabelaOcultos();
        
        
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = jTable1.rowAtPoint(e.getPoint());
                int col = 3;

                if (col == 3) { // Substitua 2 pelo índice da sua coluna booleana
                    Boolean value = (Boolean) jTable1.getValueAt(row, col);
                    if (value != null) {
                        if (value) {
                            jTable1.setValueAt(true, row, col);
                            mostrarSenha(row);
                        } else {
                            jTable1.setValueAt(false, row, col);
                            ocultarSenha(row);
                        }
                    }
                    jTable1.changeSelection(row, col, false, false);
                }
            }
        });
        
        TableColumn column = jTable1.getColumnModel().getColumn(4);
        column.setCellRenderer(new ButtonRenderer());
        column.setCellEditor(new ButtonEditor());
        
        senhaMaster();
        System.out.println(dados.Apelido);
    }
        

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("KeyLoad");
        setResizable(false);

        jPanel2.setToolTipText("");

        jTable1.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Apelido", "Login", "Senha", "Exibir", "Copiar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(3).setMinWidth(50);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(4).setMinWidth(50);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(50);
        }

        jCheckBox1.setText("Exibir Senhas");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox1))
        );

        jPanel3.setBackground(new java.awt.Color(35, 35, 85));

        jButton1.setBackground(new java.awt.Color(40, 40, 77));
        jButton1.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Novo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(40, 40, 77));
        jButton2.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(375, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        try {
            if (jCheckBox1.isSelected()){
                carregarValoresdaTabela();
            }else{
                carregarValoresdaTabelaOcultos();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        gerarSenha();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        alterarSenha();
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new TelaPrincipal().setVisible(true);
            } catch (ParseException | SQLException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    
    class MyRunnable implements Runnable {
        @Override
        public void run() {
            TableColumn columncor = jTable1.getColumnModel().getColumn(2);
            columncor.setCellRenderer(new CustomCellRED());
            jTable1.repaint();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
            columncor.setCellRenderer(new CustomCellWHITE());
            jTable1.repaint();
        }
    }
    
    class MyRunnableVerde implements Runnable {
        @Override
        public void run() {
            TableColumn columncor = jTable1.getColumnModel().getColumn(2);
            columncor.setCellRenderer(new CustomCellGreen());
            jTable1.repaint();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
            columncor.setCellRenderer(new CustomCellWHITE());
            jTable1.repaint();
        }
    }
    
    private void gerarSenha(){
        JFrame TelaNovaS = new JFrame();
        TelaNovaSenha dialogNovaSenha = new TelaNovaSenha(TelaNovaS, true);
        dialogNovaSenha.setVisible(true);
        if (dialogNovaSenha.getApelido() == null){
            System.out.println("tela cancelada");
        }else{
            NovoApelido = dialogNovaSenha.getApelido();
            NovoLogin = dialogNovaSenha.getLogin();
            NovaSenha = dialogNovaSenha.getSenha();
            dados.addApelido(NovoApelido);
            dados.addLogin(NovoLogin);
            dados.addSenha(NovaSenha);   
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            String StringAlterada = alterarchart(NovaSenha.length());
            Object[] NovaLinha = {NovoApelido, NovoLogin, StringAlterada};
            model.addRow(NovaLinha);
            jTable1.setModel(model);
            String[] comandoinsert = {"'"+dados.getApelido(dados.getID())+"'" ,"'"+dados.getLogin(dados.getID())+"'", "'"+dados.getSenha(dados.getID())+"'"};
            con.insert("dados_de_acesso", valorcolunas, comandoinsert);
            dados.addID(dados.getID()+1);
        }
    }
    
    private void alterarSenha(){
        int LocalizaçãoLinha = jTable1.getSelectedRow();
        if (LocalizaçãoLinha < 0){
            notificacao.exibirNotificacao("Atenção: Nenhuma linha selecionada", "Selecione a linha que deseja alterar",200);
        }else{
            System.out.println(LocalizaçãoLinha);
            System.out.println(jTable1.getValueAt(LocalizaçãoLinha, 0).toString());
        
            String[] dadosDaTabela = {jTable1.getValueAt(LocalizaçãoLinha, 0).toString(), 
                                  jTable1.getValueAt(LocalizaçãoLinha, 1).toString(), 
                                  dados.getSenha(LocalizaçãoLinha)};
        
            JFrame TelaNovaS = new JFrame();
            TelaNovaSenha dialogNovaSenha = new TelaNovaSenha(TelaNovaS, true);
            dialogNovaSenha.jTextField1.setText(dadosDaTabela[0]);
            dialogNovaSenha.jTextField3.setText(dadosDaTabela[1]);
            dialogNovaSenha.jTextField2.setText(dadosDaTabela[2]);
            dialogNovaSenha.setVisible(true);
        
            if (dialogNovaSenha.getApelido() == null){
                System.out.println("tela cancelada");
            }else{
                NovoApelido = dialogNovaSenha.getApelido();
                NovoLogin = dialogNovaSenha.getLogin();
                NovaSenha = dialogNovaSenha.getSenha();
                dados.alteraApelido(LocalizaçãoLinha, NovoApelido);
                dados.alterarLogin(LocalizaçãoLinha, NovoLogin);
                dados.alterarSenha(LocalizaçãoLinha, NovoLogin);
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                String StringAlterada = alterarchart(NovaSenha.length());
                Object[] NovaLinha = {NovoApelido, NovoLogin, StringAlterada};
                for (int i = 0; i <= 2; i++){
                    model.setValueAt(NovaLinha[i], LocalizaçãoLinha, i);
                }
                jTable1.setModel(model);

                con.update("dados_de_acesso", "'apelido'", "'"+NovoApelido+"'", "id", "'"+Integer.toString(LocalizaçãoLinha + 1)+"'");
                con.update("dados_de_acesso", "'nome'", "'"+NovoLogin+"'", "id", "'"+Integer.toString(LocalizaçãoLinha + 1)+"'");
                con.update("dados_de_acesso", "'senha'", "'"+NovaSenha+"'", "id", "'"+Integer.toString(LocalizaçãoLinha + 1)+"'");
            }
        }
        
    }
    
    private void  carregarValoresdaTabelaOcultos() throws SQLException{
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        dados.Apelido.clear();
        dados.Senha.clear();
        dados.id = 0;
        con.select("dados_de_acesso", valorcolunas, "");
        while (con.rs.next()){
            dados.addApelido(con.rs.getString("apelido"));
            dados.addLogin(con.rs.getString("nome"));
            dados.addSenha(con.rs.getString("senha"));
            dados.id++;
        }
        
        for(int i = 0; i < dados.getID(); i++){
            String StringAlterada = alterarchart(dados.getSenha(i).length());
            Object[] rowApelido = {dados.getApelido(i), dados.getLogin(i), StringAlterada};
            model.addRow(rowApelido);
        }
    }
    
    private void  carregarValoresdaTabela() throws SQLException{
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        dados.Apelido.clear();
        dados.Senha.clear();
        dados.id = 0;
        con.select("dados_de_acesso", valorcolunas, "");
        while (con.rs.next()){
            dados.addApelido(con.rs.getString("apelido"));
            dados.addLogin(con.rs.getString("nome"));
            dados.addSenha(con.rs.getString("senha"));
            dados.id++;
        }
        for(int i = 0; i < dados.getID(); i++){
            dados.addApelido(NovoLogin);
            Object[] rowApelido = {dados.getApelido(i), dados.getLogin(i), dados.getSenha(i)};
            model.addRow(rowApelido);
            model.setValueAt(true, i, 3);
        }
    }
    
    private void  mostrarSenha(int linha){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setValueAt(dados.getSenha(linha), linha, 2);
    }
    
    private void  ocultarSenha(int linha){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        String StringAlterada = alterarchart(dados.getSenha(linha).length());
        model.setValueAt(StringAlterada, linha, 2);
    }
    
    private String alterarchart(int valor){
        StringMontada = new StringBuilder();
        for(int i = 0; i < valor; i++){
            StringMontada.append("*");
        }
        return StringMontada.toString();
    }
    
    class ButtonRenderer extends DefaultTableCellRenderer {

    private final JButton button;

    public ButtonRenderer() {
        button = new JButton("");
        Icon icon = new ImageIcon("build\\classes\\Imagens\\icons8-copy-100.png");
        int largura = 15; // largura desejada
        int altura = 15; // altura desejada
        Image image = ((ImageIcon) icon).getImage();
        Image novaImagem = image.getScaledInstance(largura, altura, java.awt.Image.SCALE_SMOOTH);
        Icon novoIcon = new ImageIcon(novaImagem);
        button.setIcon(novoIcon);
    }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return button;
        }
    }
    
    class ButtonEditor extends DefaultCellEditor {

    private final JButton button;

    public ButtonEditor() {
        super(new JCheckBox());
        button = new JButton("");
        Icon icon = new ImageIcon("build\\classes\\Imagens\\icons8-copy-100.png");
        int largura = 15; // largura desejada
        int altura = 15; // altura desejada
        Image image = ((ImageIcon) icon).getImage();
        Image novaImagem = image.getScaledInstance(largura, altura, java.awt.Image.SCALE_SMOOTH);
        Icon novoIcon = new ImageIcon(novaImagem);
        button.setIcon(novoIcon);
        button.addActionListener((ActionEvent e) -> {
            if (jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString().contains("*")){
                
                notificacao.exibirNotificacao("Atenção: Senha Oculta", "Exiba a senha para poder copiar",200);
                Thread thread = new Thread(new MyRunnable());
                thread.start();
            }else{
                System.out.println(jTable1.getValueAt(0, 2).toString());
                String texto = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString();
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                StringSelection selection = new StringSelection(texto);
                clipboard.setContents(selection, null);
                
                notificacao.exibirNotificacao("Senha copiada para a área de transferência", "Senha: " + jTable1.getValueAt(jTable1.getSelectedRow(), 2),200);
                Thread thread = new Thread(new MyRunnableVerde());
                thread.start();
            }
        });
    }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            return button;
        }
    }   
    
    class CustomCellRED extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (column == 2 && row == jTable1.getSelectedRow()) { // Célula na linha 1 e coluna 2
                    component.setBackground(Color.RED);
            } else {
                component.setBackground(table.getBackground()); // Mantém a cor de fundo padrão para outras células
            }
            return component;
        }
    }
    
    class CustomCellGreen extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (column == 2 && row == jTable1.getSelectedRow()) { // Célula na linha 1 e coluna 2
                    component.setBackground(Color.GREEN);
            } else {
                component.setBackground(table.getBackground()); // Mantém a cor de fundo padrão para outras células
            }
            return component;
        }
    }
    
    class CustomCellWHITE extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (column == 2 && row == jTable1.getSelectedRow()) { // Célula na linha 1 e coluna 2
                    component.setBackground(table.getBackground());
                    component.setForeground(Color.BLACK);
                    
            } else {
                component.setBackground(table.getBackground()); // Mantém a cor de fundo padrão para outras células
            }
            return component;
        }
    }
    
    public void senhaMaster() throws SQLException{
        String[] tabelas = {"senha"};
        con.select("dados_de_usuario", tabelas, "");
        String senhabanco = con.rs.getString("senha");
        JFrame frame = new JFrame();
        TelaSenhaMaster dialog = new TelaSenhaMaster(frame, true);
        if (con.rs.getString("senha") == null || "".equals(con.rs.getString("senha"))){
            
            dialog.setTitle("Cadastre sua senha padrão");
            dialog.setVisible(true);
            SenhaMaster = dialog.getSenha();
            if(SenhaMaster == null || "".equals(SenhaMaster)){
            }
            else{
                String[] ResultadoSenha = {SenhaMaster};
                con.insert("dados_de_usuario", tabelas, ResultadoSenha);
            }
            
        }
        else{
            System.out.println(senhabanco);
            do {
                dialog = new TelaSenhaMaster(frame, true);
                dialog.setTitle("Insira sua senha padrão");
                dialog.setVisible(true);
                SenhaMaster = dialog.getSenha();
            } while(SenhaMaster == null ? senhabanco != null : !SenhaMaster.equals(senhabanco));
        }
    }
}