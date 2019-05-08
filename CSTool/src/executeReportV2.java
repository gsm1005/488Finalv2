import java.util.HashMap;


import java.util.logging.Level;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.EngineConstants;
import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.birt.report.engine.api.HTMLActionHandler;

import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.HTMLServerImageHandler;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.PDFRenderOption;
public class executeReportV2 {
	public void executeReportHTML(int type) throws EngineException {
		// type 1 is flow report
		// type 2 is packet report 
		// tpye 3 is byte report
		 
	    IReportEngine engine = null;
	    EngineConfig config = null;
	 
	    try {
	        config = new EngineConfig();          
	        //config.setBIRTHome("C:\\birt-runtime-4.8/ReportEngine");
	        config.setLogConfig("C:\\Cyber Security", Level.FINEST);
	        Platform.startup(config);
	        final IReportEngineFactory FACTORY = (IReportEngineFactory) Platform
	            .createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
	        engine = FACTORY.createReportEngine(config);       
	 
	        // Open the report design
	        IReportRunnable design = null;
	        //design = engine.openReportDesign("C:\\birt-runtime-4.8\\WebViewerExample\\test.rptdesign"); 
	        if(type==1) {
	        design = engine.openReportDesign("C:\\Users\\garre\\eclipse-workspace\\CSTool\\rptdesign\\packets_Report.rptdesign");
	        }
	        else if(type ==2) {
	        	design = engine.openReportDesign("C:\\workspace\\1.rptdesign");
	        	}
	        else if(type==3) {
	        	
	        	design = engine.openReportDesign("C:\\workspace\\1.rptdesign");
	        	
	        }
	        IRunAndRenderTask task = engine.createRunAndRenderTask(design);       
	
	        final HTMLRenderOption HTML_OPTIONS = new HTMLRenderOption();       

	        HTML_OPTIONS.setOutputFileName("C:\\Users\\garre\\eclipse-workspace\\CSTool\\Reports\\CyberSecurityReport.html");
	        HTML_OPTIONS.setOutputFormat("html");
	         HTML_OPTIONS.setHtmlRtLFlag(false);
	         HTML_OPTIONS.setEmbeddable(false);
	        HTML_OPTIONS.setImageDirectory("C:\\Users\\garre\\eclipse-workspace\\CSTool\\Reports\\images");
	        task.setRenderOption(HTML_OPTIONS);
	        task.run();
	        task.close();
	        engine.destroy();
	        
	        
	      
	        
	        
	    } catch(final Exception EX) {
	        EX.printStackTrace();
	    } finally {
	       Platform.shutdown();
	    }
	}
	public void executeReportPDF(int type)throws EngineException {
		  IReportEngine engine = null;
		  EngineConfig config = null;
		 
		    try {
		        config = new EngineConfig();          
		        //config.setBIRTHome("C:\\birt-runtime-4.8/ReportEngine");
		        config.setLogConfig("C:\\Cyber Security", Level.FINEST);
		        Platform.startup(config);
		        final IReportEngineFactory FACTORY = (IReportEngineFactory) Platform
		            .createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
		        engine = FACTORY.createReportEngine(config);       
		 
		        // Open the report design
		        IReportRunnable design = null;
		        //design = engine.openReportDesign("C:\\birt-runtime-4.8\\WebViewerExample\\test.rptdesign"); 
		        if(type==1) {
			        design = engine.openReportDesign("C:\\Users\\garre\\eclipse-workspace\\CSTool\\rptdesign\\packets_Report.rptdesign");
			        }
			        else if(type ==2) {
			        	design = engine.openReportDesign("C:\\workspace\\1.rptdesign");
			        	}
			        else if(type==3) {
			        	
			        	design = engine.openReportDesign("C:\\workspace\\1.rptdesign");
			        	
			        }
		        IRunAndRenderTask task = engine.createRunAndRenderTask(design);       
		       // IRunAndRenderTask task2 = engine.createRunAndRenderTask(design);
		         //task.setParameterValue("Top Count", (new Integer(5)));
		         //task.validateParameters();
		 
		      
		        
		        final PDFRenderOption PDF_OPTIONS = new PDFRenderOption();
		         PDF_OPTIONS.setOutputFileName("C:\\Users\\garre\\eclipse-workspace\\CSTool\\Reports\\cyberSecurity.pdf");
		         PDF_OPTIONS.setOutputFormat("pdf");
		 
		        task.setRenderOption(PDF_OPTIONS);
		        task.run();
		       task.close();
		        
		     
		        engine.destroy();
		}
		    catch(final Exception EX) {
		        EX.printStackTrace();
		    } finally {
		       Platform.shutdown();
		    }
}
}
