package com.simplicite.extobjects.Coworking;

import java.util.*;

import com.simplicite.util.*;
import com.simplicite.util.exceptions.*;
import com.simplicite.util.tools.*;

/**
 * External object CowBuiMaps
 */
public class CowBuiMaps extends ExternalObject { // or com.simplicite.webapp.web.ResponsiveExternalObject for a custom UI component
	                                                 // or com.simplicite.webapp.services.RESTServiceExternalObject for a custom API
	                                                 // etc.
	private static final long serialVersionUID = 1L;
	@Override
    public Object display(Parameters params) {
        appendJSIncludes(HTMLTool.gmapJS());
        setHTML("<div id=\"mymap\" style=\"width: 400px; height: 400px;\"></div>");
        javascript("mymap.addMarker({lat:8.8566667, lng:2.3509871, title:'coworking'});");
        return javascript("Simplicite.Gmap.simpleDisplay('mymap', 8.8566667, 2.3509871, 15);");
    }
}
