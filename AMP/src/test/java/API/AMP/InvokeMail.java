package API.AMP;

import javax.mail.MessagingException;




public class InvokeMail {

public static String server="smtp.gmail.com";
	
	public static String from = "syed.gaadi@gmail.com";
	public static String password = "nbawpdsgazfbmilj";
	public static String[] to ={"syed@91mobiles.com","sandhya@91mobiles.com"};
	public static String subject = "AMP Test Report";
	public static String port="25";
	//public static String username="syed.gaadi@gmail.com";
	//public static String subjectattachment = "Selenium3.0 report";
	//public static String messageBody="Hi";
	
	  public static String messageBody
	  ="Please find the AMP Validation report attached."
	  +
	  " <br><br><b></b>"+"<br><br>"+
	  "<b>Thanks,</b><br>QA Team";
	 
	
	//public static StringBuffer testCaseLink=new StringBuffer();
	public static String attachmentPath="/home/ahtisham/Automation/AMP/src/test/java/API/AMP/AMP.xls";
	public static String attachmentName="Report.xlsx";
}
