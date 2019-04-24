
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.EngineConstants;
import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.birt.report.engine.api.HTMLActionHandler;
import org.eclipse.birt.report.engine.api.HTMLEmitterConfig;
import org.eclipse.birt.report.engine.api.HTMLRenderContext;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.HTMLServerImageHandler;
import org.eclipse.birt.report.engine.api.IRenderTask;
import org.eclipse.birt.report.engine.api.IReportDocument;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunTask;
import org.eclipse.birt.report.engine.api.TOCNode;
public class execute {

static void executeReport() throws EngineException
{

 IReportEngine engine=null;
 EngineConfig config = null;
 try{
  config = new EngineConfig( );
  config.setEngineHome( "C:\\ReportEngine" );
  config.setLogConfig(null, Level.FINE);

  Platform.startup( config );
  IReportEngineFactory factory = (IReportEngineFactory) Platform
  .createFactoryObject( IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY );
  engine = factory.createReportEngine( config );
  engine.changeLogLevel( Level.WARNING );

 }catch( Exception ex){
  ex.printStackTrace();
 }


 //Create the report engine
 HTMLEmitterConfig emitterConfig = new HTMLEmitterConfig( );
 emitterConfig.setActionHandler( new HTMLActionHandler( ) );
 HTMLServerImageHandler imageHandler = new HTMLServerImageHandler( );
 emitterConfig.setImageHandler( imageHandler );
 config.getEmitterConfigs( ).put( "html", emitterConfig ); //$NON-NLS-1$

 IReportRunnable design = null;

 design = engine.openReportDesign("C:\\workspace/workspace/firstReport.rptdesign"); 

 //Create task to run the report - use the task to execute and run the report,
 IRunTask task = engine.createRunTask(design); 

 //Create rptdocument
 task.run("C:\\workspace/workspace/firstReport.rptdesign");

 //Open rptdocument
 IReportDocument rptdoc = engine.openReportDocument("C:\\workspace/workspace/firstReport.rptdesign");
 //Get the top level TOC Node
 TOCNode tn = rptdoc.findTOC(null);
 List children = tn.getChildren();

 //Display top level children
 if( children != null && children.size() >0 )
 {
  for( int i = 0; i < children.size(); i++)
  {
   TOCNode child = ( TOCNode )children.get(i);
   System.out.println( "Node ID " + child.getNodeID());

   System.out.println( "Node Display String " + child.getDisplayString());
   System.out.println( "Node Bookmark " + child.getBookmark());
  }
 }

 //Create Render Task
 IRenderTask rtask = engine.createRenderTask(rptdoc);



 //Set Render context to handle url and image locataions
 HTMLRenderContext renderContext = new HTMLRenderContext();
 //Set the Base URL for all actions
 renderContext.setBaseURL("http://localhost/");
 //Tell the Engine to prepend all images with this URL - Note this requires using the HTMLServerImageHandler
 renderContext.setBaseImageURL("http://localhost/myimages");
 //Tell the Engine where to write the images to
 renderContext.setImageDirectory("C:/xampplite/htdocs/myimages");
 //Tell the Engine what image formats are supported.  Note you must have SVG in the string 
 //to render charts in SVG.
 renderContext.setSupportedImageFormats("JPG;PNG;BMP;SVG");
 HashMap<String, HTMLRenderContext> contextMap = new HashMap<String, HTMLRenderContext>();
 contextMap.put( EngineConstants.APPCONTEXT_HTML_RENDER_CONTEXT, renderContext );
 rtask.setAppContext( contextMap );


 //Set rendering options - such as file or stream output, 
 //output format, whether it is embeddable, etc
 HTMLRenderOption options = new HTMLRenderOption();

 //Remove HTML and Body tags
 //options.setEmbeddable(true);

 //Set ouptut location
 options.setOutputFileName("C:\\Cyber Security/output.html");

 //Set output format
 options.setOutputFormat("html");
 rtask.setRenderOption(options);

 //run the report and destroy the engine
 rtask.setPageNumber(1);
 //rtask.setPageRange("1-3,6");

 rtask.render();

 //render the report and destroy the engine
 //Note - If the program stays resident do not shutdown the Platform or the Engine  
 task.close();
 engine.shutdown();
 Platform.shutdown();
 System.out.println("Finished");
} 
/**
 * @param args
 */
public static void main(String[] args) {
 try
 {
  executeReport( );
 }
 catch ( Exception e )
 {
  e.printStackTrace();
 }
}

}