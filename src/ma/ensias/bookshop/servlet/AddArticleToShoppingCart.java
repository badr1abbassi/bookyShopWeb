package ma.ensias.bookshop.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookShop.bookshop.stateful.ShoppingCartBean;
import bookShop.bookshop.stateful.ShoppingCartBeanLocal;
import ma.ensias.bookshop.persistance.Article;
import ma.ensias.bookshop.persistance.Commande;
import ma.ensias.bookshop.persistance.LigneDeCommande;
import ma.ensias.business.delegate.ShoppingCartBusinessDelegate;


@WebServlet
public class AddArticleToShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 2L;
	@EJB
	ShoppingCartBeanLocal metier;
	private ShoppingCartBusinessDelegate businessDelegate;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		businessDelegate=new ShoppingCartBusinessDelegate();
    	businessDelegate.setMetier(metier);
	}
    public AddArticleToShoppingCart() {
    	
   }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Article art=new Article(100, 120);
		LigneDeCommande lc=new LigneDeCommande(60);
		
		/*lc.setArticle(art);
		Commande c=new Commande();
		c.AddLigneCommande(lc);
		businessDelegate.validerAchat(c);
		*/
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collection list=businessDelegate.getCommandes();
		request.getSession().setAttribute("Commandes", list);
		getServletContext().getRequestDispatcher("/commande.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
