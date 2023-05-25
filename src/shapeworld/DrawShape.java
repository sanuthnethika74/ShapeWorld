
package shapeworld;

// SysImports
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Ravindu Malith 
 */
public class DrawShape extends javax.swing.JFrame {

    // SysVariables
    private Graphics2D graphic;
    private Graphics2D pencil;
    private String c;
    private String shapeName;
    private double scale = 1.0d;
    private int prevX, prevY;
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

    // Clear Canvas
    private void resetCanvas() {
        try {
            scale = Double.valueOf(rngSlider.getValue()) / 10;
            graphic.clearRect(0, 0, drawingBoardWidth, drawingBoardHeight);
            pencil.clearRect(0, 0, drawingBoardWidth, drawingBoardHeight);
            lblGifPreview.setIcon(Default_gif);
            shapeName = "";
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
                    pencil.setColor(Color.RED);
                    break;
                case "BLACK":
                    pencil.setColor(Color.BLACK);
                    break;
                case "GREEN":
                    pencil.setColor(Color.GREEN);
                    break;
                case "BLUE":
                    pencil.setColor(Color.BLUE);
                    break;
                case "PINK":
                    pencil.setColor(Color.PINK);
                    break;
                case "ORANGE":
                    pencil.setColor(Color.ORANGE);
                    break;
                default:
                    pencil.setColor(Color.BLACK);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Somthing went Wrong " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Draw Shape Handler
    private void drawShapeHandler() {
        if (shapeName != "") {
            switch (shapeName) {
                case "Triangle":
                    // Call Draw Triangle
                    drawTriangle(150);
                    break;
                case "Circle":
                    // Call Draw Circle
                    drawCircle(80);
                    break;
                case "Square":
                    // Call Draw Square 
                    drawSquare(150);
                    break;
                case "Rectangle":
                    // Call Draw Rectangle
                    drawRectangle(150, 100);
                    break;
                case "Xexagon":
                    // Call Draw Xexagon
                    drawXexagon(75);
                    break;
            }
        }
    }

    // Draw Square
    private void drawSquare(int width) {

        // Call Clear Canvas
        resetCanvas();

        try {

            // Set Temp Size
            tempW = Double.valueOf(width) * scale;
            tempH = Double.valueOf(width) * scale;

            // Set Shape Size
            shapeWidth = (int) tempW;
            shapeHeight = (int) tempH;

            // Set Shape X Y
            shapeX = drawingBoardCenterX - shapeWidth / 2;
            shapeY = drawingBoardCenterY - shapeHeight / 2;

            // Set Selected Color
            graphic.setColor(Color.gray);

            // Set Stroke
            float[] dash = {10.0f};
            graphic.setStroke(new BasicStroke(5.0f, BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));

            // Draw Shape
            graphic.drawRect(shapeX, shapeY, shapeWidth, shapeHeight);

            lblGifPreview.setIcon(Square_gif);

            shapeName = "Square";

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Somthing went Wrong " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Draw Rectangle
    private void drawRectangle(int width, int height) {

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
            graphic.setColor(Color.gray);

            // Set Stroke
            float[] dash = {10.0f};
            graphic.setStroke(new BasicStroke(5.0f, BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));

            // Draw Shape
            graphic.drawRect(shapeX, shapeY, shapeWidth, shapeHeight);

            lblGifPreview.setIcon(Rectangle_gif);

            shapeName = "Rectangle";

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Somthing went Wrong " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Draw Triangle
    private void drawTriangle(int width) {

        // Call Clear Canvas
        resetCanvas();

        try {

            // Set Temp Size
            tempW = Double.valueOf(width) * scale;

            // Set Shape Size
            shapeWidth = (int) tempW;

            int x1 = (drawingBoardWidth - (int) shapeWidth) / 2;
            int y1 = drawingBoardHeight - 50;
            int x2 = x1 + (int) shapeWidth;
            int y2 = y1;
            int x3 = x1 + (int) (shapeWidth / 2);
            int y3 = y1 - (int) (Math.sqrt(3) * shapeWidth / 2);

            // Draw the triangle
            int[] xPoints = {x1, x2, x3};
            int[] yPoints = {y1, y2, y3};

            // Set Selected Color
            graphic.setColor(Color.gray);

            // Set Stroke
            float[] dash = {10.0f};
            graphic.setStroke(new BasicStroke(5.0f, BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));

            // Draw Shape
            graphic.drawPolygon(xPoints, yPoints, 3);

            lblGifPreview.setIcon(Triangle_gif);

            shapeName = "Triangle";

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Somthing went Wrong " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Draw Circle
    private void drawCircle(int radius) {

        // Call Clear Canvas
        resetCanvas();

        try {

            // Set Temp Size
            tempR = Double.valueOf(radius) * scale;

            // Set Shape Size
            shapeRadius = (int) tempR;

            // Set Shape X Y
            int x = drawingBoardCenterX - (int) shapeRadius;
            int y = drawingBoardCenterY - (int) shapeRadius;

            // Set Selected Color
            graphic.setColor(Color.gray);

            // Set Stroke
            float[] dash = {10.0f};
            graphic.setStroke(new BasicStroke(5.0f, BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));

            // Draw Shape
            graphic.drawOval(x, y, (int) (shapeRadius * 2), (int) (shapeRadius * 2));

            lblGifPreview.setIcon(Circle_gif);

            shapeName = "Circle";

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Somthing went Wrong " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Draw Xexagon
    private void drawXexagon(int radius) {

        // Call Clear Canvas
        resetCanvas();

        try {

            // Set Temp Size
            tempR = Double.valueOf(radius) * scale;

            // Set Shape Size
            shapeRadius = (int) tempR;

            // Set Shape X Y
            int[] xPoints = calXexagonXPoints(drawingBoardCenterX, shapeRadius);
            int[] yPoints = calXexagonYPoints(drawingBoardCenterY, shapeRadius);

            // Set Selected Color
            graphic.setColor(Color.gray);

            // Set Stroke
            float[] dash = {10.0f};
            graphic.setStroke(new BasicStroke(5.0f, BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));

            // Draw Shape
            graphic.drawPolygon(xPoints, yPoints, 6);

            lblGifPreview.setIcon(Hexagon_gif);

            shapeName = "Xexagon";

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Somthing went Wrong " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Calculate Xexagon X Points
    private int[] calXexagonXPoints(int centerX, double radius) {
        int[] xPoints = new int[6];
        for (int i = 0; i < 6; i++) {
            double angle = 2 * Math.PI / 6 * i;
            xPoints[i] = (int) (centerX + radius * Math.cos(angle));
        }
        return xPoints;
    }

    // Calculate Xexagon Y Points
    private int[] calXexagonYPoints(int centerY, double radius) {
        int[] yPoints = new int[6];
        for (int i = 0; i < 6; i++) {
            double angle = 2 * Math.PI / 6 * i;
            yPoints[i] = (int) (centerY + radius * Math.sin(angle));
        }
        return yPoints;
    }

    // Draw Lines 
    private void drawLines(java.awt.event.MouseEvent evt) {
        pencil.setStroke(new BasicStroke(5));
        int currX = evt.getX();
        int currY = evt.getY();
        pencil.drawLine(prevX, prevY, currX, currY);
        prevX = currX;
        prevY = currY;
    }

    //Square ICON Get
    ImageIcon Square_img = new javax.swing.ImageIcon(getClass().getResource("/Image/IconSquare-mini.png"));
    ImageIcon Square_hover_img = new javax.swing.ImageIcon(getClass().getResource("/Image/IconSquare-hover-mini.png"));
    //Circle ICON Get
    ImageIcon Circle_img = new javax.swing.ImageIcon(getClass().getResource("/Image/IconCircle-mini.png"));
    ImageIcon Circle_hover_img = new javax.swing.ImageIcon(getClass().getResource("/Image/IconCircle-hover-mini.png"));
    //Hexagon ICON Get
    ImageIcon Hexagon_img = new javax.swing.ImageIcon(getClass().getResource("/Image/IconHexagon-mini.png"));
    ImageIcon Hexagon_hover_img = new javax.swing.ImageIcon(getClass().getResource("/Image/IconHexagon-hoverr-mini.png"));
    //Rectangle ICON get
    ImageIcon Rectangle_img = new javax.swing.ImageIcon(getClass().getResource("/Image/IconRectangle-mini.png"));
    ImageIcon Rectangle_hover_img = new javax.swing.ImageIcon(getClass().getResource("/Image/IconRectangle-hover-mini.png"));
    //Triangle ICON Get
    ImageIcon Triangle_img = new javax.swing.ImageIcon(getClass().getResource("/Image/IconTriangle-mini.png"));
    ImageIcon Triangle_hover_img = new javax.swing.ImageIcon(getClass().getResource("/Image/IconTriangle-hover-mini.png"));
    //Home ICOn Get
    ImageIcon Home_img = new javax.swing.ImageIcon(getClass().getResource("/Image/IconHome-mini.png"));
    ImageIcon Home_hover_img = new javax.swing.ImageIcon(getClass().getResource("/Image/IconHome-hover-mini.png"));
    //Reset
    ImageIcon Reset_img = new javax.swing.ImageIcon(getClass().getResource("/Image/IconReset.png"));
    ImageIcon Reset_hover_img = new javax.swing.ImageIcon(getClass().getResource("/Image/IconReset-hover.png"));
    //play
    ImageIcon Play_img = new javax.swing.ImageIcon(getClass().getResource("/Image/IconPlay.png"));
    ImageIcon Play_hover_img = new javax.swing.ImageIcon(getClass().getResource("/Image/IconPlay-hover.png"));

    //Default
    ImageIcon Default_gif = new javax.swing.ImageIcon(getClass().getResource("/Image/PanelText.jpg"));
    //Circle
    ImageIcon Circle_gif = new javax.swing.ImageIcon(getClass().getResource("/Gif/Circle.gif"));
    //Hexagon
    ImageIcon Hexagon_gif = new javax.swing.ImageIcon(getClass().getResource("/Gif/Hex.gif"));
    //Rectangle
    ImageIcon Rectangle_gif = new javax.swing.ImageIcon(getClass().getResource("/Gif/Rectangle.gif"));
    //Square
    ImageIcon Square_gif = new javax.swing.ImageIcon(getClass().getResource("/Gif/Square.gif"));
    //Triangle
    ImageIcon Triangle_gif = new javax.swing.ImageIcon(getClass().getResource("/Gif/Triangle.gif"));

    public DrawShape() {
        initComponents();
        // Create Graphic Object
        graphic = (Graphics2D) drawingBoard.getGraphics();

        //Paint on DrawingBoard
        drawingBoard.paintAll(graphic);

        // Create Pencil Object
        pencil = (Graphics2D) drawingBoard.getGraphics();

        //Paint on DrawingBoard
        drawingBoard.paintAll(pencil);

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

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTriangle = new javax.swing.JLabel();
        lblcircle = new javax.swing.JLabel();
        lblSquare = new javax.swing.JLabel();
        lblRectangle = new javax.swing.JLabel();
        lblHexagon = new javax.swing.JLabel();
        drawingBoard = new java.awt.Canvas();
        lblGifPreview = new javax.swing.JLabel();
        colorSelector = new javax.swing.JComboBox<>();
        lblHome = new javax.swing.JLabel();
        lblReset = new javax.swing.JLabel();
        rngSlider = new javax.swing.JSlider();
        lblSliderShape = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setPreferredSize(new java.awt.Dimension(1111, 575));
        setResizable(false);
        setSize(new java.awt.Dimension(1111, 575));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTriangle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/IconTriangle-mini.png"))); // NOI18N
        lblTriangle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTriangleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblTriangleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblTriangleMouseExited(evt);
            }
        });
        getContentPane().add(lblTriangle, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 120, 120));

        lblcircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/IconCircle-mini.png"))); // NOI18N
        lblcircle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblcircleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblcircleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblcircleMouseExited(evt);
            }
        });
        getContentPane().add(lblcircle, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        lblSquare.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/IconSquare-mini.png"))); // NOI18N
        lblSquare.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSquareMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSquareMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSquareMouseExited(evt);
            }
        });
        getContentPane().add(lblSquare, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        lblRectangle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/IconRectangle-mini.png"))); // NOI18N
        lblRectangle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRectangleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblRectangleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRectangleMouseExited(evt);
            }
        });
        getContentPane().add(lblRectangle, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, -1, -1));

        lblHexagon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/IconHexagon-mini.png"))); // NOI18N
        lblHexagon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHexagonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblHexagonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblHexagonMouseExited(evt);
            }
        });
        getContentPane().add(lblHexagon, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, -1, -1));

        drawingBoard.setBackground(new java.awt.Color(255, 255, 255));
        drawingBoard.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        drawingBoard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                drawingBoardMousePressed(evt);
            }
        });
        drawingBoard.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                drawingBoardMouseDragged(evt);
            }
        });
        getContentPane().add(drawingBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 530, 330));

        lblGifPreview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/PanelText.jpg"))); // NOI18N
        getContentPane().add(lblGifPreview, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 510, 330));

        colorSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Red", "Black", "Green", "Blue", "Orange", "Pink" }));
        colorSelector.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                colorSelectorItemStateChanged(evt);
            }
        });
        getContentPane().add(colorSelector, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, 100, 30));

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
        getContentPane().add(lblHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, 80));

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
        getContentPane().add(lblReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 470, -1, -1));

        rngSlider.setMaximum(20);
        rngSlider.setMinimum(10);
        rngSlider.setValue(10);
        rngSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rngSliderStateChanged(evt);
            }
        });
        getContentPane().add(rngSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 500, -1, -1));

        lblSliderShape.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/slider shape.png"))); // NOI18N
        getContentPane().add(lblSliderShape, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 480, -1, 60));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/PanelBackground.png"))); // NOI18N
        Background.setText("jLabel2");
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblTriangleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTriangleMouseEntered
        lblTriangle.setIcon(Triangle_hover_img);
    }//GEN-LAST:event_lblTriangleMouseEntered

    private void lblTriangleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTriangleMouseExited
        lblTriangle.setIcon(Triangle_img);
    }//GEN-LAST:event_lblTriangleMouseExited

    private void lblSquareMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSquareMouseEntered
        lblSquare.setIcon(Square_hover_img);
    }//GEN-LAST:event_lblSquareMouseEntered

    private void lblSquareMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSquareMouseExited
        lblSquare.setIcon(Square_img);
    }//GEN-LAST:event_lblSquareMouseExited

    private void lblcircleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcircleMouseEntered
        lblcircle.setIcon(Circle_hover_img);
    }//GEN-LAST:event_lblcircleMouseEntered

    private void lblcircleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcircleMouseExited
        lblcircle.setIcon(Circle_img);
    }//GEN-LAST:event_lblcircleMouseExited

    private void lblRectangleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRectangleMouseEntered
        lblRectangle.setIcon(Rectangle_hover_img);
    }//GEN-LAST:event_lblRectangleMouseEntered

    private void lblRectangleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRectangleMouseExited
        lblRectangle.setIcon(Rectangle_img);
    }//GEN-LAST:event_lblRectangleMouseExited

    private void lblHexagonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHexagonMouseEntered
        lblHexagon.setIcon(Hexagon_hover_img);
    }//GEN-LAST:event_lblHexagonMouseEntered

    private void lblHexagonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHexagonMouseExited
        lblHexagon.setIcon(Hexagon_img);
    }//GEN-LAST:event_lblHexagonMouseExited

    private void lblHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseClicked
        Home H = new Home();
        H.show();
        this.hide();
    }//GEN-LAST:event_lblHomeMouseClicked

    private void lblHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseEntered
        lblHome.setIcon(Home_hover_img);
    }//GEN-LAST:event_lblHomeMouseEntered

    private void lblHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseExited
        lblHome.setIcon(Home_img);
    }//GEN-LAST:event_lblHomeMouseExited

    private void lblTriangleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTriangleMouseClicked
        // Call Draw Triangle
        drawTriangle(150);
    }//GEN-LAST:event_lblTriangleMouseClicked

    private void lblSquareMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSquareMouseClicked
        // Call Draw Square 
        drawSquare(150);
    }//GEN-LAST:event_lblSquareMouseClicked

    private void drawingBoardMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawingBoardMousePressed
        prevX = evt.getX();
        prevY = evt.getY();
    }//GEN-LAST:event_drawingBoardMousePressed

    private void drawingBoardMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawingBoardMouseDragged
        // Call Draw Lines 
        drawLines(evt);
    }//GEN-LAST:event_drawingBoardMouseDragged

    private void lblResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResetMouseClicked
        // Call Clear Canvas
        resetCanvas();
    }//GEN-LAST:event_lblResetMouseClicked

    private void lblResetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResetMouseEntered
        lblReset.setIcon(Reset_hover_img);
    }//GEN-LAST:event_lblResetMouseEntered

    private void lblResetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResetMouseExited
        lblReset.setIcon(Reset_img);
    }//GEN-LAST:event_lblResetMouseExited

    private void lblcircleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcircleMouseClicked
        // Call Draw Circle
        drawCircle(80);
    }//GEN-LAST:event_lblcircleMouseClicked

    private void lblRectangleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRectangleMouseClicked
        // Call Draw Rectangle
        drawRectangle(150, 100);
    }//GEN-LAST:event_lblRectangleMouseClicked

    private void lblHexagonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHexagonMouseClicked
        // Call Draw Xexagon
        drawXexagon(75);
    }//GEN-LAST:event_lblHexagonMouseClicked

    private void rngSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rngSliderStateChanged
        // Call Draw Shape Handler
        drawShapeHandler();

    }//GEN-LAST:event_rngSliderStateChanged

    private void colorSelectorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_colorSelectorItemStateChanged
        // Call Set Selected Color
        setSelectedColor();
    }//GEN-LAST:event_colorSelectorItemStateChanged

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
            java.util.logging.Logger.getLogger(DrawShape.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DrawShape.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DrawShape.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DrawShape.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DrawShape().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JComboBox<String> colorSelector;
    private java.awt.Canvas drawingBoard;
    private javax.swing.JLabel lblGifPreview;
    private javax.swing.JLabel lblHexagon;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblRectangle;
    private javax.swing.JLabel lblReset;
    private javax.swing.JLabel lblSliderShape;
    private javax.swing.JLabel lblSquare;
    private javax.swing.JLabel lblTriangle;
    private javax.swing.JLabel lblcircle;
    private javax.swing.JSlider rngSlider;
    // End of variables declaration//GEN-END:variables
}
