package Services.impl;

import Config.Security.MyUserDetails;
import DAO.Repository.LessonRepository;
import Services.LessonService;
import entity.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {
    @Autowired
    private LessonRepository lessonRepository;

    @Override
    public List<Lesson> getAll() {
        return lessonRepository.findAll();
    }

    public List<Lesson> getByDate(Date date) {
        return lessonRepository.findAllByDateTime(date,
                ((MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getGroup());
    }
}
