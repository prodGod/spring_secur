package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.interfaces.RoleDao;
import web.model.Role;
import web.service.interfaces.RoleService;

import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Transactional
    @Override
    public boolean add(Role role) {
        Role existedRole = roleDao.findByRole(role.getRole());

        if (existedRole != null){
            return false;
        }
        roleDao.saveRole(role);
        return true;
    }

    @Override
    public Role getById(Long id) {
        return null;
    }

    @Override
    public Role getByName(String name) {
        return roleDao.findByRole(name);
    }

    @Override
    public boolean update(Role role) {
        return false;
    }

    @Override
    public Set<Role> findAll() {
        return roleDao.findAll();
    }
}