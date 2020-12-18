package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import person.PersonDto;
import service.PersonService;

@WebServlet("/person")
public class PersonCtr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PersonCtr() {
    	System.out.println("서블릿 생성");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("두겟 실행");
		String idStr = request.getParameter("id");
		idStr = (idStr == null || idStr.equals(""))? "0" : idStr;
		int id = Integer.parseInt(idStr);
		
		PersonService service = new PersonService();
		PersonDto p = service.getPersonById(id);
		
		//ajax를 쓰기우해 결과 데이타를 알맞은 포멧으로 보내줌
		String rs = "id:"+p.getId()+",name:"+p.getName()+",age:"+p.getAge();
		PrintWriter out = response.getWriter();
		out.print(rs);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("두포스트 실행");
	}

}
