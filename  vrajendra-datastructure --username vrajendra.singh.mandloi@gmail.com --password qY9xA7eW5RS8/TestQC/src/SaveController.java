import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cargo.AnalysisDtls;

public class SaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO d1 =  null;

	public SaveController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void saveparams(HttpServletRequest request, HttpServletResponse response,int summaryid, int pagenumber)
	{
		List codes = d1.getcodes(pagenumber);
		Iterator it1 = codes.iterator();
		while(it1.hasNext()){
			int code = Integer.parseInt(it1.next().toString());
			String element_comment = (String)request.getParameter(code+"_element_comment");
			String analysis_comment = (String)request.getParameter(code+"_analysis_comment");
			String investigation_comment = (String)request.getParameter(code+"_investigation_comment"); 
			int resultcode = Integer.parseInt((String)request.getParameter(code+"_result_opt"));

			d1.executeQuery(element_comment, analysis_comment, investigation_comment, resultcode, summaryid, code, pagenumber);
			//System.out.println(code+" = "+element_comment+"----"+analysis_comment+"----"+investigation_comment);
		}
		System.out.println("Saved..!");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		HttpSession session = request.getSession(true);

		d1 = (DAO) session.getAttribute("d1");
		int pagenumber = Integer.parseInt(session.getAttribute("pagenumber").toString());
		int summaryid = Integer.parseInt(session.getAttribute("summaryid").toString());

		//List codes = (ArrayList)request.getAttribute("codes"); 

		if(request.getParameter("navto").equals("Next"))
		{
			saveparams(request,response, summaryid, pagenumber);
			pagenumber++;
			Map analys_dtls = d1.searchMap(pagenumber, summaryid);
			if(pagenumber>13)
			{
				dispatcher = request.getRequestDispatcher("/index1.jsp");
			}
			request.setAttribute("analys_dtls", analys_dtls);
			session.setAttribute("pagenumber", pagenumber);
		}

		if(request.getParameter("navto").equals("Previous"))
		{
			saveparams(request,response, summaryid, pagenumber);
			pagenumber--;
			Map analys_dtls = d1.searchMap(pagenumber, summaryid);
			if(pagenumber<1)
			{
				dispatcher = request.getRequestDispatcher("/home.jsp");
			}
			request.setAttribute("analys_dtls", analys_dtls);
			session.setAttribute("pagenumber", pagenumber);
		}	

		dispatcher.forward(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.service(request, response);
	}

}
