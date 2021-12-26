package guests;

import org.junit.jupiter.api.Test;

class SCIMApplicationTest {

    @Test
    void main() {
        SCIMApplication.main(new String[]{"--server.port=8088"});
    }
}