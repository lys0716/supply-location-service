package demo;

import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Point;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "supplyLocations")
public interface SupplyLocationRepository extends PagingAndSortingRepository<SupplyLocation, Long> {

    @RestResource(path = "nearLocations")
    SupplyLocation findFirstByLocationNear(@Param("location") Point location);

    @RestResource(path = "cities")
    SupplyLocation findByCity(@Param("city") String city, Pageable pageable);

    @RestResource(rel = "by-location", description = @Description("Find by location, comma separated, e.g. 'lat.long', and distance, e.g. '50km'"))
    SupplyLocation findFirstByLocation(@Param("location") Point location);
}
