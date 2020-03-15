package Services.Data;

import entity.Lesson;

import java.sql.Date;
import java.util.List;

public interface LessonDaoService {
    List<Lesson> getAll();
    List<Lesson> getByDate(Date date);
}
