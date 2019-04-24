import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.graphbuilder.struc.LinkedList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class analyze {
	public static int totalFlows=0;
	public static int botNets=0;
	public static int normal=0;
	public static int backgroundFlows=0;
	public static double backgroundPackets=0;
	public static double normalPackets=0;
	public static double botNetsPackets=0;
	public static double totalPackets=0;
	public static double backgroundBytes=0;
	public static double normalBytes=0;
	public static double botNetsBytes=0;
	public static double totalBytes=0;
	
	
	
		analyze(){};
	
		void analyzeFlowTypes() throws IOException{ 
		
		int rowCount=1;
		int cellCount = 32;
		ArrayList<String> holdData = new ArrayList<String>();
		FileInputStream fis= new FileInputStream("C:\\Users/garre/eclipse-workspace/CSTool/src/ctu13-1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(rowCount);
		
		
		while(sheet.getRow(rowCount)!= null && sheet.getRow(rowCount).getCell(cellCount)!=null) {
			
			XSSFCell cell = row.getCell(cellCount);
			String value = cell.getStringCellValue();
		//XSSFCell cell = row.getCell(cellCount);
		row = sheet.getRow(rowCount=rowCount+1);
		value = cell.getStringCellValue();
		if(value.contains("Background")) {
			backgroundFlows++;
			
		}
		else if(value.contains("Botnet")) {
			botNets++;
		}
		
		
		else {
			normal++;
		}
		totalFlows++;
			
		}
		//backgroundFlowsPerc=(backgroundFlows/totalFlows);
		//normalPerc=(normal/totalFlows)*100;
		//botNetsPerc=(botNets/totalFlows)*100;
		
		
		//System.out.println(value);
		
		System.out.println("Flows to or from background "+backgroundFlows);
		System.out.println("Flows from Botnets "+botNets);
		System.out.println("Flows from foreground "+normal);
		int totesCheck = backgroundFlows+normal+botNets;
		System.out.println("Total Flows sent and Recieved: "+totalFlows);
		
	}
		
		
		
		
		
		//-----------------------------------------------Bytes calculated-------------------------------------------------------------------------//		
		 void analyzePacketsPerFlow() throws IOException{ 
			
			int rowCount=1;
			int cellCount = 32;
			ArrayList<String> holdData = new ArrayList<String>();
			FileInputStream fis= new FileInputStream("C:\\Users/garre/eclipse-workspace/CSTool/src/ctu13-1.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow row = sheet.getRow(rowCount);
			
			
			while(sheet.getRow(rowCount)!= null && sheet.getRow(rowCount).getCell(cellCount)!=null) {
				
				XSSFCell cell = row.getCell(cellCount);
				String value = cell.getStringCellValue();
				double temp;
			//XSSFCell cell = row.getCell(cellCount);
			value = cell.getStringCellValue();
			if(value.contains("Background")) {
				XSSFCell Bytecell = row.getCell(26);
				temp = Bytecell.getNumericCellValue();
				//int temp = Integer.parseInt(byteValue);
				backgroundPackets=backgroundPackets+temp;
				totalPackets=totalPackets+temp;
				
			}
			else if(value.contains("Botnet")) {
				XSSFCell Bytecell = row.getCell(26);
				temp = Bytecell.getNumericCellValue();
				//int temp = Integer.parseInt(byteValue);
				botNetsPackets=botNetsPackets+temp;
				totalPackets=totalPackets+temp;
			}
			
			
			else {
				XSSFCell Bytecell = row.getCell(26);
				temp = Bytecell.getNumericCellValue();
				//int temp = Integer.parseInt(byteValue);;
				normalPackets=normalPackets+temp;
				totalPackets=totalPackets+temp;
				
			}
			row = sheet.getRow(rowCount=rowCount+1);
			
				
			}
			//backgroundFlowsPerc=(backgroundFlows/totalFlows);
			//normalPerc=(normal/totalFlows)*100;
			//botNetsPerc=(botNets/totalFlows)*100;
			
			
			//System.out.println(value);
			
			System.out.println("Flows to or from background "+backgroundPackets);
			System.out.println("Flows from Botnets "+botNetsPackets);
			System.out.println("Flows from foreground "+normalPackets);
			int totesCheck = backgroundFlows+normal+botNets;
			System.out.println("Total Flows sent and Recieved: "+totalFlows);
			
		}
		//-----------------------------------------------Bytes calculated-------------------------------------------------------------------------//		
		 void analyzeBytesPerFlow() throws IOException{ 
			
			int rowCount=1;
			int cellCount = 32;
			ArrayList<String> holdData = new ArrayList<String>();
			FileInputStream fis= new FileInputStream("C:\\Users/garre/eclipse-workspace/CSTool/src/ctu13-1.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow row = sheet.getRow(rowCount);
			
			
			while(sheet.getRow(rowCount)!= null && sheet.getRow(rowCount).getCell(cellCount)!=null) {
				
				XSSFCell cell = row.getCell(cellCount);
				String value = cell.getStringCellValue();
				double temp;
			//XSSFCell cell = row.getCell(cellCount);
			value = cell.getStringCellValue();
			if(value.contains("Background")) {
				XSSFCell Bytecell = row.getCell(26);
				temp = Bytecell.getNumericCellValue();
				//int temp = Integer.parseInt(byteValue);
				backgroundBytes=backgroundBytes+temp;
				totalBytes=totalBytes+temp;
				
			}
			else if(value.contains("Botnet")) {
				XSSFCell Bytecell = row.getCell(27);
				temp = Bytecell.getNumericCellValue();
				//int temp = Integer.parseInt(byteValue);
				botNetsBytes=botNetsBytes+temp;
				totalBytes=totalBytes+temp;
			}
			
			
			else {
				XSSFCell Bytecell = row.getCell(27);
				temp = Bytecell.getNumericCellValue();
				//int temp = Integer.parseInt(byteValue);;
				normalBytes=normalPackets+temp;
				totalBytes=totalBytes+temp;
				
			}
			row = sheet.getRow(rowCount=rowCount+1);
			
				
			}
			//backgroundFlowsPerc=(backgroundFlows/totalFlows);
			//normalPerc=(normal/totalFlows)*100;
			//botNetsPerc=(botNets/totalFlows)*100;
			
			
			//System.out.println(value);
			
			System.out.println("Flows to or from background "+backgroundPackets);
			System.out.println("Flows from Botnets "+botNetsPackets);
			System.out.println("Flows from foreground "+normalPackets);
			int totesCheck = backgroundFlows+normal+botNets;
			System.out.println("Total Flows sent and Recieved: "+totalFlows);
			
		}
		
		
		}
	



