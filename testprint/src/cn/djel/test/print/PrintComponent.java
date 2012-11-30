package cn.djel.test.print;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

import javax.swing.JComponent;

public class PrintComponent extends JComponent implements Printable{
    public PrintComponent(){
    	
    }
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		drawPage(g2);
	}
/*	private void drawPage(Graphics2D g2) {
		// TODO Auto-generated method stub
		FontRenderContext context = g2.getFontRenderContext();//what is it use to do
		Font f = new Font("serif",Font.PLAIN,72);
		GeneralPath clipShape = new GeneralPath();// i don't know that why 
		
		TextLayout layout = new TextLayout("hello",f,context);
		AffineTransform transform = AffineTransform.getTranslateInstance(0, 72);
		Shape outline = layout.getOutline(transform);
		clipShape.append(outline, false);
		
		layout = new TextLayout("world",f,context);
		transform = AffineTransform.getTranslateInstance(0, 144);
		outline = layout.getOutline(transform);
		clipShape.append(outline, false);
		
		g2.draw(clipShape);
		g2.clip(clipShape);
		g2.drawString("nihao", 66, 55);
		
		final int NLINES = 50;
		Point2D p = new Point2D.Double(0,0);
		for(int i=0; i<NLINES; i++){
			double x=(2*getWidth()*i)/NLINES;
			double y =(2*getHeight()*(NLINES-1-i))/NLINES;
			Point2D q= new Point2D.Double(x,y);
			g2.draw(new Line2D.Double(p,q));
			
		}
		
	}*/
	
	private void drawPage(Graphics2D g2,String[] strs){
	
	       Font font = new Font("����", Font.PLAIN, 24);// ��������
	       g2.setFont(font);
	       // ��ӡ��ǰҳ�ı�
	       for(String str)
	       int printFontCount = printStr.length();// ��ӡ����
	       int printFontSize = font.getSize();// Font �İ�ֵ��С
	       float printX = 595 / 2; // �����ַ�����Xҳ������
	       float printY = 842 / 2; // �����ַ�����Yҳ������
	       float printMX = printX - (printFontCount * printFontSize / 2);// ��ӡ�����м�
	       float printMY = printY - printFontSize / 2;// ��ӡ�����м�
	       
	       
	       g2.drawString(printStr, printMX, printMY); // �����ӡÿһ���ı���ͬʱ��ֽ��λ
	       
	       
	       g2.drawString(printStr, printMX - printFontSize * printFontCount,
	               printMY + printFontSize); // �����ӡÿһ���ı���ͬʱ��ֽ��λ
	       
	       g2.drawString(printStr, printMX + printFontSize * printFontCount,
	               printMY + printFontSize); // �����ӡÿһ���ı���ͬʱ��ֽ��λ
	       
	       
	       g2.drawString(printStr, printMX, printMY + printFontSize * 2); // �����ӡÿһ���ı���ͬʱ��ֽ��λ
	       
	       
	       return Printable.PAGE_EXISTS; // ���ڴ�ӡҳʱ��������ӡ����
	}
	
	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
			throws PrinterException {
		// TODO Auto-generated method stub
		if(pageIndex >= 1){
			return Printable.NO_SUCH_PAGE;	
		}
		Graphics2D g2 = (Graphics2D)graphics;
		g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
		g2.draw(new Rectangle2D.Double(0,0,pageFormat.getImageableWidth(),pageFormat.getImageableHeight()));
		drawPage(g2);
	
		return Printable.PAGE_EXISTS;
	}

}
