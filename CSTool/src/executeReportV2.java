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
	public void executeReport() throws EngineException {
		 
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
	        design = engine.openReportDesign("C:\\birt\\workspace\\new_report.rptdesign"); 
	        IRunAndRenderTask task = engine.createRunAndRenderTask(design);       
	       // IRunAndRenderTask task2 = engine.createRunAndRenderTask(design);
	         //task.setParameterValue("Top Count", (new Integer(5)));
	         //t/ask.validateParameters();
	 
	        final HTMLRenderOption HTML_OPTIONS = new HTMLRenderOption();       
	        HTML_OPTIONS.setOutputFileName("C:\\Cyber Security/Parmdisp.html");
	        HTML_OPTIONS.setOutputFormat("html");
	         HTML_OPTIONS.setHtmlRtLFlag(false);
	         HTML_OPTIONS.setEmbeddable(false);
	        HTML_OPTIONS.setImageDirectory("C:\\test\\images");
	 
	         //PDFRenderOption PDF_OPTIONS = new PDFRenderOption();
	         //PDF_OPTIONS.setOutputFileName("C:\\Cyber Security/test.pdf");
	        // PDF_OPTIONS.setOutputFormat("pdf");
	 
	        //task2.setRenderOption(PDF_OPTIONS);
	        //task2.run();
	       // task2.close();
	        
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
}
