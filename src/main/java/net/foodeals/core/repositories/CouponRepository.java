package net.foodeals.core.repositories;


import net.foodeals.core.domain.entities.Coupon;
import net.foodeals.core.domain.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CouponRepository extends BaseRepository<Coupon, UUID> {

    Page findAllByIsEnabledTrue(Pageable pageable);

    Page findAllByEndsAtBefore(Date now, Pageable pageable);

    List<Coupon> findByUser(User user );

    Optional<Coupon> findByCodeAndUser(String code, User user);

    Optional<Coupon> findByCode(String code);
}
