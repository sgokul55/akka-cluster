package geeknight.model;

import java.util.UUID;

public class Employee {

    private UUID uuid;
    private String name;

    public Employee(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }
}
