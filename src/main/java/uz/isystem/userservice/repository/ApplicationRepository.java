package uz.isystem.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.isystem.userservice.model.Application;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Integer> {

    List<Application> findByUserId(Integer userId); // Select * from application where userId = :userId;

    @Transactional
    @Query("from Application where userId = :userId and startDate < :date and endDate>:date")
    List<Application> applicationByMonthAndByUserId(@Param("userId") Integer id,@Param("date") String date);

}
