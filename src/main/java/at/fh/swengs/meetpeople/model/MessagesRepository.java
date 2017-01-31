package at.fh.swengs.meetpeople.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * http://docs.spring.io/spring-data/rest/docs/current/reference/html/
 */

@RepositoryRestResource()
public interface MessagesRepository  extends PagingAndSortingRepository<Messages, Long> {


    public Messages findById(@Param("id") long id);

    public List<Messages> findByTitle(@Param("title") String title);
}
