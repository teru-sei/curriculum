package controller;
 
/**
 * 社員情報管理コントローラー
 */
 
import java.io.IOException;

import bean.EmployeeBean;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.EmployeeService;
 
public class EmployeeController extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
 
	try {
  // 問① index.htmlから送信されたIDとPassWordの値を取得できるように修正しましょう。
		String id = request.getParameter("id");
		String password = request.getParameter("pass");
 
 /*
 * IDとPassWordと元に、社員情報を検索する関数の呼び出し、結果をJSPに渡す処理
 * ※ EmployeeBeanとEmployeeServiceをimportするのを忘れないでください。
 */
  // 問② EmployeeServiceクラスをインスタンス化する。
		EmployeeService service = new EmployeeService();
 // 問③ EmployeeBeanに、EmployeeServiceよりsearch関数を呼び出し、返り値を格納する。
		service.search(id, password);
		EmployeeBean idPassword = service.search(id, password);
 // 問④ nullの部分に適切な引数をセットする。
		request.setAttribute("EmployeeBean", idPassword);
 
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		ServletContext context = this.getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
	}
}