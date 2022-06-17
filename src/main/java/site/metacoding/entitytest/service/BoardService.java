package site.metacoding.entitytest.service;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.entitytest.domain.Board;
import site.metacoding.entitytest.domain.BoardImplRepository;
import site.metacoding.entitytest.domain.BoardRepository;
import site.metacoding.entitytest.web.dto.BoardDetailRespDto;
import site.metacoding.entitytest.web.dto.BoardRespDto;

@RequiredArgsConstructor
@Service
public class BoardService {

    // 추상화하여 하나로 합쳐서 사용하면 좋은데
    private final BoardRepository boardRepository; // API 사용
    private final BoardImplRepository boardImplRepository; // JPQL 사용

    public BoardRespDto 상세보기(Integer id) {
        // 그대로 리턴하면 레이지로딩 때문에 문제가
        Board boardEntity = boardRepository.findById(id).get();

        BoardRespDto dto = new BoardRespDto(boardEntity.getId(), boardEntity.getTitle(), boardEntity.getContent());
        // 이렇게 하면 서비스에서 모든 데이터를 완성해서 컨트롤러로 전달 해 줄 수 있다.(비영속상태로)

        // 이런식으로 하면 Open In View가 의미가 없다.
        // 서비스에서 레이지로딩을 처리
        // Hibernate.initialize(boardEntity);
        return dto;
    }

    public BoardDetailRespDto 좋아요포함상세보기(Integer id) {
        boardImplRepository.mFindDetail(id);
        return null;
    }
}
