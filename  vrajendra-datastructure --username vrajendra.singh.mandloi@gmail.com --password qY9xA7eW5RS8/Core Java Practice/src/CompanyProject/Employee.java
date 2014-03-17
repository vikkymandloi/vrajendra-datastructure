package CompanyProject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

class EmployeeDetail {

	private String empName;
	private Date empDOB;
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Date getEmpDOB() {
		return empDOB;
	}
	public void setEmpDOB(Date empDOB) {
		this.empDOB = empDOB;
	}

	@Override
	public String toString() {
		String str = "Name : "+this.empName+", DOB : "+this.empDOB+"\n";
		//String str = this.empDOB.toString();
		return str;
	}
}

public class Employee {

	static String[] arrName = {"MudasserNayeem.Md@cognizant.com",
			"Suraj.Nallela@cognizant.com",
			"Anusha.Nune@cognizant.com",
			"Prashanth3.P3@cognizant.com",
			"Bhanu.Putumbaka@cognizant.com",
			"Reshma.R@cognizant.com",
			"Aparna.Rayaprolu@cognizant.com",
			"AliyaShakir.S@cognizant.com",
			"Shashidhar.Samudrala@cognizant.com",
	"Tejeswi.Shatharaju@cognizant.com"};
	static String[] arrDate = {"Wed Jan 25 11:30:00 IST 2013",
			"Wed Jan 23 11:30:00 IST 2013",
			"Thu Jan 24 11:30:00 IST 2013",
			"Fri Jan 13 11:30:00 IST 2013",
			//"Fri Feb 08 11:30:00 IST 2013",
			null,
			"Wed Feb 13 11:30:00 IST 2013",
			"Sun Feb 24 11:31:00 IST 2013",
			"Sun Feb 24 11:35:00 IST 2013",
			"Sun Feb 24 11:15:00 IST 2013",
	"Thu Feb 28 11:30:00 IST 2013"};
	
	/**
	 * @param ArrayList
	 * @param arrDate
	 * @param arrName
	 */
	public static void Callemployee()
	{		
		ArrayList<EmployeeDetail> ed1 = new ArrayList<EmployeeDetail>();
	
		for(int i=0;i<10;i++){
			try {
				EmployeeDetail ed = new EmployeeDetail();
				SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");	
				Date date = null;
				if(arrDate[i]!=null){			// Handel the Null values.
					date = sdf.parse(arrDate[i].toString());
				}
				ed.setEmpName(arrName[i]);
				ed.setEmpDOB(date);
				
				ed1.add(ed);	// Add it to Array list.
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Data in the List :: \n"+ed1.toString());
		// Collections sort, this Merge sort is the best sort available for sorting huge data.
		Collections.sort(ed1, new Comparator<EmployeeDetail>() {
			@Override
			public int compare(EmployeeDetail o1, EmployeeDetail o2) {
                Date date1 = o1.getEmpDOB();
                Date date2 = o2.getEmpDOB();
				if(date1 == null) 
					return -1;				// Reverse to return -1; 	
				if(date2== null)
					return 1;				//& Reverse to return 1;
				// we are comparing the dates for sorting the record automatically.
				// to display the null values at the top just reverse the polarity of return for Date1 and Date2.
				return date1.compareTo(date2);
			}
		});
		System.out.println("After Sorting Data :: \n"+ed1.toString());
	}
	
	/* Main method to call the method which has the built in data to sort according to date
	*/
	public static void main(String[] args) {
		Callemployee();	
	}
}
