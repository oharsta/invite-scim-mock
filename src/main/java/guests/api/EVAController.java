package guests.api;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import guests.model.GuestAccount;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "/eva")
public class EVAController {

    private static final Log LOG = LogFactory.getLog(EVAController.class);


    @PostMapping(value = "/api/v1/guest/create", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<Map<String, Object>> createUser(GuestAccount guestAccount) throws JsonProcessingException {
        LOG.info("eva/api/v1/guest/create POST " + guestAccount);

        return ResponseEntity.ok(Map.of("id", UUID.randomUUID().toString()));
    }

    @PostMapping(value = "/api/v1/guest/disable/{id}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<Void> disableUser(@PathVariable("id") String id) {
        LOG.info("eva/api/v1/guest/disable POST " + id);
        return ResponseEntity.ok().build();
    }
}
