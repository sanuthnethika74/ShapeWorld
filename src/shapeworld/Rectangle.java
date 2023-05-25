package shapeworld;

// SysImports
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.util.Arrays;
import javax.imageio.ImageIO;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

/**
 *
 * @author Ayesh Geelaka
 */
public class Rectangle extends javax.swing.JFrame {

    // SysVariables
    BufferedImage image;
    private Graphics2D graphic, saveGraphic;
    private String c;
    private double scale = 1.0d;
    private double tempW;
    private double tempH;
    private double tempR;
    private int shapeWidth;
    private int shapeHeight;
    private int shapeRadius;
    private int shapeX;
    private int shapeY;
    private int drawingBoardWidth;
    private int drawingBoardHeight;
    private int drawingBoardCenterX;
    private int drawingBoardCenterY;

    // Validate Number Input
    private void validateNumberInput(int maxLength, JTextField obj) {
        try {
            String originalTxt = obj.getText();
            String regexTxt = "[^0-9]";
            String numOnlyTxt = originalTxt.replaceAll(regexTxt, "");
            obj.setText(numOnlyTxt);
            if (Integer.valueOf(numOnlyTxt) > maxLength) {
                obj.setText(String.valueOf(maxLength));
                // Show an error message or take appropriate action
                JOptionPane.showMessageDialog(null, "Text length exceeds the maximum limit of " + maxLength + " characters.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            // Show an error message or take appropriate action
            JOptionPane.showMessageDialog(null, "Numbers Only", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Clear Canvas
    private void resetCanvas() {
        try {
            rngSlider.enable(true);
            lblSave.show();
            scale = Double.valueOf(rngSlider.getValue()) / 10;
            graphic.clearRect(0, 0, drawingBoardWidth, drawingBoardHeight);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Somthing went Wrong " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Set Selected Color
    private void setSelectedColor() {
        try {

            // Get color
            c = colorSelector.getSelectedItem().toString().toUpperCase();

            // Assign Shape Color
            switch (c) {
                case "RED":
                    graphic.setColor(Color.RED);
                    break;
                case "BLACK":
                    graphic.setColor(Color.BLACK);
                    break;
                case "GREEN":
                    graphic.setColor(Color.GREEN);
                    break;
                case "BLUE":
                    graphic.setColor(Color.BLUE);
                    break;
                case "PINK":
                    graphic.setColor(Color.PINK);
                    break;
                case "ORANGE":
                    graphic.setColor(Color.ORANGE);
                    break;
                default:
                    graphic.setColor(Color.BLACK);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Somthing went Wrong " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Draw Rectangle
    private void drawRectangle(int width, int height) {

        rngSlider.enable(true);
        lblSave.show();

        // Call Clear Canvas
        resetCanvas();

        try {

            // Set Temp Size
            tempW = Double.valueOf(width) * scale;
            tempH = Double.valueOf(height) * scale;

            // Set Shape Size
            shapeWidth = (int) tempW;
            shapeHeight = (int) tempH;

            // Set Shape X Y
            shapeX = drawingBoardCenterX - shapeWidth / 2;
            shapeY = drawingBoardCenterY - shapeHeight / 2;

            // Set Selected Color
            setSelectedColor();

            // Draw Shape
            graphic.fillRect(shapeX, shapeY, shapeWidth, shapeHeight);

            // Create BufferedImage
            image = new BufferedImage(drawingBoardWidth, drawingBoardHeight, BufferedImage.TYPE_INT_RGB);
            saveGraphic = image.createGraphics();
            saveGraphic.setColor(Color.WHITE);
            saveGraphic.fillRect(0, 0, drawingBoardWidth, drawingBoardHeight + 500);
            saveGraphic.setColor(graphic.getColor());
            saveGraphic.fillRect(shapeX, shapeY, shapeWidth, shapeHeight);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Somthing went Wrong " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    //Home
    ImageIcon Home_img = new javax.swing.ImageIcon(getClass().getResource("/Image/IconHome-mini.png"));
    ImageIcon Home_hover_img = new javax.swing.ImageIcon(getClass().getResource("/Image/IconHome-hover-mini.png"));
    //Draw
    ImageIcon Draw_img = new javax.swing.ImageIcon(getClass().getResource("/Image/IconDrawShape-mini.png"));
    ImageIcon Draw_hover_img = new javax.swing.ImageIcon(getClass().getResource("/Image/IconDrawShape-hover-mini.png"));
    //Save
    ImageIcon Save_img = new javax.swing.ImageIcon(getClass().getResource("/Image/IconSave.png"));
    ImageIcon Save_hover_img = new javax.swing.ImageIcon(getClass().getResource("/Image/IconSave-hover.png"));
    //Reset
    ImageIcon Reset_img = new javax.swing.ImageIcon(getClass().getResource("/Image/IconReset.png"));
    ImageIcon Reset_hover_img = new javax.swing.ImageIcon(getClass().getResource("/Image/IconReset-hover.png"));
    //Menue
    ImageIcon Menu_img = new javax.swing.ImageIcon(getClass().getResource("/Image/IconMenu.png"));
    ImageIcon Menu_hover_img = new javax.swing.ImageIcon(getClass().getResource("/Image/IconMenu-hover.png"));
    //2D
    ImageIcon D2_img = new javax.swing.ImageIcon(getClass().getResource("/Image/Icon2D.png"));
    ImageIcon D2_hover_img = new javax.swing.ImageIcon(getClass().getResource("/Image/Icon2D-hover.png"));
    //3D
    ImageIcon D3_img = new javax.swing.ImageIcon(getClass().getResource("/Image/Icon3D.png"));
    ImageIcon D3_hover_img = new javax.swing.ImageIcon(getClass().getResource("/Image/Icon3D-hover.png"));

    public Rectangle() {
        initComponents();
        colorSelector.setLightWeightPopupEnabled(false);

        // Create Graphic Object
        graphic = (Graphics2D) drawingBoard.getGraphics();

        //Paint on DrawingBoard
        drawingBoard.paintAll(graphic);

        // Get DrawingBoard Size
        drawingBoardWidth = drawingBoard.getWidth();
        drawingBoardHeight = drawingBoard.getHeight();

        // Calculate DrawingBoard Center X Y
        drawingBoardCenterX = drawingBoardWidth / 2;
        drawingBoardCenterY = drawingBoardHeight / 2;

        // Set scale
        scale = Double.valueOf(rngSlider.getValue()) / 10;

        // Call Set Selected Color
        setSelectedColor();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/Logo.png")));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rngSlider = new javax.swing.JSlider();
        lblSliderShape = new javax.swing.JLabel();
        lbl3D = new javax.swing.JLabel();
        lbl2D = new javax.swing.JLabel();
        txtWidth = new javax.swing.JTextField();
        lblWidth = new javax.swing.JLabel();
        txtHeight = new javax.swing.JTextField();
        lblColor = new javax.swing.JLabel();
        lblHeight = new javax.swing.JLabel();
        colorSelector = new javax.swing.JComboBox<>();
        lblDraw = new javax.swing.JLabel();
        drawingBoard = new java.awt.Canvas();
        lblMenu = new javax.swing.JLabel();
        lblHome = new javax.swing.JLabel();
        lblMainTitle = new javax.swing.JLabel();
        lblSave = new javax.swing.JLabel();
        lblReset = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1111, 575));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rngSlider.setMaximum(20);
        rngSlider.setMinimum(10);
        rngSlider.setPaintTicks(true);
        rngSlider.setToolTipText("");
        rngSlider.setValue(10);
        rngSlider.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                rngSliderAncestorMoved(evt);
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        rngSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rngSliderStateChanged(evt);
            }
        });
        rngSlider.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                rngSliderMouseWheelMoved(evt);
            }
        });
        rngSlider.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                rngSliderCaretPositionChanged(evt);
            }
        });
        getContentPane().add(rngSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 510, -1, -1));

        lblSliderShape.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/slider shape.png"))); // NOI18N
        getContentPane().add(lblSliderShape, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 490, -1, 60));

        lbl3D.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon3D.png"))); // NOI18N
        lbl3D.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl3DMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl3DMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl3DMouseExited(evt);
            }
        });
        getContentPane().add(lbl3D, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 490, -1, -1));

        lbl2D.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon2D.png"))); // NOI18N
        lbl2D.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl2DMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl2DMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl2DMouseExited(evt);
            }
        });
        getContentPane().add(lbl2D, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 490, -1, -1));

        txtWidth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtWidthKeyReleased(evt);
            }
        });
        getContentPane().add(txtWidth, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 80, 30));

        lblWidth.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblWidth.setText("Width");
        getContentPane().add(lblWidth, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

        txtHeight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHeightKeyReleased(evt);
            }
        });
        getContentPane().add(txtHeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 80, 30));

        lblColor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblColor.setText("Color");
        getContentPane().add(lblColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, -1, -1));

        lblHeight.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblHeight.setText("Height");
        getContentPane().add(lblHeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

        colorSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Red", "Black", "Green", "Blue", "Orange", "Pink" }));
        colorSelector.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                colorSelectorItemStateChanged(evt);
            }
        });
        colorSelector.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                colorSelectorKeyReleased(evt);
            }
        });
        getContentPane().add(colorSelector, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 100, 30));

        lblDraw.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/IconDrawShape-mini.png"))); // NOI18N
        lblDraw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDrawMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblDrawMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblDrawMouseExited(evt);
            }
        });
        getContentPane().add(lblDraw, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, -1, -1));

        drawingBoard.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(drawingBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1090, 390));

        lblMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/IconMenu.png"))); // NOI18N
        lblMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMenuMouseExited(evt);
            }
        });
        getContentPane().add(lblMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 490, -1, -1));

        lblHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/IconHome-mini.png"))); // NOI18N
        lblHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblHomeMouseExited(evt);
            }
        });
        getContentPane().add(lblHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, -1, -1));

        lblMainTitle.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblMainTitle.setForeground(new java.awt.Color(0, 153, 0));
        lblMainTitle.setText("Rectangle");
        getContentPane().add(lblMainTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        lblSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/IconSave.png"))); // NOI18N
        lblSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSaveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSaveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSaveMouseExited(evt);
            }
        });
        getContentPane().add(lblSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, -1, -1));

        lblReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/IconReset.png"))); // NOI18N
        lblReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblResetMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblResetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblResetMouseExited(evt);
            }
        });
        getContentPane().add(lblReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, -1, -1));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/PanelBackground.png"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 570));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseEntered
        lblHome.setIcon(Home_hover_img);
    }//GEN-LAST:event_lblHomeMouseEntered

    private void lblHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseExited
        lblHome.setIcon(Home_img);
    }//GEN-LAST:event_lblHomeMouseExited

    private void lblHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseClicked
        Home H = new Home();
        H.show();
        this.hide();
    }//GEN-LAST:event_lblHomeMouseClicked

    private void lblDrawMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDrawMouseEntered
        lblDraw.setIcon(Draw_hover_img);
    }//GEN-LAST:event_lblDrawMouseEntered

    private void lblDrawMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDrawMouseExited
        lblDraw.setIcon(Draw_img);
    }//GEN-LAST:event_lblDrawMouseExited

    private void lblSaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSaveMouseEntered
        lblSave.setIcon(Save_hover_img);
    }//GEN-LAST:event_lblSaveMouseEntered

    private void lblSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSaveMouseExited
        lblSave.setIcon(Save_img);
    }//GEN-LAST:event_lblSaveMouseExited

    private void lblResetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResetMouseEntered
        lblReset.setIcon(Reset_hover_img);
    }//GEN-LAST:event_lblResetMouseEntered

    private void lblResetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResetMouseExited
        lblReset.setIcon(Reset_img);
    }//GEN-LAST:event_lblResetMouseExited

    private void lblMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenuMouseEntered
        lblMenu.setIcon(Menu_hover_img);
    }//GEN-LAST:event_lblMenuMouseEntered

    private void lblMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenuMouseExited
        lblMenu.setIcon(Menu_img);
    }//GEN-LAST:event_lblMenuMouseExited

    private void lblMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenuMouseClicked
        ShapeMenu SM = new ShapeMenu();
        SM.show();
        this.hide();
    }//GEN-LAST:event_lblMenuMouseClicked

    private void lbl2DMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl2DMouseEntered
        lbl2D.setIcon(D2_hover_img);
    }//GEN-LAST:event_lbl2DMouseEntered

    private void lbl2DMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl2DMouseExited
        lbl2D.setIcon(D2_img);
    }//GEN-LAST:event_lbl2DMouseExited

    private void lbl3DMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl3DMouseEntered
        lbl3D.setIcon(D3_hover_img);
    }//GEN-LAST:event_lbl3DMouseEntered

    private void lbl3DMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl3DMouseExited
        lbl3D.setIcon(D3_img);
    }//GEN-LAST:event_lbl3DMouseExited

    private void rngSliderAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_rngSliderAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_rngSliderAncestorMoved

    private void rngSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rngSliderStateChanged
        // Call Draw Rectangle
        drawRectangle(Integer.valueOf(txtWidth.getText()), Integer.valueOf(txtHeight.getText()));
    }//GEN-LAST:event_rngSliderStateChanged

    private void rngSliderCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_rngSliderCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_rngSliderCaretPositionChanged

    private void colorSelectorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_colorSelectorKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_colorSelectorKeyReleased

    private void lblDrawMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDrawMouseClicked
        // Call Draw Rectangle
        drawRectangle(Integer.valueOf(txtWidth.getText()), Integer.valueOf(txtHeight.getText()));
    }//GEN-LAST:event_lblDrawMouseClicked

    private void lbl2DMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl2DMouseClicked
        // Call Draw Rectangle
        drawRectangle(Integer.valueOf(txtWidth.getText()), Integer.valueOf(txtHeight.getText()));
    }//GEN-LAST:event_lbl2DMouseClicked

    private void lblResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResetMouseClicked
        // Call Clear Canvas
        resetCanvas();
    }//GEN-LAST:event_lblResetMouseClicked

    private void txtHeightKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHeightKeyReleased
        // Call Validate Number Input
        validateNumberInput(350, txtHeight);
    }//GEN-LAST:event_txtHeightKeyReleased

    private void txtWidthKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtWidthKeyReleased
        // Call Validate Number Input
        validateNumberInput(900, txtWidth);
    }//GEN-LAST:event_txtWidthKeyReleased

    private void colorSelectorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_colorSelectorItemStateChanged
        // Call Set Selected Color
        setSelectedColor();
    }//GEN-LAST:event_colorSelectorItemStateChanged

    private void lblSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSaveMouseClicked
        // Save the BufferedImage as an image file
        try {
            // Create a FileDialog to prompt the user for a save location
            FileDialog fileChooser = new FileDialog(new Frame(), "Save As", FileDialog.SAVE);
            fileChooser.setFile("Rectangle.png"); // Set filter to only show PNG files

            // Show the dialog and wait for user input
            fileChooser.setVisible(true);

            // Get the selected file path
            String filePath = fileChooser.getDirectory() + fileChooser.getFile();
            ImageIO.write(image, "png", new File(filePath));
            System.out.println("Image saved successfully.");
        } catch (Exception e) {
            System.out.println("Error saving image: " + e.getMessage());
        }
    }//GEN-LAST:event_lblSaveMouseClicked

    private void lbl3DMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl3DMouseClicked
        // Call Clear Canvas
        resetCanvas();

        // Define the coordinates of the cube
        int[] x = {250, 375, 375, 250, 187, 313, 313, 187};
        int[] y = {250, 250, 375, 375, 313, 313, 438, 438};
        int[] z = {0, 0, 0, 0, 50, 50, 50, 50};

        // Calculate the center point of the canvas
        int centerX = drawingBoardCenterX;
        int centerY = drawingBoardCenterY;

        // Scale the x-coordinates to increase the length to 850
        double scaleFactor = 850.0 / 375.0;
        for (int i = 0; i < x.length; i++) {
            x[i] = (int) (scaleFactor * (x[i] - 250) + 250); // Subtract 250 to make (250, 250) the center of the cube
        }

        // Calculate the average of the scaled x and y coordinates
        int avgX = (int) Arrays.stream(x).average().orElse(0);
        int avgY = (int) Arrays.stream(y).average().orElse(0);

        // Shift the x and y coordinates to center the cube
        for (int i = 0; i < x.length; i++) {
            x[i] = x[i] - avgX + centerX;
            y[i] = y[i] - avgY + centerY;
        }

        // Draw the cube
        graphic.setColor(Color.ORANGE);
        graphic.fillPolygon(x, y, 4);
        graphic.setColor(Color.ORANGE);
        graphic.fillPolygon(new int[]{x[4], x[5], x[6], x[7]}, new int[]{y[4], y[5], y[6], y[7]}, 4);
        graphic.setColor(Color.ORANGE);
        for (int i = 0; i < 4; i++) {
            graphic.drawLine(x[i], y[i], x[i + 4], y[i + 4]);
        }
        graphic.setColor(Color.ORANGE);
        graphic.fillPolygon(new int[]{x[1], x[2], x[6], x[5]}, new int[]{y[1], y[2], y[6], y[5]}, 4);
        graphic.setColor(Color.blue);
        graphic.fillPolygon(new int[]{x[0], x[3], x[7], x[4]}, new int[]{y[0], y[3], y[7], y[4]}, 4);

        // Draw the outline of the cube in blue color
        graphic.setColor(Color.ORANGE);
        graphic.drawPolygon(x, y, 4);
        graphic.setColor(Color.ORANGE);
        graphic.fillPolygon(new int[]{x[4], x[5], x[6], x[7]}, new int[]{y[4], y[5], y[6], y[7]}, 4);
        graphic.setColor(Color.ORANGE);
        for (int i = 0; i < 4; i++) {
            graphic.drawLine(x[i], y[i], x[i + 4], y[i + 4]);
        }
        graphic.setColor(Color.ORANGE);
        graphic.fillPolygon(new int[]{x[1], x[2], x[6], x[5]}, new int[]{y[1], y[2], y[6], y[5]}, 4);
        graphic.setColor(Color.ORANGE);
        graphic.fillPolygon(new int[]{x[0], x[3], x[7], x[4]}, new int[]{y[0], y[3], y[7], y[4]}, 4);

        // Draw the outline of the cube in white color
        graphic.setColor(Color.white);
        graphic.drawPolygon(x, y, 4);
        graphic.setColor(Color.white);
        graphic.drawPolygon(new int[]{x[4], x[5], x[6], x[7]}, new int[]{y[4], y[5], y[6], y[7]}, 4);
        graphic.setColor(Color.white);
        for (int i = 0; i < 4; i++) {
            graphic.drawLine(x[i], y[i], x[i + 4], y[i + 4]);
        }
        graphic.setColor(Color.white);
        graphic.drawPolygon(new int[]{x[1], x[2], x[6], x[5]}, new int[]{y[1], y[2], y[6], y[5]}, 4);
        graphic.setColor(Color.white);
        graphic.drawPolygon(new int[]{x[0], x[3], x[7], x[4]}, new int[]{y[0], y[3], y[7], y[4]}, 4);

        // Draw the outline of the cube in white color
        graphic.setColor(Color.white);
        graphic.drawPolygon(x, y, 4);
        graphic.setColor(Color.white);
        graphic.drawPolygon(new int[]{x[4], x[5], x[6], x[7]}, new int[]{y[4], y[5], y[6], y[7]}, 4);
        graphic.setColor(Color.white);
        for (int i = 0; i < 4; i++) {
            graphic.drawLine(x[i], y[i], x[i + 4], y[i + 4]);
        }
        graphic.setColor(Color.white);
        graphic.drawPolygon(new int[]{x[1], x[2], x[6], x[5]}, new int[]{y[1], y[2], y[6], y[5]}, 4);
        graphic.setColor(Color.white);
        graphic.drawPolygon(new int[]{x[0], x[3], x[7], x[4]}, new int[]{y[0], y[3], y[7], y[4]}, 4);

        rngSlider.enable(false);
        lblSave.hide();
    }//GEN-LAST:event_lbl3DMouseClicked

    private void rngSliderMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_rngSliderMouseWheelMoved
        int rotation = evt.getWheelRotation();
        int currentValue = rngSlider.getValue();

        // Adjust the slider value based on the touchpad gesture
        if (rotation > 0) {
            // Scrolling down
            rngSlider.setValue(currentValue - 1);
        } else {
            // Scrolling up
            rngSlider.setValue(currentValue + 1);
        }
    }//GEN-LAST:event_rngSliderMouseWheelMoved

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
            java.util.logging.Logger.getLogger(Rectangle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rectangle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rectangle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rectangle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rectangle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JComboBox<String> colorSelector;
    private java.awt.Canvas drawingBoard;
    private javax.swing.JLabel lbl2D;
    private javax.swing.JLabel lbl3D;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblDraw;
    private javax.swing.JLabel lblHeight;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblMainTitle;
    private javax.swing.JLabel lblMenu;
    private javax.swing.JLabel lblReset;
    private javax.swing.JLabel lblSave;
    private javax.swing.JLabel lblSliderShape;
    private javax.swing.JLabel lblWidth;
    private javax.swing.JSlider rngSlider;
    private javax.swing.JTextField txtHeight;
    private javax.swing.JTextField txtWidth;
    // End of variables declaration//GEN-END:variables
}
