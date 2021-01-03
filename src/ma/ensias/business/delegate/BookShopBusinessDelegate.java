package ma.ensias.business.delegate;

import java.util.Collection;
import ma.ensias.bookshop.facade.BookShopFacadeBeanLocal;
import ma.ensias.bookshop.persistance.Article;

public class BookShopBusinessDelegate {
	
	private  BookShopFacadeBeanLocal  metier;
	
	
	public void setMetier(BookShopFacadeBeanLocal metier) {
		this.metier = metier;
	}
	public  Collection getAllArticlesFromFiliere(String filiere) {
		return metier.getAllArticlesFromFiliere(filiere);
	}
	public  Collection getAllArticles() {
		return metier.getAllArticles();
	}
	public  void addArticle(Article article) {
		metier.addArticle(article);
	}
	public  void deleteArticle(int numArticle) {
		metier.deleteArticle(numArticle);;
	}
}
