package guests.api;


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

    @PostMapping("/users")
    public ResponseEntity<Map<String, String>> createUser(@RequestBody Map<String, Object> user) {
        return ResponseEntity.ok(Collections.singletonMap("id", (String) user.get("id")));
    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<Map<String, String>> updateUser(@PathVariable("id") String id, @RequestBody Map<String, Object> user) {
        return ResponseEntity.ok(Collections.singletonMap("id", id));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/groups")
    public ResponseEntity<Map<String, String>> createGroup(@RequestBody Map<String, Object> group) {
        return ResponseEntity.ok(Collections.singletonMap("id", (String) group.get("id")));
    }

    @PatchMapping("/groups/{id}")
    public ResponseEntity<Map<String, String>> updateGroup(@PathVariable("id") String id, @RequestBody Map<String, Object> group) {
        return ResponseEntity.ok(Collections.singletonMap("id", id));
    }

    @DeleteMapping("/groups/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
