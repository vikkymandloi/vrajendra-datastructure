package sample;

 
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

class MyFrame extends Frame
implements ActionListener
{
	Image original, invert, erosion, boxed;
	int pixels[], pixelsBinary[], pixelsMorph[], pixelsBoxed[], pixelsBin[];

	int flag = 0, proflag = 0;
	int w,h;
	MediaTracker mt;
	Label phase;
	int perDone = 0;
	int longPro = 0;
	int p,q;
	int flag2 = 0; 
	MyFrame(String title)
	{
		super(title);
		setSize(800,600);
		setVisible(true);
		setLayout(new BorderLayout());
		addWindowListener(new MyWindowAdapter(this));
		mt = new MediaTracker(this);

		MenuBar mbar = new MenuBar();
		setMenuBar(mbar);
		Menu file = new Menu("File");
		MenuItem open = new MenuItem("Open");
		MenuItem exit = new MenuItem("Exit");
		file.add(open);
		file.add(exit);
		mbar.add(file);

		open.addActionListener(this);
		exit.addActionListener(this);

		phase = new Label("Load the Image File to be Detected for Faces");
		add(phase, BorderLayout.NORTH);

		Panel p = new Panel();

		Button proceed = new Button("Proceed");
		p.add(proceed, BorderLayout.SOUTH);
		proceed.addActionListener(this);

		add(p, BorderLayout.SOUTH);

	}
	public void actionPerformed(ActionEvent ae)
	{
		String control = ae.getActionCommand();
		if(control == "Open")
		{
			FileDialog fd = new FileDialog(this, "Open the Image File");
			fd.setVisible(true);
			flag = 1;
			proflag = 0;
			original = Toolkit.getDefaultToolkit().getImage(fd.getDirectory() + fd.getFile());
			try
			{
				mt.addImage(original, 1);
				mt.waitForID(1);
			}
			catch(InterruptedException e){}
			w = original.getWidth(null);
			h = original.getHeight(null);
			setSize(w,h);
			phase.setText("Phase-I: Loaded the Image");
			repaint();
		}
		else if(control == "Exit")
		{
			setVisible(false);
			dispose();
			System.exit(0);
		}
		else if(control == "Proceed")
		{
			if(proflag == 0)
			{
				proflag = 1;
				try
				{phaseII();
				}catch(Exception e){System.out.println(e);}
			}
			else if(proflag == 1)
			{
				proflag = 2;
				try
				{
					phaseIII();
				}catch(Exception e){System.out.println(e);}

			}
			else if(proflag == 2)
			{
				proflag = 3;
				try
				{
					phaseIV();
				}catch(Exception e){System.out.println(e);}

			}

		}

	}
	private void phaseII() throws InterruptedException
	{
		pixels = new int[w*h];
		try
		{
			PixelGrabber pg = new PixelGrabber(original, 0, 0, w, h, pixels, 0, w);
			pg.grabPixels();
		}catch(InterruptedException e){}
		int k = 0;
		pixelsBinary = new int[w*h];
		pixelsBin = new int[w*h];
		double avgcb = 0.0, avgcr = 0.0;
		double mincb=-40, mincr = 40.0;
		double maxcb=-5, maxcr = 0;
		for(int y = 0; y<h; y++)
		{
			for(int x=0; x<w; x++)
			{
				int p = pixels[k];
				int r = (p>>16) & 0xff;
				int g = (p>>8) & 0xff;
				int b =  p & 0xff;

				float value[] = new float[3];

				Color.RGBtoHSB(r,g,b,value);

				if(   ((value[0]>0 && value[0]<0.06)
						&& (value[1]>0.14 && value[1]<0.5))
						|| ((value[0]>0.06 && value[0]<0.08)
								&& (value[1]>0.16 && value[1]<0.7))
								|| ((value[0]>0.94 && value[0]<1)
										&& (value[1]>0.12 && value[1]<0.32))
										|| ((value[0]>0.97 && value[0]<1)
												&& (value[1]>0.12 && value[1]<0.54))
				)
					pixelsBinary[k] = pixelsBin[k] = 0xffffffff;
				else
					pixelsBinary[k] = pixelsBin[k] = 0xff000000;

				k++;
			}
		}
		flag = 2;                     
		invert = createImage(new MemoryImageSource(w,h,pixelsBinary,0,w));
		phase.setText("Phase-II: Face Segmentation");
		repaint();
	}

	private void phaseIII() throws InterruptedException
	{
		erode();
		dilate();
		erode();


		flag = 3;
		erosion = createImage(new MemoryImageSource(w,h,pixelsMorph,0,w));
		phase.setText("Phase III: Applying Morphological Processing(Erosion+Closing) to remove Noise");
		repaint();

	}
	private void erode()
	{
		pixelsMorph = new int[w*h];
		int k = 0;
		int count = 0;
		for(int y = 0; y<h; y++)
		{
			for(int x=0; x<w; x++)
			{
				if(pixelsBinary[k] == 0xffffffff)
				{
					pixelsMorph[k] = pixelsBinary[k];
					k++;
					continue;
				}

				count = 0;
				if(k <= ((w*h)-2))
				{if(pixelsBinary[k+1]==0xffffffff)
					count++;
				}
				if(k>1)
				{
					if(pixelsBinary[k-1]==0xffffffff)
						count++;
				}
				if((y>=2))
				{
					if(pixelsBinary[((y-2)*w)+x]==0xffffffff)
						count++;
				}
				else if(y==1)
				{
					if(pixelsBinary[x]==0xffffffff)
						count++;
				}
				if(y<h)
					if(pixelsBinary[(y*w)+x]==0xffffffff)
						count++;


				if(count>=2)
					pixelsMorph[k] = 0xffffffff;
				else
					pixelsMorph[k] = 0xff000000;
				k++;
			}
		}
		k = 0;
		for(int y = 0; y<h; y++)
		{
			for(int x=0; x< w; x++)
			{
				pixelsBinary[k] = pixelsMorph[k];
				k++;
			}
		}

	}

	private void dilate()
	{
		pixelsMorph = new int[w*h];
		int k = 0;
		int count = 0;
		for(int y = 0; y<h; y++)
		{
			for(int x=0; x<w; x++)
			{
				if(pixelsBinary[k] == 0xff000000)
				{
					pixelsMorph[k] = pixelsBinary[k];
					k++;
					continue;
				}

				count = 0;
				if(k <= ((w*h)-2))
				{if(pixelsBinary[k+1]==0xff000000)
					count++;
				}
				if(k>1)
				{
					if(pixelsBinary[k-1]==0xff000000)
						count++;
				}
				if((y>=2))
				{
					if(pixelsBinary[((y-2)*w)+x]==0xff000000)
						count++;
				}
				else if(y==1)
				{
					if(pixelsBinary[x]==0xff000000)
						count++;
				}
				if(y<h)
					if(pixelsBinary[(y*w)+x]==0xff000000)
						count++;


				if(count>=2)
					pixelsMorph[k] = 0xff000000;
				else
					pixelsMorph[k] = 0xffffffff;
				k++;
			}
		}

		k = 0;
		for(int y = 0; y<h; y++)
		{
			for(int x=0; x< w; x++)
			{
				pixelsBinary[k] = pixelsMorph[k];
				k++;
			}
		}

	}



	private void phaseIV() throws InterruptedException
	{            
		longPro++;
		repaint();

		pixelsBoxed = new int[w*h];
		int pixFace[] = new int[w*h];
		int foundXY[][] = new int[50][2];
		int foundScanW[] = new int[50];

		int faceNum = 0;
		int k =0;
		for(int y = 0; y<h; y++)
		{
			for(int x=0; x<w; x++)
			{
				pixelsBoxed[k] = pixels[k];
				pixFace[k] = 0;
				k++;
			}
		}

		int scanEnd = 40;
		int scanFlag = 0;
		int doneFlag = 0;

		for(int scanW = 100; scanW>scanEnd; scanW -= 5)
		{
			perDone += 10;
			longPro = 1;
			repaint();

			if(scanFlag == 1 && doneFlag == 0)
			{
				doneFlag = 1;
				scanEnd = scanW - 40;
			}
			int scanH;
			scanH = (int)(1.4 * scanW);

			int maxPerc = 0;
			for(int yBox = 0; yBox < (h-(scanH+1)); yBox += 5 )
			{
				label:
					for(int xBox = 0; xBox < (w-(scanW+1)); xBox += 5)
					{

						for(int contY = yBox; contY<(scanH+yBox); contY++)
						{
							for(int contX = xBox; contX<(scanW+xBox); contX++)
							{
								if(pixFace[(contY*w)+contX]==1)
									continue label;
							}

						}
						int white = 0;
						for(int scanY = yBox; scanY < (scanH+yBox); scanY++)
						{
							for(int scanX = xBox; scanX < (scanW+xBox); scanX++)
							{
								if(pixelsMorph[(scanY*w) + scanX] == 0xffffffff)
									white++;
							}
						}

						int perc = (white*100)/(scanW * scanH);

						if(perc > 75 && perc < 95)
						{
							foundXY[faceNum][0] = xBox;
							foundXY[faceNum][1] = yBox;
							foundScanW[faceNum] = scanW;
							faceNum++;
							for(int scanY = yBox; scanY < (scanH+yBox); scanY++)
							{
								for(int scanX = xBox; scanX < (scanW+xBox); scanX++)
								{
									pixFace[(scanY*w)+scanX] = 1;
								}
							}
							xBox += scanW;
							scanFlag = 1;
						}
					}
			}
		}

		int faceValid[] = new int[faceNum];
		int mergeFace[][] = new int[faceNum][2];
		int faces[][] = new int[faceNum][2];
		int facesW[] = new int[faceNum];
		int facesH[] = new int[faceNum];
		int mer = 0;
		for(int temp = 0; temp<faceNum; temp++)
			faceValid[temp] = 1;
		for(int ax = 0; ax<faceNum; ax++)
		{
			for(int bx = 0; bx<faceNum; bx++)
			{
				int temp = (int)(foundScanW[bx]*1.4);
				int mode = (foundXY[ax][1]>(foundXY[bx][1]+temp))?(foundXY[ax][1]-(foundXY[bx][1]+temp)):((foundXY[bx][1]+temp)-foundXY[ax][1]);

				if(mode>1)
				{
					continue;
				}
				int count = 0;
				for(int top=foundXY[ax][0]; top<(foundXY[ax][0]+foundScanW[ax]); top++)
				{
					for(int bottom=foundXY[bx][0]; bottom<(foundXY[bx][0]+foundScanW[bx]); bottom++)
					{
						if(top == bottom)
						{
							count++;
						}
					}
				}
				int perc = (count*100)/(foundScanW[ax]);
				if(perc > 20)
				{
					mergeFace[mer][0]=ax;
					mergeFace[mer][1]=bx;
					faceValid[ax] = 0;
					faceValid[bx] = 0;
					System.out.println("Removing: " +  ax + " and " + bx);
					mer++;
				}
			}
		}

		int numFaces = 0;
		for(int loop = 0; loop<faceNum; loop++)
		{
			if(faceValid[loop] == 0)
				continue;
			faces[numFaces][0] = foundXY[loop][0];
			faces[numFaces][1] = foundXY[loop][1];
			facesW[numFaces] = foundScanW[loop];
			facesH[numFaces] = (int)(foundScanW[loop]*1.4);

			numFaces++;
		}
		for(int loop = 0; loop<mer; loop++)
		{
			faces[numFaces][0] = foundXY[mergeFace[loop][1]][0];
			faces[numFaces][1] = foundXY[mergeFace[loop][1]][1];
			facesH[numFaces] = (int)(foundScanW[mergeFace[loop][0]]*1.4+foundScanW[mergeFace[loop][1]]*1.4);
			facesW[numFaces] = (int)(facesH[numFaces]/1.8);
			numFaces++;
		}

		for(int ix=0; ix<numFaces; ix++)
		{
			System.out.print(" "+faces[ix][0] +"  "+faces[ix][1]+" : ");
			int cntu;
			cntu = 0;
			for(int remY = faces[ix][1] + (int)(facesH[ix]*0.18); remY < faces[ix][1] + (int)(facesH[ix]*0.35); remY++)
			{
				for(int remX = faces[ix][0]; remX < (int)(facesW[ix] + faces[ix][0]); remX++)
				{
					if(pixelsBin[(remY*w)+remX] == 0xff000000)
						cntu++;
				}
			}
			System.out.println((cntu*100)/(facesW[ix]*facesH[ix]));
		}

		for(int temp = 0; temp<faceNum; temp++)
		{
			if(faceValid[temp] == 0)
				continue;

			int xBox, yBox, scanW, scanH;

			xBox = foundXY[temp][0];
			yBox = foundXY[temp][1];
			scanW = foundScanW[temp];
			scanH = (int) (1.4*scanW);

			int pix =  (yBox*w)+xBox;
			for(int draw=0; draw<scanW; draw++)
			{
				pixelsBoxed[pix++] = 0xffff0000;
			}
			pix = (yBox+scanH)*w+xBox;
			for(int draw=0; draw<scanW; draw++)
			{
				pixelsBoxed[pix++] = 0xffff0000;
			}
			for(int draw=0; draw<scanH; draw++)
			{ 
				pixelsBoxed[((yBox+draw)*w)+xBox] = 0xffff0000;
			}
			for(int draw=0; draw<scanH; draw++)
			{
				pixelsBoxed[((yBox+draw)*w)+(xBox+scanW)] = 0xffff0000;
			}
		}

		for(int temp = 0; temp<mer; temp++)
		{

			int ax, bx;
			ax = mergeFace[temp][0];
			bx = mergeFace[temp][1];

			System.out.println("Merging: " +  ax + " and " + bx);

			int xBox, yBox, scanW, scanH;

			xBox = foundXY[bx][0];
			yBox = foundXY[bx][1];
			scanH = (int)(foundScanW[ax]*1.4+foundScanW[bx]*1.4);
			scanW = (int)(scanH/1.8);

			int pix =  (yBox*w)+xBox;
			for(int draw=0; draw<scanW; draw++)
			{
				pixelsBoxed[pix++] = 0xffff0000;
			}
			pix = (yBox+scanH)*w+xBox;
			for(int draw=0; draw<scanW; draw++)
			{
				pixelsBoxed[pix++] = 0xffff0000;
			}
			for(int draw=0; draw<scanH; draw++)
			{ 
				pixelsBoxed[((yBox+draw)*w)+xBox] = 0xffff0000;
			}
			for(int draw=0; draw<scanH; draw++)
			{
				pixelsBoxed[((yBox+draw)*w)+(xBox+scanW)] = 0xffff0000;
			}

		}

		flag = 4;

		boxed = createImage(new MemoryImageSource(w, h, pixelsBoxed, 0, w));
		longPro = 0;
		repaint();
	}

	public void paint(Graphics g)
	{
		if(longPro == 1)
		{
			g.drawRect(310, 290, 180, 10);
			g.fillRect(310, 290, 30, 10);
			return;
		}

		if(flag==1)
			g.drawImage(original,0,0,this);
		else if(flag==2)
			g.drawImage(invert, 0, 0, this);
		else if(flag==3)
			g.drawImage(erosion, 0, 0, this);
		else if(flag==4)
			g.drawImage(boxed, 0, 0,this);

	}
}

class MyWindowAdapter extends WindowAdapter
{
	MyFrame f;
	MyWindowAdapter(MyFrame f)
	{
		this.f = f;
	}
	public void windowClosing(WindowEvent we)
	{
		f.setVisible(false);
		f.dispose();
	}
}

class Minor
{
	public static void main(String args[])
	{
		Frame f = new MyFrame("Face Detector -by Ekta and Aditi");
	}
}


