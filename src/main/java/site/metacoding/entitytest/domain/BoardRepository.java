package site.metacoding.entitytest.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    // 기본 CRUD 있음
}
