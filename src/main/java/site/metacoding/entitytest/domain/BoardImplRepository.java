package site.metacoding.entitytest.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import site.metacoding.entitytest.web.dto.BoardDetailRespDto;

@RequiredArgsConstructor
@Repository
public class BoardImplRepository {

    private final EntityManager em;

    public BoardDetailRespDto mFindDetail(Integer id) {
        // String sql = "SELECT b.*,(서브쿼리) FROM board b WHERE id = ?";
        String sql = "SELECT b.*,true FROM board b  WHERE b.id = ?";

        Query query = em.createNativeQuery(sql)
                .setParameter(1, id);

        Object[] result = (Object[]) query.getSingleResult();
        Integer boardId = (Integer) result[0];
        String title = (String) result[1];
        String content = (String) result[2];
        boolean isLOve = (boolean) result[3];

        BoardDetailRespDto dto = new BoardDetailRespDto(boardId, title, content, isLOve);
        System.out.println("Hello");

        return dto;
    }

    public List<BoardDetailRespDto> mFindAll() {

        List<BoardDetailRespDto> dtos = new ArrayList<>();
        // String sql = "SELECT b.*,(서브쿼리) FROM board b WHERE id = ?";
        String sql = "SELECT b.*,true FROM board b";

        Query query = em.createNativeQuery(sql);

        List<Object[]> results = (List<Object[]>) query.getResultList();

        for (Object[] result : results) {
            Integer boardId = (Integer) result[0];
            String title = (String) result[1];
            String content = (String) result[2];
            boolean isLOve = (boolean) result[3];

            BoardDetailRespDto dto = new BoardDetailRespDto(boardId, title, content, isLOve);
            dtos.add(dto);
        }

        return dtos;
    }

    public List<BoardDetailRespDto> mFindAllQLRM() {
        // String sql = "SELECT b.*,(서브쿼리) FROM board b WHERE id = ?";
        String sql = "SELECT b.*,true FROM board b";

        Query query = em.createNativeQuery(sql);

        JpaResultMapper mapper = new JpaResultMapper();

        List<BoardDetailRespDto> dto = mapper.list(query, BoardDetailRespDto.class);

        return dto;
    }
}
