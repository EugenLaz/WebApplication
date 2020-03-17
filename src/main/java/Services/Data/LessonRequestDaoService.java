package Services.Data;

import entity.LessonRequest;
import entity.LessonRequestStatus;

import java.util.Date;
import java.util.List;


public interface LessonRequestDaoService {
    List<LessonRequest> findByUser(String username);

    void saveLessonRequest(LessonRequest user);

    void changeStatus(long id, LessonRequestStatus status);

    LessonRequest findById(long id);

    List<LessonRequest> findAllApprovedByDate(String username, Date date);
}
