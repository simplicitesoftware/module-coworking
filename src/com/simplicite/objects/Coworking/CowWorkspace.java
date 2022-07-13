package com.simplicite.objects.Coworking;

import java.util.*;

import com.simplicite.util.*;
import com.simplicite.util.exceptions.*;
import com.simplicite.util.tools.*;

/**
 * Business object CowWorkspace
 */
public class CowWorkspace extends ObjectDB {
	private static final long serialVersionUID = 1L;
	public String cowUpdateAvailability() {
		
		try {
			ObjectDB o = getGrant().getTmpObject("CowRequest");
			o.resetFilters();
			o.getField("cowReqWorId").setFilter(getRowId());
			AppLog.info(o.search(false).toString(), getGrant());
			String res = " ";
			if (o.search(false).toString().equals("[]")) {
				getField("cowWorAvailability").setBoolean(true);
				
				res = AppLog.info("empty",getGrant());
			}
			else {
				for (String[] row: o.search(false)) {
					o.setValues(row,false);
					AppLog.info("ligne " + o.getRowId(),getGrant());
					AppLog.info(o.getFieldValue("cowReqStatus"), getGrant());
					if (o.getFieldValue("cowReqStatus").equals("ACCEPTED")) {
						getField("cowWorAvailability").setBoolean(false);
						res =  AppLog.info("occupied",getGrant());
						break;
					}
					else {
						getField("cowWorAvailability").setBoolean(true);
						res = AppLog.info("empty",getGrant());
					}
					
	
				}
			}
			save();
			AppLog.info("Availability Updated", getGrant());
			return res;
			
		}catch(Exception e) {
			return AppLog.info("Erreur",getGrant());
		}
	}
	
	@Override
	public String postCreate() {
		cowUpdateAvailability();
		
		//return Message.formatInfo("INFO_CODE", "Message", "fieldName");
		//return Message.formatWarning("WARNING_CODE", "Message", "fieldName");
		//return Message.formatError("ERROR_CODE", "Message", "fieldName");
		//return HTMLTool.redirectStatement(HTMLTool.getFormURL("Object", null, "123", "nav=add"));
		//return HTMLTool.redirectStatement(HTMLTool.getListURL("Object", null, "nav=add"));
		//return HTMLTool.javascriptStatement("/* code */");
		return null;
	}
}
