package at.fh.swengs.meetpeople.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * http://docs.spring.io/spring-data/rest/docs/current/reference/html/
 */

@RepositoryRestResource()
public interface CategoriesRepository  extends PagingAndSortingRepository<Categories, Long> {
}
