package mga.edu.activitytracker.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import mga.edu.activitytracker.model.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    Collection<Activity> findByUserName(String userName);
}
