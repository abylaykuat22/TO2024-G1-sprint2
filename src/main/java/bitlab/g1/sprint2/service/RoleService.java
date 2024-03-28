package bitlab.g1.sprint2.service;

import bitlab.g1.sprint2.entity.Role;
import bitlab.g1.sprint2.repository.RoleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
  @Autowired
  private RoleRepository roleRepository;

  public List<Role> getRoles() {
    return roleRepository.findAll();
  }

  public Role getRoleById(Long id) {
    return roleRepository.findById(id).orElse(null);
  }
}
