package Services.Data.Repository;

import entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface LessonRepository  extends JpaRepository<Lesson,Long> {


    @Query("select b from Lesson b where b.date = :date and b.group=:grop")
    List<Lesson> findAllByDateTime(@Param("date") Date date, @Param("grop") String grop);


    @Query("select b from Lesson b where b.date = :date and b.group=:grop")
    Lesson findByDate(@Param("date") Date date,@Param("grop") String grop);



}
