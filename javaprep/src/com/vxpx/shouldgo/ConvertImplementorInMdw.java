package com.vxpx.shouldgo;

import java.util.HashMap;
import java.util.Map;

public class ConvertImplementorInMdw {
	
	
	public static void main(String[] args) {
		
		
		String fileHandle = ""
		
		Map<String,String> changeMap = new HashMap<String,String>();
		
		changeMap.put("com.qwest.mdw", "com.centurylink.mdw");
		changeMap.put("ControlledActivityException" , "ActivityException");
		changeMap.put("com.centurylink.mdw.workflow.activity.ActivityException" , "com.centurylink.mdw.activity.ActivityException");
		changeMap.put("com.centurylink.mdw.common.translator.base.JavaObjectTranslator" , "com.centurylink.mdw.common.translator.impl.JavaObjectTranslator");
		changeMap.put("com.centurylink.mdw.services.base.ServiceBeanLocator" , "com.centurylink.mdw.services.ServiceLocator");
		changeMap.put("ServiceBeanLocator" , "ServiceLocator");
		changeMap.put("com.centurylink.mdw.services.event.EventManager" , "com.centurylink.mdw.services.EventManager");
		changeMap.put("com.centurylink.mdw.services.EventManagerBean" , "com.centurylink.mdw.services.EventManager");
		changeMap.put("instances of new EventManagerBean()" , "ServiceLocator.getEventManager()");
		changeMap.put("com.centurylink.mdw.xmlSchema" , "com.centurylink.mdw.bpm");
		changeMap.put("com.centurylink.mdw.workflow.activity.types.ControlledActivity" , "com.centurylink.mdw.activity.types.GeneralActivity");
		changeMap.put("com.centurylink.mdw.common.utilities.ApplicationContext" , "com.centurylink.mdw.common.ApplicationContext");
		changeMap.put("com.centurylink.mdw.services.user.UserManager" , "com.centurylink.mdw.services.UserManager");
		changeMap.put("com.centurylink.mdw.impl.drools" , "com.centurylink.mdw.workflow.drools");
		changeMap.put("com.centurylink.mdw.services.process.ProcessException" , "com.centurylink.mdw.services.ProcessException");
		changeMap.put("com.centurylink.mdw.workflow.task.observer.TaskEmailNotifier" , "com.centurylink.mdw.workflow.task.notifier.TaskEmailNotifier");
		changeMap.put("com.centurylink.mdw.workflow.activity.impl.process.ProcessStartControlledActivity" , "com.centurylink.mdw.workflow.activity.process.ProcessStartActivity");
		changeMap.put("ProcessStartControlledActivity" , "ProcessStartActivity");
		changeMap.put("com.centurylink.mdw.workflow.activity.types.StartActivity" , "com.centurylink.mdw.activity.types.StartActivity");
		changeMap.put("com.centurylink.mdw.common.container.NamingProvider" , "com.centurylink.mdw.container.NamingProvider");
		changeMap.put("com.centurylink.mdw.workflow.activity.impl.LdapAdapter" , "com.centurylink.mdw.workflow.adapter.ldap.LdapAdapter");
		changeMap.put("com.centurylink.mdw.workflow.activity.impl.PublishEventMessage" , "com.centurylink.mdw.workflow.activity.event.PublishEventMessage");
		changeMap.put("com.centurylink.mdw.workflow.activity.impl.ControlledActivityImpl" , "com.centurylink.mdw.workflow.activity.DefaultActivityImpl");
		changeMap.put("ControlledActivityImpl" , "DefaultActivityImpl");
		changeMap.put("com.centurylink.mdw.workflow.activity.impl.ControlledEvaluationActivityImpl" , "com.centurylink.mdw.workflow.activity.DefaultActivityImpl");
		changeMap.put("ControlledEvaluationActivityImpl" , "DefaultActivityImpl");
		changeMap.put("com.centurylink.mdw.workflow.activity.impl.evaluator.VariableValueEvaluator" , "com.centurylink.mdw.workflow.activity.AbstractEvaluator");
		changeMap.put("VariableValueEvaluator" , "AbstractEvaluator");
		changeMap.put("com.centurylink.mdw.workflow.activity.impl.evaluator.ScriptEvaluator" , "com.centurylink.mdw.workflow.activity.script.ScriptEvaluator");
		changeMap.put("com.centurylink.mdw.workflow.constant" , "com.centurylink.mdw.common.constant");
		changeMap.put("com.centurylink.mdw.services.task.TaskManager" , "com.centurylink.mdw.services.TaskManager");
		changeMap.put("com.centurylink.mdw.workflow.activity.DocumentWebServiceAdapter" , "com.centurylink.mdw.workflow.adapter.soap.DocumentWebServiceAdapter");
		changeMap.put("com.centurylink.mdw.workflow.activity.impl.RestfulServiceAdapter" , "com.centurylink.mdw.workflow.adapter.rest.RestfulServiceAdapter");
		changeMap.put("com.centurylink.mdw.workflow.activity.impl.EventWaitActivityImpl" , "com.centurylink.mdw.workflow.activity.event.EventWaitActivity");
		changeMap.put("EventWaitActivityImpl" , "EventWaitActivity");
		changeMap.put("com.centurylink.mdw.workflow.adapter.HeaderAwareAdapter" , "com.centurylink.mdw.adapter.HeaderAwareAdapter");
		changeMap.put("com.centurylink.mdw.workflow.activity.impl.task.ManualTaskAndEventWaitActivity" , "com.centurylink.mdw.workflow.activity.task.CustomManualTaskActivity");
		changeMap.put("ManualTaskAndEventWaitActivity" , "CustomManualTaskActivity");
		changeMap.put("com.centurylink.mdw.services.TaskManagerAccess" , "com.centurylink.mdw.services.task.TaskManagerAccess");
		changeMap.put("com.centurylink.mdw.workflow.activity.impl.rules.DroolsDecisionTableActivity" , "com.centurylink.mdw.workflow.activity.rules.DroolsDecisionTableActivity");
		changeMap.put("getKnowledgeBase(knowledgeBaseName)","getKnowledgeBase(knowledgeBaseName, null)");
		changeMap.put("com.centurylink.mdw.workflow.activity.JdbcSqlAdapter" , "com.centurylink.mdw.workflow.adapter.db.JdbcSqlAdapter");
		changeMap.put("com.centurylink.mdw.workflow.activity.impl.PoolableAdapterBase" , "com.centurylink.mdw.workflow.adapter.PoolableAdapterBase");
		changeMap.put("com.centurylink.mdw.workflow.event.types.ExternalEventHandler" , "com.centurylink.mdw.event.ExternalEventHandler");
		changeMap.put("com.centurylink.mdw.workflow.event.EventHandlerException" , "com.centurylink.mdw.event.EventHandlerException");
		changeMap.put("com.centurylink.mdw.services.task.TaskException" , "com.centurylink.mdw.services.TaskException");
		changeMap.put("com.centurylink.mdw.services.event.EventException" , "com.centurylink.mdw.services.EventException");
		changeMap.put("UserGroupCache.getUserGroup","UserGroupCache.getWorkgroup");
		changeMap.put("com.centurylink.mdw.workflow.base.CallURL" , "com.centurylink.mdw.common.utilities.form.CallURL");
		changeMap.put("com.centurylink.mdw.workflow.activity.impl.process.InvokeHeterogeneousProcessActivity" , "com.centurylink.mdw.workflow.activity.process.InvokeHeterogeneousProcessActivity");
		changeMap.put("com.centurylink.mdw.workflow.activity.impl.ControlledTimerWaitActivityImpl" , "com.centurylink.mdw.workflow.activity.timer.TimerWaitActivity");
		changeMap.put("ControlledTimerWaitActivityImpl" , "TimerWaitActivity");
		changeMap.put("com.qwest.businessActivityMonitor" , "com.centurylink.bam");
		changeMap.put("com.centurylink.mdw.workflow.activity.types.FinishActivity" , "com.centurylink.mdw.activity.types.FinishActivity");		

		
		
		
		
		
		
	}

}
