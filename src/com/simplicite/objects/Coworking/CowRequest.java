package com.simplicite.objects.Coworking;

import java.util.*;

import com.simplicite.util.*;
import com.simplicite.util.exceptions.*;
import com.simplicite.util.tools.*;

/**
 * Business object CowRequest
 */
public class CowRequest extends ObjectDB {
	private static final long serialVersionUID = 1L;
	
	/*@Override
	public String preSave() {
		ObjectDB cus = getGrant().getTmpObject("CowCustomers");
		cus.select(getFieldValue("cowReqCusId"));
		ObjectDB req = getGrant().getTmpObject("CowRequest");
		req.resetFilters();
		req.getField("cowReqCusId").setFilter(cus.getRowId());
		String res = Message.formatInfo("Save OK", null, "cowReqWorId");
		for (String[] row: search(false)) {
			if (req.getFieldValue("cowReqWorId.cowWorBuiId").equals(getFieldValue("cowReqWorId.cowWorBuiId")) && req.getFieldValue("cowReqWorId.cowWorStatus").equals(getFieldValue("cowReqWorId.cowWorStatus"))) {
				res = Message.formatError("You already have a request for the same type of seat in this building", null, "cowReqWorId");
			}
		}
		return res;
	}*/
	
	
	
	@Override
	public String postSave() {
		try {
			ObjectDB o = getGrant().getTmpObject("CowWorkspace");
			o.select(getFieldValue("cowReqWorId"));
			o.invokeAction("COW_UPDATE_AVAILABILITY");
		} catch (Exception e) {
			Message.formatSimpleError("Error during the availability checking");
		}
		
		//return Message.formatInfo("INFO_CODE", "Message", "fieldName");
		//return Message.formatWarning("WARNING_CODE", "Message", "fieldName");
		//return Message.formatError("ERROR_CODE", "Message", "fieldName");
		return null;
	}
	@Override
	public String postDelete() {
		try {
			ObjectDB o = getGrant().getTmpObject("CowWorkspace");
			o.select(getFieldValue("cowReqWorId"));
			o.invokeAction("COW_UPDATE_AVAILABILITY");
		} catch (Exception e) {
			Message.formatSimpleError("Error during the availability checking");
		}
		
		//return Message.formatInfo("INFO_CODE", "Message", "fieldName");
		//return Message.formatWarning("WARNING_CODE", "Message", "fieldName");
		//return Message.formatError("ERROR_CODE", "Message", "fieldName");
		//return HTMLTool.redirectStatement(HTMLTool.getFormURL("Object", null, "123", "nav=add"));
		//return HTMLTool.redirectStatement(HTMLTool.getListURL("Object", null, "nav=add"));
		return null;
	}
}