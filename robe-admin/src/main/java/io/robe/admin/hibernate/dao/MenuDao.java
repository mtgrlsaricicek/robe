package io.robe.admin.hibernate.dao;

import io.robe.admin.hibernate.entity.Menu;
import io.robe.hibernate.dao.BaseDao;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import javax.inject.Inject;
import java.util.List;

public class MenuDao extends BaseDao<Menu> {

    @Inject
    public MenuDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }


    public List<Menu> findByModule(String names) {
        Criteria criteria = currentSession().createCriteria(Menu.class);
        criteria.add(Restrictions.eq("module", names));
        criteria.addOrder(Order.asc("index"));
        return list(criteria);
    }

    public List<Menu> findHierarchicalMenu() {
        Criteria criteria = currentSession().createCriteria(Menu.class);
        criteria.add(Restrictions.isNull("parentOid"));
        criteria.addOrder(Order.asc("index"));
        return list(criteria);
    }

    public List<Menu> findByParentOid(String parentOid) {
        Criteria criteria = currentSession().createCriteria(Menu.class);
        criteria.add(Restrictions.eq("parentOid", parentOid));
        criteria.addOrder(Order.asc("index"));
        return list(criteria);
    }


}
