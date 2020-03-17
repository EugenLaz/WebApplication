package Services.Data.impl;

import Services.Data.LessonRequestDaoService;
import Services.Data.Repository.LessonRequestRepository;
import entity.LessonRequest;
import entity.LessonRequestStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Service
public class LessonRequestDaoServiceImpl implements LessonRequestDaoService {

    @Autowired
    LessonRequestRepository repository;


    @Override
    public List<LessonRequest> findByUser(String username) {
        return repository.findAllByUser(username);
    }

    @Override
    public void saveLessonRequest(LessonRequest lessonRequest) {
         repository.save(lessonRequest);
    }

    @Override
    public void changeStatus(long id, LessonRequestStatus status) {
        LessonRequest request = findById(id);
        request.setStatus(status);
        repository.save(request);
    }

    @Override
    public LessonRequest findById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<LessonRequest> findAllApprovedByDate(String username, Date date) {
        return repository.findApprovedByDate(username, date);
    }

}
