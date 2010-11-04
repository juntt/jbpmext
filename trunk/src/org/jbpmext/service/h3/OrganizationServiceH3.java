/**
 * 
 */
package org.jbpmext.service.h3;

import java.util.List;

import org.jbpmext.dao.TermedDAO;
import org.jbpmext.model.Organization;
import org.jbpmext.service.OrganizationService;

/**
 * @author weiht
 *
 */
@SuppressWarnings("unchecked")
public class OrganizationServiceH3 implements OrganizationService {
	private static final String HQL_GET_ROOT = "from Organization o where o.parent is null";
	private static final String HQL_GET_CHILDREN = "from Organization o where o.parent.id = ?";
	
	private TermedDAO dao;

	public TermedDAO getDao() {
		return dao;
	}

	@Override
	public void setDao(TermedDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<Organization> getRoot() {
		return dao.find(HQL_GET_ROOT);
	}

	@Override
	public List<Organization> getChildOrgs(int parent) {
		return dao.find(HQL_GET_CHILDREN, parent);
	}
}
