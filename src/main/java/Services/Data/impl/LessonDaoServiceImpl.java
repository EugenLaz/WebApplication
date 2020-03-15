package Services.Data.impl;

import Config.Security.MyUserDetails;
import Services.Data.Repository.LessonRepository;
import Services.Data.LessonDaoService;
import entity.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class LessonDaoServiceImpl implements LessonDaoService {
    @Autowired
    private LessonRepository lessonRepository;

    @Override
    public List<Lesson> getAll() {
        return lessonRepository.findAll();
    }

    public List<Lesson> getByDate(Date date) {
        return lessonRepository.findAllByDateTime(date,
                ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getGroup());
    }
}
