/**
 */
package util;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import datamodel.Card;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @since JavaSE-1.8
 */
public class UtilDB {
   static SessionFactory sessionFactory = null;

   public static SessionFactory getSessionFactory() {
      if (sessionFactory != null) {
         return sessionFactory;
      }
      Configuration configuration = new Configuration().configure();
      StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
      sessionFactory = configuration.buildSessionFactory(builder.build());
      return sessionFactory;
   }
   public static List<Card> listCards() {
      List<Card> resultList = new ArrayList<Card>();

      Session session = getSessionFactory().openSession();
      Transaction tx = null;

      try {
         tx = session.beginTransaction();
         List<?> cards = session.createQuery("FROM Card").list();
         for (Iterator<?> iterator = cards.iterator(); iterator.hasNext();) {
        	 Card card = (Card) iterator.next();
            resultList.add(card);
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }

   public static List<Card> listCards(String keyword) {
      List<Card> resultList = new ArrayList<Card>();

      Session session = getSessionFactory().openSession();
      Transaction tx = null;

      try {
         tx = session.beginTransaction();
         String Query = "FROM Card WHERE name like '%"+keyword+"%'";
         List<?> cards = session.createQuery(Query).list();
         for (Iterator<?> iterator = cards.iterator(); iterator.hasNext();) {
        	 Card card = (Card) iterator.next();
          //  if (card.getName().startsWith(keyword)) {
               resultList.add(card);
           // }
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }

   public static void createCard(String name, String type,  String mana, String cardColor, String rule) {
      Session session = getSessionFactory().openSession();
      Transaction tx = null;
      try {
         tx = session.beginTransaction();
         session.save(new Card(name, type, cardColor, Integer.valueOf(mana), rule ));
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
   }
}
