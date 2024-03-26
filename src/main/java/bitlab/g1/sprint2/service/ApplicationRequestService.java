package bitlab.g1.sprint2.service;

import bitlab.g1.sprint2.entity.ApplicationRequest;
import bitlab.g1.sprint2.repository.ApplicationRequestRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationRequestService {
  @Autowired
  private ApplicationRequestRepository applicationRequestRepository;

  public List<ApplicationRequest> getApplicationRequests() {
    return applicationRequestRepository.findAll();
  }

  public List<ApplicationRequest> getHandledAppRequests() {
    return applicationRequestRepository.findAll().stream()
        .filter(ApplicationRequest::isHandled)
        .toList();
  }
}
