package net.foodeals.core.repositories;



import net.foodeals.core.domain.entities.CartItem;

import java.util.List;
import java.util.UUID;

public interface CartItemRepository extends BaseRepository<CartItem, UUID> {
    List<CartItem> findBySubEntityId(UUID storeId);
    List<CartItem> findAllByIdIn(List<UUID> ids);
}
