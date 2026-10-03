package com.switchly.api.repository;

import org.springframework.stereotype.Repository;
import com.switchly.api.model.Organization;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
@Repository
public class InMemoryOrganizationRepository implements OrganizationRepository {
    private final Map<UUID, Organization> store = new ConcurrentHashMap<>();
    @Override
    public Organization save(Organization organization) {
        store.put(organization.getId(), organization);
        return organization;
    }
    @Override
    public Optional<Organization> findById(UUID id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Organization> findAll() {
        return new ArrayList<>(store.values());
    }
}
