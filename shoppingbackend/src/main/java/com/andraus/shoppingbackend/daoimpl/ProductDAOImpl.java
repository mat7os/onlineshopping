package com.andraus.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.andraus.shoppingbackend.dao.ProductDAO;
import com.andraus.shoppingbackend.dto.Product;

@Repository("ProductDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> list() {
		String selectActiveProduct = "FROM Product WHERE active = :active";

		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveProduct);
		query.setParameter("active", true);
		return query.getResultList();
	}

	@Override
	public Product get(int id) {
		try {
			return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id));
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean add(Product product) {
		sessionFactory.getCurrentSession().persist(product);
		return true;
	}

	@Override
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean delete(Product product) {
		try {
			product.setActive(false);
			return this.update(product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts = "FROM Product WHERE active = :active";
		
		return sessionFactory.getCurrentSession()
				.createQuery(selectActiveProducts, Product.class)
					.setParameter("active", true).
						getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductsByCategory = "FROM Product WHERE active = :active AND categoryID = :categoryID";
		
		return sessionFactory.getCurrentSession()
				.createQuery(selectActiveProductsByCategory, Product.class)
					.setParameter("active", true)
						.setParameter("categoryID", categoryId)
							.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM Product WHERE active = :active ORDER BY id", Product.class)
					.setParameter("active", true)
						.setFirstResult(0)
							.setMaxResults(count)
								.getResultList();
	}

}
