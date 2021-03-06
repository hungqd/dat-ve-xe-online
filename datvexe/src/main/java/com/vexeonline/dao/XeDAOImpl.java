/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import com.vexeonline.domain.NhaXe;
import com.vexeonline.domain.Xe;
import com.vexeonline.utils.HibernateUtil;

/**
 * @author Tung
 *
 */
public class XeDAOImpl implements XeDAO {

	@Override
	public Xe getById(Integer xeId) {
		return (Xe) HibernateUtil.getSessionFactory().getCurrentSession()
				.load(Xe.class, xeId);
	}

	public Xe getById(Integer nhaXeId, Integer id) {
		return (Xe) HibernateUtil.getSessionFactory().getCurrentSession()
				.createCriteria(Xe.class).add(Restrictions.eq("idXe", id))
				.createCriteria("nhaXe")
				.add(Restrictions.eq("idNhaXe", nhaXeId)).uniqueResult();
	}

	/**
	 * @author Tung
	 */
	@SuppressWarnings("unchecked")
	public List<Xe> list() {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("from Xe").list();
	}

	@Override
	public List<Xe> list(Integer nhaXeId) {
		return ((NhaXe) HibernateUtil.getSessionFactory().getCurrentSession()
				.load(NhaXe.class, nhaXeId)).getXes();
	}

	/**
	 * @author Tung
	 */
	public Integer save(Xe xe) {
		return (Integer) HibernateUtil.getSessionFactory().getCurrentSession()
				.save(xe);
	}

	/**
	 * @author Tung
	 */
	public void update(Xe xe) {
		HibernateUtil.getSessionFactory().getCurrentSession().update(xe);
	}

	@SuppressWarnings("unchecked")
	public List<Xe> listActive() {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createCriteria(Xe.class)
				.add(Restrictions.eq("isActive", true)).list();
	}

	
	@SuppressWarnings("unchecked")
	public List<Xe> listActive(Integer nhaXeId) {
		return HibernateUtil
				.getSessionFactory()
				.getCurrentSession()
				.createCriteria(Xe.class)
				.add(Restrictions.and(
						Restrictions.eq("nhaXe.idNhaXe", nhaXeId),
						Restrictions.eq("isActive", true))).list();
	}

	@SuppressWarnings("unchecked")
	public List<String> getListChoByidXe(int idXe) {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("SELECT\r\n" + 
							"  vt \r\n" + 
							" FROM\r\n" + 
							"  Xe AS x \r\n" + 
							" INNER JOIN\r\n" + 
							"  x.viTris as vt \r\n" + 
							" WHERE\r\n" + 
							"  x.idXe = :idXe")
				.setInteger("idXe", idXe)
				.list();
	}
}
