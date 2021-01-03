package ma.ensias.business.delegate;

import java.util.List;

import javax.ejb.EJB;

import bookShop.bookshop.stateful.ShoppingCartBeanLocal;
import ma.ensias.bookshop.persistance.Article;
import ma.ensias.bookshop.persistance.Commande;

public class ShoppingCartBusinessDelegate {
	
	 ShoppingCartBeanLocal metier;

	public void setMetier(ShoppingCartBeanLocal metier) {
		this.metier = metier;
	}

	public  Commande getCommande() {
		return null;
	}

	public  void addLigneDeCommande(int numeroArticle) {
		System.out.println("addLigneDeCommande");
	}

	public  void removeLigneDeCommande(int numeroArticle) {
		System.out.println("removeLigneDeCommande");
	}

	public   List<Article> getAllArticlesInShoppingCart() {
		return metier.getAllArticlesInShoppingCart();
	}
	public List<Commande> getCommandes(){
		return metier.getCommandes();
	}
	public void validerAchat( Commande commande) {
		metier.validerAchat(commande);
	}

}
