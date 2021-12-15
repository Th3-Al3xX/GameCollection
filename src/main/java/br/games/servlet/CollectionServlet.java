package br.games.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.games.controller.CollectionController;
import br.games.model.Collection;

/**
 * Servlet implementation class CollectionServlet
 */
@WebServlet("/")
public class CollectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CollectionController collectionController;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollectionServlet() {
    	this.collectionController = new CollectionController();
    	
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		
		switch (action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			try {insertJogo(request, response);}
			catch (SQLException e) {e.printStackTrace();}
			break;
		case "/delete":
			try {deleteJogo(request, response);}
			catch (SQLException e) {e.printStackTrace();}
			break;
		case "/edit":
			try {showEditForm(request, response);}
			catch (SQLException e) {e.printStackTrace();}
			break;
		case "/update":
			try {updateJogo(request, response);}
			catch (SQLException e) {e.printStackTrace();}
			break;
		default:
			try {listJogo(request, response);}
			catch (SQLException e) {e.printStackTrace();}
			break;
		}
	}
	
	private void listJogo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		        List<Collection> listJogo = collectionController.selectTodosJogos();
		        request.setAttribute("listJogo", listJogo);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("jogo-list.jsp");
		        dispatcher.forward(request, response);
		    }
	
	private void updateJogo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        String nome = request.getParameter("nome");
		        String desenv = request.getParameter("desenv");
		        String estilo = request.getParameter("estilo");
		        String plataforma = request.getParameter("plataforma");

		        Collection collection = new Collection(id, nome, desenv, estilo, plataforma);
		        collectionController.updateJogo(collection);
		        response.sendRedirect("list");
		    }
	
	private void deleteJogo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        collectionController.deleteJogo(id);
		        response.sendRedirect("list");

		    }
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        Collection collection = collectionController.selectJogo(id);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("jogo-form.jsp");
		        request.setAttribute("collection", collection);
		        dispatcher.forward(request, response);

		    }
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("jogo-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertJogo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		        String nome = request.getParameter("nome");
		        String desenv = request.getParameter("desenv");
		        String estilo = request.getParameter("estilo");
		        String plataforma = request.getParameter("plataforma");
		        Collection newJogo = new Collection(nome, desenv, estilo, plataforma);
		        collectionController.insertJogo(newJogo);
		        response.sendRedirect("list");
		    }
}
