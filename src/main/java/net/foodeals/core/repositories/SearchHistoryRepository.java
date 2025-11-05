package net.foodeals.core.repositories;

import net.foodeals.core.domain.entities.SearchHistory;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface SearchHistoryRepository extends BaseRepository<SearchHistory, UUID> {

	List<SearchHistory> findByUserIdOrderBySearchedAtDesc(Integer userId);

	@Query("SELECT sh.keyword, COUNT(sh.keyword) AS count FROM SearchHistory sh " +
		       "GROUP BY sh.keyword ORDER BY count DESC")
		List<Object[]> findTrendingSearches();

}
