package ma.ensias.bookshop.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.ensias.bookshop.facade.BookShopFacadeBeanLocal;
import ma.ensias.bookshop.persistance.Article;
import ma.ensias.business.delegate.BookShopBusinessDelegate;


@WebServlet
public class ListeArticlesServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private  BookShopFacadeBeanLocal  metier;
	
	BookShopBusinessDelegate businessDelegate;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		businessDelegate=new BookShopBusinessDelegate();
        businessDelegate.setMetier(metier);
	}
    public ListeArticlesServlets() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		if(action!=null && action.equals("delete")) {
			businessDelegate.deleteArticle(Integer.parseInt(request.getParameter("id")));
		}
		Collection listeArticles=businessDelegate.getAllArticles();
		request.getSession().setAttribute("listeArticles",listeArticles);
		getServletContext().getRequestDispatcher("/listeArticles.jsp").forward(request,response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int libelle=Integer.parseInt(request.getParameter("libelle"));
		float prix=Float.parseFloat(request.getParameter("prix"));
		businessDelegate.addArticle(new Article(libelle, prix));
		doGet(request, response);
	}

}
