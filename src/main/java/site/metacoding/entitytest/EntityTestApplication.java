package site.metacoding.entitytest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import site.metacoding.entitytest.domain.Board;
import site.metacoding.entitytest.domain.BoardRepository;

@Configuration
@SpringBootApplication
public class EntityTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntityTestApplication.class, args);
	}

	// Bean이 메모리에 올려줌. 실행시점은 서버 최초 시작시 한번!!
	@Bean
	public CommandLineRunner initData(BoardRepository boardRepository) {

		// 익명함수 (람다사용)
		return (args) -> {
			Board board = new Board();

			board.setTitle("제목1");
			board.setContent("내용1");
			boardRepository.save(board);

			Board board2 = new Board();

			board2.setTitle("제목2");
			board2.setContent("내용2");
			boardRepository.save(board2);
		};
	}
}
