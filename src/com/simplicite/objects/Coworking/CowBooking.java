package com.simplicite.objects.Coworking;

import java.util.*;

import com.simplicite.util.*;
import com.simplicite.util.exceptions.*;
import com.simplicite.util.tools.*;

/**
 * Business object CowBooking
 */
public class CowBooking extends ObjectDB {
	private static final long serialVersionUID = 1L;
	public String verifHeure(List<Integer> time) {
		// renvoie la cause de l'erreur s'il y en a une, "Save OK" sinon
		List<Integer> op_time = getTime(getFieldValue("cowBookRoomId.cowRoomBuiId.cowBuiOpeningTime"));
		List<Integer> clo_time = getTime(getFieldValue("cowBookRoomId.cowRoomBuiId.cowBuiClosingTime"));
		String res = "Save OK";
		
		if (time.get(0) < op_time.get(0)) {
			res = "Too early";
		}
		else if (time.get(0) == op_time.get(0)) {
			if (time.get(1) < op_time.get(1)) {
				res = "Too early";
			}
		}
		else if (time.get(0) > clo_time.get(0)) {
			res = "Too late";
		}
		else if (time.get(0) == clo_time.get(0)) {
			if (time.get(1) > clo_time.get(1)) {
				res = "Too late";
			}
		}
		AppLog.info("verif heure: " + res, getGrant());
		return res;
	}
	
	public String verifDate(List<Integer> date, List<Integer> time) {
		
		List<Integer> current_date = getDate(Tool.getCurrentDate());
		List<Integer> current_time = getTime(Tool.getCurrentTime());
		AppLog.info(current_date + " " + current_time, getGrant());
		String res = "Save OK";
		if (date.get(0) < current_date.get(0)) {
			res = "Please select a working booking date";
		}
		else if (date.get(0) == current_date.get(0)) {
			if (date.get(1) < current_date.get(1)) {
				res ="Please select a working booking date";
			}
			else if (date.get(1) == current_date.get(1)) {
				if (time.get(0) < current_time.get(0)) {
					res = "Please select a working time";
				}
				else if (time.get(0) == current_time.get(0)) {
					if (time.get(1) < current_time.get(1)) {
						res = "Please select a working time";
					}
				}
			}
		}
		AppLog.info("verif date: " + res, getGrant());
		return res;
	}
	
	public List<Integer> getDate(String date) {
		List<Integer> res = new ArrayList<>();
		res.add(Integer.parseInt(date.substring(0,4)));
		res.add(Integer.parseInt(date.substring(5,7)));
		res.add(Integer.parseInt(date.substring(8,10)));
		return res;
	}
	
	public List<Integer> getTime(String time) {
		List<Integer> res = new ArrayList<>();
		res.add(Integer.parseInt(time.substring(0,2)));
		res.add(Integer.parseInt(time.substring(4,5)));
		return res;
	}
	

	
	public Boolean compareDate (List<Integer> d1, List<Integer> d2) {
		// return true if d1 > d2,false otherwise
		Boolean res = true;
		if (d1.get(0) < d2.get(0)) {
			res = false;
		}
		else if (d1.get(0) == d2.get(0)) {
			if (d1.get(1) < d2.get(1)) {
				res = false;
			}
			else if (d1.get(1) == d2.get(1)) {
				if (d1.get(2) < d2.get(2)) {
					res = false;
				}
			}
		}
		return res;
	}
	
	public Boolean compareTime (List<Integer> t1, List<Integer> t2) {
		// returns true if t1 > t2, false otherwise
		Boolean res = true;
		if (t1.get(0) < t2.get(0)) {
			res = false;
		}
		else if (t1.get(0)== t2.get(0)) {
			if (t1.get(1) < t2.get(1)) {
				res = false;
			}
		}
		return res;
	}
	
	public void cowCheckTiming() {
		ObjectDB o = getGrant().getTmpObject("CowRoom");
		o.select(getFieldValue("cowBookRoomId"));
		ObjectDB bookings = getGrant().getTmpObject("CowBooking");
		bookings.resetFilters();
		bookings.getField("cowBookRoomId").setFilter(o.getRowId());
		String res = "";
		List<Integer> this_date = getDate(getFieldValue("cowBookDate"));
		for (String[] row: bookings.search(false)) {
			bookings.setValues(row, false);
			if (!bookings.getRowId().equals(getRowId())) {
				List<Integer> date = getDate(bookings.getFieldValue("cowBookDate"));
				if (this_date.equals(date)) {
					res += bookings.getFieldValue("cowBookBeginningTime") + " - " + bookings.getFieldValue("cowBookEndingTime") + "  ";
				}
			}
		}
		AppLog.info(res, getGrant());
		if (res.equals("")) {
			setFieldValue("cowBookNotDisponible", "Available all day");
			save();
		}
		else {
			setFieldValue("cowBookNotDisponible", "Not available between: " + res);
			save();
		}
	}
	
	@Override
	public String postCreate() {
		cowCheckTiming();
		
		//return Message.formatInfo("INFO_CODE", "Message", "fieldName");
		//return Message.formatWarning("WARNING_CODE", "Message", "fieldName");
		//return Message.formatError("ERROR_CODE", "Message", "fieldName");
		//return HTMLTool.redirectStatement(HTMLTool.getFormURL("Object", null, "123", "nav=add"));
		//return HTMLTool.redirectStatement(HTMLTool.getListURL("Object", null, "nav=add"));
		//return HTMLTool.javascriptStatement("/* code */");
		return null;
	}
	
	public void checkTiming() {
		ObjectDB o = getGrant().getTmpObject("CowRoom");
		o.select(getFieldValue("cowBookRoomId"));
		ObjectDB bookings = getGrant().getTmpObject("CowBooking");
		bookings.resetFilters();
		bookings.getField("cowBookRoomId").setFilter(o.getRowId());
		String res = "";
		List<Integer> this_date = getDate(getFieldValue("cowBookDate"));
		for (String[] row: bookings.search(false)) {
			bookings.setValues(row, false);
			if (!bookings.getRowId().equals(getRowId())) {
				List<Integer> date = getDate(bookings.getFieldValue("cowBookDate"));
				if (this_date.equals(date)) {
					res += bookings.getFieldValue("cowBookBeginningTime") + " - " + bookings.getFieldValue("cowBookEndingTime") + "  ";
				}
			}
		}
		AppLog.info(res, getGrant());
		if (res.equals("")) {
			setFieldValue("cowBookNotDisponible", "Available all day");
		}
		else {
			setFieldValue("cowBookNotDisponible", "Not available between: " + res);
		}
	}
	
	@Override
	public String postSave() {
		checkTiming();
		ObjectDB o = getGrant().getTmpObject("CowRoom");
		o.select(getFieldValue("cowBookRoomId"));
		ObjectDB bookings = getGrant().getTmpObject("CowBooking");
		bookings.resetFilters();
		bookings.getField("cowBookRoomId").setFilter(o.getRowId());
		List<Integer> this_date = getDate(getFieldValue("cowBookDate"));
		for (String[] row: bookings.search(false)) {
			bookings.setValues(row, false);
			if (!bookings.getRowId().equals(getRowId())) {
				List<Integer> date = getDate(bookings.getFieldValue("cowBookDate"));
				if (this_date.equals(date)) {
					ObjectField disponibility = bookings.getField("CowBookNotDisponible");
					if (disponibility.getValue().equals(null) || disponibility.getValue().equals("Available all day") || disponibility.getValue().equals("")) {
						bookings.setFieldValue("cowBookNotDisponible", "Not available between :" + getFieldValue("cowBookBeginningTime") + " - " + getFieldValue("cowBookEndingTime") + "  ");
					}
					else {
						bookings.setFieldValue("cowBookNotDisponible", disponibility.getValue() + getFieldValue("cowBookBeginningTime") + " - " + getFieldValue("cowBookEndingTime") + "  ");
						
					}
					bookings.save();
				}
			}
		}
		return Message.formatInfo("Updated", null, "cowBookDate");
	}
	
	@Override
	public String preSave() {
		
		List<Integer> this_date = getDate(getFieldValue("cowBookDate"));
		List<Integer> this_b_time = getTime(getFieldValue("cowBookBeginningTime"));
		List<Integer> this_e_time = getTime(getFieldValue("cowBookEndingTime"));
		
		String verif_b_time = verifHeure(getTime(getFieldValue("cowBookBeginningTime")));
		String verif_e_time =verifHeure(getTime(getFieldValue("cowBookEndingTime"))); 
		String verif_date = verifDate(getDate(getFieldValue("cowBookDate")), getTime(getFieldValue("cowBookBeginningTime")));
		if (!verif_b_time.equals("Save OK")) {
			return Message.formatError(verif_b_time, null, "cowBookBeginningTime");
		}
		else if (!verif_e_time.equals("Save OK")) {
			return Message.formatError(verif_e_time, null, "cowBookEndingTime");
		}
		else if (!verif_date.equals("Save OK")) {
			return Message.formatError(verif_date, null, "cowBookDate");
		}
		else if(compareTime(this_b_time,this_e_time)) {
			return Message.formatError("Please enter a valid time", null, "cowBookBeginningTime");
		}
		


		ObjectDB o = getGrant().getTmpObject("CowRoom");
		o.select(getFieldValue("cowBookRoomId"));
		ObjectDB bookings = getGrant().getTmpObject("CowBooking");
		bookings.resetFilters();
		bookings.getField("cowBookRoomId").setFilter(o.getRowId());
		for (String[] row: bookings.search(false)) {
			bookings.setValues(row, false);
			AppLog.info(bookings.getFieldValue("cowBookBookingNumber"),getGrant());
			if (!bookings.getRowId().equals(this.getRowId())) {
				AppLog.info(bookings.getRowId(),getGrant());
				List<Integer> date = getDate(bookings.getFieldValue("cowBookDate"));
				List<Integer> b_time = getTime(bookings.getFieldValue("cowBookBeginningTime"));
				List<Integer> e_time = getTime(bookings.getFieldValue("cowBookEndingTime"));
				if (this_date.equals(date)) {
					checkTiming();
					if (compareTime(this_b_time, b_time) && compareTime(e_time,this_b_time)) {
						AppLog.info("error b time", getGrant());
						
						return Message.formatError("Not disponible at that time", null, "cowBookBeginningTime");
					}
					else if (compareTime(this_e_time, b_time) && compareTime(e_time,this_e_time)) {
						AppLog.info("error e time", getGrant());
						return Message.formatError("Not disponible at that time", null, "cowBookEndingTime");
					}
					else if (compareTime(b_time,this_b_time) && compareTime(this_e_time,e_time)) {
						return Message.formatError("Not disponible at that time", null, "cowBookBeginningTime");
					}
				}
				
			}
	 		
		}
		return Message.formatInfo("Save OK", null, "cowBookDate");
		
		
		//return Message.formatInfo("INFO_CODE", "Message", "fieldName");
		//return Message.formatWarning("WARNING_CODE", "Message", "fieldName");
		//return Message.formatError("ERROR_CODE", "Message", "fieldName");
	}
}