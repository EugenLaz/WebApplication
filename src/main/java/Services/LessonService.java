package Services;

import entity.Lesson;

import java.sql.Date;
import java.util.List;

public interface LessonService {
    List<Lesson> getAll();
    List<Lesson> getByDate(Date date);
}
