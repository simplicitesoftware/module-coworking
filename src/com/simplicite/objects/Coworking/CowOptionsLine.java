package com.simplicite.objects.Coworking;

import java.util.*;

import com.simplicite.util.*;
import com.simplicite.util.exceptions.*;
import com.simplicite.util.tools.*;

/**
 * Business object CowOptionsLine
 */
public class CowOptionsLine extends ObjectDB {
	private static final long serialVersionUID = 1L;
	@Override
	public String preSave() {
		if (getFieldValue("cowOptlBookId.cowBookRoomId.cowRoomNumber").equals(getFieldValue("cowOptlEliId.cowEliRoomId.cowRoomNumber"))) {
			return Message.formatInfo("Save OK", null, "cowEliOptlId.cowOptOptionName");
		}
		else {
			return Message.formatError("Option not eligible to this room", null, "cowEliOptlId.cowOptOptionName");
		}
		
	}
	
}
