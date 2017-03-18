import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;

public class MyMouseAdapter extends MouseAdapter {
	private Random generator = new Random();
	private Color currentColor;
	public void mousePressed(MouseEvent e) {
		switch (e.getButton()) {
		case 1:	//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame) c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			myPanel.mouseDownGridX = myPanel.getGridX(x, y);
			myPanel.mouseDownGridY = myPanel.getGridY(x, y);
			myPanel.repaint();
			break;
		case 3:	//Right mouse button
			//Do nothing
			break;
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}
	public void mouseReleased(MouseEvent e) {
		switch (e.getButton()) {
		case 1:	//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame)c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			int gridX = myPanel.getGridX(x, y);
			int gridY = myPanel.getGridY(x, y);
			if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
				//Had pressed outside
				//Do nothing
			} else {
				if ((gridX == -1) || (gridY == -1)) {
					//Is releasing outside
					//Do nothing
				} else {
					if ((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)) {
						//Released the mouse button on a different cell where it was pressed
						//Do nothing
					} else {
						//Released the mouse button on the same cell where it was pressed
						if ((gridX == 0) || (gridY == 0)) {

							//On the left column and on the top row... do nothing
							if ((gridY>0) && (gridY<10)){
								for(int j = 1; j<10; j++) {
									myPanel.mouseDownGridX = j;
									myPanel.mouseDownGridY = gridY;
									currentColor = myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY];
									Color newColor = null;
									do{
										switch (generator.nextInt(5)) {
										case 0:
											newColor = Color.YELLOW;
											break;
										case 1:
											newColor = Color.MAGENTA;
											break;
										case 2:
											newColor = Color.BLACK;
											break;
										case 3:
											newColor = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
											break;
										case 4:
											newColor = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
											break;
										}
									} while( newColor.equals(currentColor) ); 
									currentColor = newColor;
									myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;
									myPanel.repaint();

								}


							}

							if((gridX>0) && (gridX<10)){
								for(int j = 1; j<10; j++) {
									myPanel.mouseDownGridX = gridX;
									myPanel.mouseDownGridY = j;
									currentColor = myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY];
									Color newColor = null;
									do{
										switch (generator.nextInt(5)) {
										case 0:
											newColor = Color.YELLOW;
											break;
										case 1:
											newColor = Color.MAGENTA;
											break;
										case 2:
											newColor = Color.BLACK;
											break;
										case 3:
											newColor = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
											break;
										case 4:
											newColor = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
											break;
										}
									} while( newColor.equals(currentColor) ); 
									currentColor = newColor;
									myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;
									myPanel.repaint();}

							}

							if ((gridX==0)&&(gridY==0)) {
								for(int j = 1; j<10; j++) {

									myPanel.mouseDownGridX = j;
									myPanel.mouseDownGridY = j;
									currentColor = myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY];
									Color newColor = null;
									do{
										switch (generator.nextInt(5)) {
										case 0:
											newColor = Color.YELLOW;
											break;
										case 1:
											newColor = Color.MAGENTA;
											break;
										case 2:
											newColor = Color.BLACK;
											break;
										case 3:
											newColor = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
											break;
										case 4:
											newColor = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
											break;
										}
									} while( newColor.equals(currentColor) ); 
									currentColor = newColor;
									myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;
									myPanel.repaint();

								}

							}

							if ((gridX == 0) && (gridY == 10)) {
								for (int j = 4; j < 7; j++) {
									for (int i = 4; i < 7; i++) {
										myPanel.mouseDownGridX = i;
										myPanel.mouseDownGridY = j;
										currentColor = myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY];
										Color newColor = null;
										do{
											switch (generator.nextInt(5)) {
											case 0:
												newColor = Color.YELLOW;
												break;
											case 1:
												newColor = Color.MAGENTA;
												break;
											case 2:
												newColor = Color.BLACK;
												break;
											case 3:
												newColor = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
												break;
											case 4:
												newColor = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
												break;
											}
										} while( newColor.equals(currentColor) ); 
										currentColor = newColor;
										myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;
										myPanel.repaint();


									}}}

						} else {
							//On the grid other than on the left column and on the top row:


							Color newColor = null;
							do{
								switch (generator.nextInt(5)) {
								case 0:
									newColor = Color.YELLOW;
									break;
								case 1:
									newColor = Color.MAGENTA;
									break;
								case 2:
									newColor = Color.BLACK;
									break;
								case 3:
									newColor = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
									break;
								case 4:
									newColor = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
									break;
								}
							} while( newColor.equals(currentColor) ); 
							currentColor = newColor;
							myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;
							myPanel.repaint();
						}

					}

				}

			}

			myPanel.repaint();

			break;

		case 3:
			Component a = e.getComponent();
			while (!(a instanceof JFrame)) {
				a = a.getParent();
				if (a == null) {
					return;
				}
			}
			JFrame myFrame2 = (JFrame)a;
			MyPanel myPanel2 = (MyPanel) myFrame2.getContentPane().getComponent(0);
			Insets myInsets2 = myFrame2.getInsets();
			int x2 = myInsets2.left;
			int y2 = myInsets2.top;
			e.translatePoint(-x2, -y2);
			int x3 = e.getX();
			int y3 = e.getY();
			myPanel2.x = x3;
			myPanel2.y = y3;
			int gridX2 = myPanel2.getGridX(x3, y3);
			int gridY2 = myPanel2.getGridY(x3, y3);
			Color newColor2 = null;
			if ((myPanel2.mouseDownGridX == -1) || (myPanel2.mouseDownGridY == -1)) {
			} else {
				if ((gridX2 == -1) || (gridY2 == -1)) {
					for (int i=1; i<10; i++){
						for (int j=1; j<11; j++){
							do{ switch (generator.nextInt(3)) {
							case 0:
								newColor2 = new Color(0xF9627D); //independence
								break;
							case 1:
								newColor2 = new Color(0x454B72); //dark raspberry
								break;
							case 2:
								newColor2 = new Color(0x9EE493); //granny smith apple 
								break;
							}
							} 
							while (myPanel2.colorArray[myPanel2.mouseDownGridX][myPanel2.mouseDownGridY].equals(newColor2));
							myPanel2.colorArray[i][j] = newColor2;
						}}
				} else {
					if ((myPanel2.mouseDownGridX != gridX2) || (myPanel2.mouseDownGridY != gridY2)) {

					} else {
						if ( gridX2 == 0 || gridY2 == 0) {
						}
					}
				}
				myPanel2.repaint();
				break;
			}
		default:    //Some other button (2 = Middle mouse button, etc.)

			//Do nothing

			break;

		}

	}

}