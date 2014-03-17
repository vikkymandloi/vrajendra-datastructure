

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cargo.AnalysisDtls;
import com.cargo.QAeligibility_cargo;

public class InstantiateModule extends HttpServlet {
	private static final long serialVersionUID = 1L;

	int summaryid = 0;
	DAO d1 = null;


	public InstantiateModule() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// obtain the summary ID
			//summaryid = Integer.parseInt(request.getAttribute("summaryid").toString());
			summaryid = 1234;
			d1 = new DAO();
			HttpSession session = request.getSession(true);
			Map summary_map = d1.searchSummary(summaryid);
			
			session.setAttribute("summaryid", summaryid);
			session.setAttribute("casename",summary_map.get("casename").toString());
			session.setAttribute("casenumber", summary_map.get("casenumber").toString());
			session.setAttribute("reviewnumber", summary_map.get("reviewnumber").toString());
			
			//Obtain the list from the reference table
			List<QAeligibility_cargo> listQAeligibilitycargo = d1.searchList();
			
			// Obtain the data from analysis table for 1st page using summary ID summary id 
			Map analys_dtls = d1.searchMap(1,summaryid);
			
			/*for(Map.Entry e1 : analys_dtls.entrySet()){
				System.out.println(e1.getKey()+" == "+(e1.getValue()).toString());
			}*/

			session.setAttribute("listQAeligibilitycargo", listQAeligibilitycargo);
			request.setAttribute("analys_dtls", analys_dtls);
			session.setAttribute("pagenumber", 1);
			session.setAttribute("d1", d1);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request,response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.service(request, response);
	}
}
