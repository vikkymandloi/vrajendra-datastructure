package sample;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

class Histo extends Frame implements ActionListener
{
	Image img;
	MediaTracker mt;
	int flag = 0;
	int pixels[];
	int w=0, hi =0;
	FileDialog fd;
	Histo()
	{
		super("Histogram Generator");
		setSize(800, 650);
		setVisible(true);
		addWindowListener(new MyWindowAdapterH(this));
		setLayout(new BorderLayout());
		mt = new MediaTracker(this);

		Panel p = new Panel();
		p.setSize(800, 20);
		p.setLayout(new FlowLayout());
		add(p, BorderLayout.SOUTH);
		Label l =new Label();
		Button load = new Button("Load Image");
		p.add(load);
		load.addActionListener(this);
		p.add(l);
		repaint();
	}
	public void actionPerformed(ActionEvent ae)
	{
		flag = 1;
		String str = ae.getActionCommand();
		if(str == "Load Image")
		{
			fd = new FileDialog(this, "Load the Image");
			fd.setVisible(true);
			repaint();
		}
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.cyan);
		for(int hor = 0; hor <= 50; hor++)
		{
			g.drawLine(hor*16, 0, hor*16, 600);
		}
		for(int ver = 0; ver <= 50; ver++)
		{
			g.drawLine(0, ver*12, 800, ver*12);
		}

		g.setColor(Color.magenta);
		for(int hor = 0; hor <= 10; hor++)
		{
			g.drawLine(hor*80, 0, hor*80, 600);
		}
		for(int ver = 0; ver <= 10; ver++)
		{
			g.drawLine(0, ver*60, 800, ver*60);
		}

		g.setColor(Color.black);
		g.drawLine(0,600,800,600);
		g.drawLine(0,0,0,600);

		if(flag == 1)
		{
			for(int fi = 1; fi<100; fi++)
			{img = Toolkit.getDefaultToolkit().getImage(fd.getDirectory()+"Skin (" + fi+ ").jpg");

			System.out.println(fd.getDirectory()+"Skin (" + fi + ").jpeg");
			try
			{
				mt.addImage(img, 1);
				mt.waitForID(1);
			}catch(InterruptedException e){}
			w = img.getWidth(null);
			hi = img.getHeight(null);
			pixels = new int[w*hi];
			try
			{
				PixelGrabber pg = new PixelGrabber(img, 0 , 0, w, hi, pixels, 0, w);
				pg.grabPixels();
			}catch(Exception e){System.out.println(":P");}

			double cb = 0, cr = 0, hue = 0, sat = 0;
			int k =0;
			for(int y=0; y<hi; y++)
			{
				for(int x=0; x<w; x++)
				{
					int pix = pixels[k];
					int r = (pix>>16) & 0xff;
					int gr = (pix>>8) & 0xff;
					int b = (pix) & 0xff;

					float val[] = new float[3];
					Color.RGBtoHSB(r, gr, b, val);
					hue = val[0];
					sat = val[1];

					int xpos = (int)(hue*800);
					int ypos = 600 - (int)(sat*600);

					g.setColor(Color.red);
					g.drawString(".", xpos, ypos);
					k++;
				}
			}
			}
		}
	}

}
class MyWindowAdapterH extends WindowAdapter
{
	Histo h;
	MyWindowAdapterH(Histo h)
	{
		this.h = h;
	}
	public void windowClosing(WindowEvent we)
	{
		h.setVisible(false);
		h.dispose();
	}
}
class Histogram
{
	public static void main(String args[])
	{
		Frame f = new Histo();
	}
} 
