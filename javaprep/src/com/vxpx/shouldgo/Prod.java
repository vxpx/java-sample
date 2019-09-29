package ctl.aprilia;
 import java.util.Calendar;
 import java.util.Date;
 import java.util.HashMap;
 import java.util.Map;
 import com.centurylink.mdw.java.JavaExecutionException;
 import com.centurylink.mdw.java.JavaExecutor;
 import com.centurylink.mdw.java.MdwJavaException;
 import com.centurylink.mdw.model.workflow.ActivityRuntimeContext;
 import ctl.aprilia.model.testing.CodResponse;
 import ctl.aprilia.model.testing.E2EDecisionResponseHelper;
 import ctl.aprilia.model.testing.SiteSurveyValidation; /**  * Dynamic Java executor.  */
 public class SettingAttributes_A5 implements JavaExecutor {
     public void initialize(ActivityRuntimeContext context) throws MdwJavaException { 
    	 // TODO Auto-generated method stub 
    	 
     } 
         public Object execute(Map < String, Object > variables) throws JavaExecutionException {
             String salesOrderId = (String) variables.get("saleOrderId ");
             String sdpOrderId = (String) variables.get("sdpOrderId ");
             String entryCondition = (String) variables.get("entryCondition ");
             String companyName = null;
             Date clearPathETA = null;
             String content = null;
             String corecomments = null;
             @SuppressWarnings("unchecked ") HashMap < String, String > siteResponse = (HashMap < String, String > ) variables.get("siteSurveyParsedResponse ");
             String dsrID = (String) siteResponse.get("DSRID ");
             if (siteResponse.containsKey("CLEAR_PATH_ETA ")) clearPathETA = new Date(Long.parseLong(siteResponse.get("CLEAR_PATH_ETA ")));
             Calendar cal = Calendar.getInstance();
             cal.setTime(clearPathETA);
             if (variables.get("decisionResponse ") != null) {
                 E2EDecisionResponseHelper e2eDecisionResponseHelper = (E2EDecisionResponseHelper) variables.get("decisionResponse ");
                 CodResponse codResponse = e2eDecisionResponseHelper.getCodResponse();
                 if (codResponse != null) {
                     companyName = codResponse.getCompanyName();
                 }
             }
             if (entryCondition.equalsIgnoreCase("mailtoRI ")) {
                 if (companyName != null) {
                     content = "Fiber+ Aprilia order for Customer:  " + companyName + "   ";
                 }
                 content = content + " CORE Sales Order # : " + salesOrderId + " will be placed in a ORDS state until we get confirmation that the Customer has completed the Clear Path work    ";
                 content = content + "Order request # : " + sdpOrderId + "   ";
                 if (clearPathETA != null) {
                     content = content + " Expected ETA:  " + cal.getTime() + "   ";
                 }
                 variables.put("content ", content);
                 corecomments = "CORE Sales Order #: " + salesOrderId + " Site Survey results indicate that the Customer is in charge of the Clear Path work.   ";
                 corecomments = corecomments + " Expected ETA:  " + cal.getTime() + " from the Site Survey DSR data. ";
                 variables.put("corecomments ", corecomments);
                 variables.put("jepCode ", "CPCP ");
             }
             if (entryCondition.equalsIgnoreCase("IsPassed ")) {
                 content = "Could not retrieve Site Survey DSR :  " + dsrID + " related Clear Path information from Fireworks for Order  " + salesOrderId + " or, a Completion Date has not been found in the data. ";
                 variables.put("content ", content);
                 corecomments = "The system could not find Clear Path record or completion date in Fireworks for DSR  " + dsrID + "   " + " The Technician Dispatch is currently held via JEP status.   " + " The Provisioning workflow will await confirmation of Clear Path completion by virtue of closure of the just inserted ORDS job step and will then release the Dispatch.   " + " An actionable Task and Notification have been sent to the RI. ";
                 variables.put("corecomments ", corecomments);
                 variables.put("jepCode ", "CFOE ");
             }
             return null;
         }
     }
 }