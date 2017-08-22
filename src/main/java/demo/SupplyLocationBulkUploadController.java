package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupplyLocationBulkUploadController {

    private SupplyLocationRepository repository;

    @Autowired
    public SupplyLocationBulkUploadController(SupplyLocationRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/bulk/supplylocations", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<SupplyLocation>locations) {
        this.repository.save(locations);
    }

    @RequestMapping(value = "/pruge", method = RequestMethod.DELETE)
    public void purge() {
        this.repository.deleteAll();
    }
}
