package Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import person.PersonDto;
import service.PersonService;

@WebServlet("/personList")
public class PssersonListCtr extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonService service = new PersonService();
		List<PersonDto> pList = service.getPersonList();
		HashMap<String, PersonDto> JSON = new HashMap<String, PersonDto>();
		for (int i = 0; i < pList.size(); i++) {
			JSON.put("\""+(i+1)+"\"",  pList.get(i));
		}
		System.out.println("JSONdata :"+JSON);
		//json포맷으로 만들어서 보내준다.
/*		String jsonData = "[";
		for (PersonDto p : pList) {
			jsonData += "{";
			jsonData += "\"id\":"+p.getId()+","; //"id":1
			jsonData += "\"name\":"+"\""+p.getName()+"\""+","; // "name":"hellow",
			jsonData += "\"age\":"+p.getAge();
			jsonData += "}";
			jsonData += ",";
		}
		jsonData = jsonData.substring(0,jsonData.lastIndexOf(","));
		jsonData += "]"; */
		//클라이언트에 결과를 보냄
		response.getWriter().write(JSON.toString());
		//request.getRequestDispatcher("result.jsp").forward(request, response);
	}
}
