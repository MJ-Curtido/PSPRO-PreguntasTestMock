/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package preguntasTest.vista;

import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import preguntasTest.clases.Opcion;
import preguntasTest.clases.Pregunta;
import preguntasTest.gestion.DAOProyecto;
import preguntasTest.clases.Usuario;

/**
 *
 * @author manu
 */
public class PanelPreguntas extends javax.swing.JPanel {
    private VentanaPreguntas miVentana;
    private Integer numPregunta;
    private ArrayList<Pregunta> preguntas;
    private ArrayList<Opcion> respuestas;
    private Integer contAciertos;
    private Usuario usuarioActual;
    /**
     * Creates new form PanelPreguntas
     */
    public PanelPreguntas(VentanaPreguntas miVentana, Usuario usuario) {
        initComponents();
        
        this.miVentana = miVentana;
        this.usuarioActual = usuario;
        
        contAciertos = 0;
        numPregunta = 0;
        
        this.usuarioActual = usuario;
        preguntas = DAOProyecto.getInstance().obtenerPreguntas(usuario);
        respuestas = DAOProyecto.getInstance().obtenerRespuestas(this.preguntas.get(this.numPregunta));
        
        lblNumPregunta.setText((this.numPregunta + 1) + "");
        lblPregunta.setText(this.preguntas.get(numPregunta).getPregunta());
        rbtnRespuesta1.setText(this.respuestas.get(0).getRespuesta());
        rbtnRespuesta2.setText(this.respuestas.get(1).getRespuesta());
        rbtnRespuesta3.setText(this.respuestas.get(2).getRespuesta());
        rbtnRespuesta4.setText(this.respuestas.get(3).getRespuesta());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoRbtn = new javax.swing.ButtonGroup();
        lblPregunta = new javax.swing.JLabel();
        lblNumPregunta = new javax.swing.JLabel();
        btnSiguiente = new javax.swing.JButton();
        rbtnRespuesta1 = new javax.swing.JRadioButton();
        rbtnRespuesta2 = new javax.swing.JRadioButton();
        rbtnRespuesta3 = new javax.swing.JRadioButton();
        rbtnRespuesta4 = new javax.swing.JRadioButton();

        lblPregunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPregunta.setText("Pregunta");
        lblPregunta.setName("lblPregunta"); // NOI18N

        lblNumPregunta.setText("1");
        lblNumPregunta.setName("lblNumPregunta"); // NOI18N

        btnSiguiente.setText("Siguiente Pregunta");
        btnSiguiente.setName("btnSiguiente"); // NOI18N
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        grupoRbtn.add(rbtnRespuesta1);
        rbtnRespuesta1.setText("Respuesta 1");
        rbtnRespuesta1.setName("rbtnRespuesta1"); // NOI18N

        grupoRbtn.add(rbtnRespuesta2);
        rbtnRespuesta2.setText("Respuesta 2");
        rbtnRespuesta2.setName("rbtnRespuesta2"); // NOI18N

        grupoRbtn.add(rbtnRespuesta3);
        rbtnRespuesta3.setText("Respuesta 3");
        rbtnRespuesta3.setName("rbtnRespuesta3"); // NOI18N

        grupoRbtn.add(rbtnRespuesta4);
        rbtnRespuesta4.setText("Respuesta 4");
        rbtnRespuesta4.setName("rbtnRespuesta4"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnRespuesta3)
                            .addComponent(rbtnRespuesta4)
                            .addComponent(rbtnRespuesta1)
                            .addComponent(rbtnRespuesta2)
                            .addComponent(lblPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(lblNumPregunta)))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSiguiente)
                .addGap(179, 179, 179))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblNumPregunta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(rbtnRespuesta1)
                .addGap(30, 30, 30)
                .addComponent(rbtnRespuesta2)
                .addGap(30, 30, 30)
                .addComponent(rbtnRespuesta3)
                .addGap(30, 30, 30)
                .addComponent(rbtnRespuesta4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(btnSiguiente)
                .addGap(105, 105, 105))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        if (this.numPregunta == this.preguntas.size() - 1) {
            if (comprobarAcertado()) {
                this.contAciertos++;
            }  
            
            PanelFinal panel =new PanelFinal(miVentana, usuarioActual, contAciertos, this.preguntas.size());
        
            miVentana.cambiarPanel(panel);
        }
        else {
            if (comprobarAcertado()) {
                this.contAciertos++;
            }        
            
            this.numPregunta++;
        
            respuestas = DAOProyecto.getInstance().obtenerRespuestas(this.preguntas.get(this.numPregunta));

            lblNumPregunta.setText((this.numPregunta + 1) + "");
            lblPregunta.setText(this.preguntas.get(this.numPregunta).getPregunta());
            rbtnRespuesta1.setText(this.respuestas.get(0).getRespuesta());
            rbtnRespuesta2.setText(this.respuestas.get(1).getRespuesta());
            rbtnRespuesta3.setText(this.respuestas.get(2).getRespuesta());
            rbtnRespuesta4.setText(this.respuestas.get(3).getRespuesta());
            
            grupoRbtn.clearSelection();

            if (this.numPregunta == this.preguntas.size() - 1) {
                btnSiguiente.setText("Enviar respuestas");
            }
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private boolean comprobarAcertado(){
        boolean acertado = false;
        
        Enumeration<AbstractButton> buttons = grupoRbtn.getElements();

        for(int i = 0; i < grupoRbtn.getButtonCount() && !acertado; i++){
            AbstractButton actual = buttons.nextElement();
            
            if(actual.isSelected() && this.respuestas.get(i).getCorrecta()){
                acertado = true;
            }
        }
        return acertado;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSiguiente;
    private javax.swing.ButtonGroup grupoRbtn;
    private javax.swing.JLabel lblNumPregunta;
    private javax.swing.JLabel lblPregunta;
    private javax.swing.JRadioButton rbtnRespuesta1;
    private javax.swing.JRadioButton rbtnRespuesta2;
    private javax.swing.JRadioButton rbtnRespuesta3;
    private javax.swing.JRadioButton rbtnRespuesta4;
    // End of variables declaration//GEN-END:variables
}
