package com.info.company.config;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoleConfig {
    private static final Map<String, List<String>> roleMap = new HashMap<>();

    static {
//        roleMap.put("/company/**", List.of("ROLE_ADMIN"));
        roleMap.put("/company/", List.of("ROLE_USER", "ROLE_ADMIN"));
        // Add more mappings as needed
    }

    public static List<String> getRequiredRoles(String path) {
        return roleMap.entrySet().stream()
                .filter(entry -> path.matches(entry.getKey()))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(List.of());
    }
}
