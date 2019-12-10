package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BjDao;
import vo.Bj;

/**
 * Servlet implementation class BjServlet
 */
@WebServlet("/bjServlet")
public class BjServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BjDao bjDao=new BjDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BjServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		String action=request.getParameter("action");
		if("list".equals(action)){
			this.list(request,response);
		}else if("add".equals(action)){
			this.add(request,response);
		}else if("edit".equals(action)){
			this.edit(request,response);
		}else if("update".equals(action)){
			this.update(request,response);
		}else if("delete".equals(action)){
			this.delete(request,response);
		}
		
		
	}
	private void list(HttpServletRequest request, HttpServletResponse response){
		
		try {
			List<Bj> bjList=bjDao.queryAll();
			request.setAttribute("bjList",bjList);
			request.getRequestDispatcher("/bj/list.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response){
	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out=null;
		try {
			out=response.getWriter();
			Bj bj=new Bj();
			bj.setBjname(request.getParameter("bjname"));
			bjDao.add(bj);
			request.setAttribute("info","��ӳɹ�");
			request.getRequestDispatcher("/bj/add.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.print("���ݿ�����쳣��༶�����ظ���");
			e.printStackTrace();
		}
	}
	private void edit(HttpServletRequest request, HttpServletResponse response){
		
		try {
			Bj bj=bjDao.findBjById(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("bj",bj);
			request.getRequestDispatcher("/bj/edit.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void update(HttpServletRequest request, HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=null;
		try {
			out=response.getWriter();
			Bj bj=new Bj();
			bj.setId(Integer.parseInt(request.getParameter("id")));
			bj.setBjname(request.getParameter("bjname"));
			bjDao.update(bj);
			request.setAttribute("info","�޸ĳɹ�");
			request.getRequestDispatcher("/bj/edit.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.print("���ݿ�����쳣��༶�����ظ���");
			e.printStackTrace();
		}
	}
	private void delete(HttpServletRequest request, HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");		
		PrintWriter out=null;
		try {
			out=response.getWriter();
			int id=Integer.parseInt(request.getParameter("id"));			
			bjDao.delete(id);		
			//response.sendRedirect(request.getContextPath()+"/bjServlet?action=list");
			List<Bj> bjList=bjDao.queryAll();
			request.setAttribute("bjList",bjList);
			request.getRequestDispatcher("/bj/list.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.print("���ݿ�����쳣��༶����ѧ����¼����ɾ����");
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
