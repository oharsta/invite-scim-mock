package guests.api;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "/scim/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class SCIMController {

    private static Log LOG = LogFactory.getLog(SCIMController.class);

    @PostMapping("/users")
    public ResponseEntity<Map<String, String>> createUser(@RequestBody Map<String, Object> user) {
        LOG.info("/scim/v1/users POST " + user);
        return ResponseEntity.ok(Collections.singletonMap("id", UUID.randomUUID().toString()));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Map<String, String>> updateUser(@PathVariable("id") String id, @RequestBody Map<String, Object> user) {
        LOG.info("/scim/v1/users/" + id + " PUT " + user);
        return ResponseEntity.ok(Collections.singletonMap("id", id));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id) {
        LOG.info("/scim/v1/users/" + id + " DELETE");
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/groups")
    public ResponseEntity<Map<String, String>> createGroup(@RequestBody Map<String, Object> group) {
        LOG.info("/scim/v1/groups POST " + group);
        return ResponseEntity.ok(Collections.singletonMap("id", UUID.randomUUID().toString()));
    }

    @PatchMapping("/groups/{id}")
    public ResponseEntity<Map<String, String>> patchGroup(@PathVariable("id") String id, @RequestBody Map<String, Object> group) {
        LOG.info("/scim/v1/groups/" + id + " PATCH " + group);
        return ResponseEntity.ok(Collections.singletonMap("id", id));
    }

    @PutMapping("/groups/{id}")
    public ResponseEntity<Map<String, String>> updateGroup(@PathVariable("id") String id, @RequestBody Map<String, Object> group) {
        LOG.info("/scim/v1/groups/" + id + " PUT " + group);
        return ResponseEntity.ok(Collections.singletonMap("id", id));
    }

    @DeleteMapping("/groups/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable("id") String id) {
        LOG.info("/scim/v1/groups/" + id + " DELETE");
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
