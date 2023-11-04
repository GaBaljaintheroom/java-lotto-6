package lotto.domain;

import lotto.dto.LottoResultDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 결과 Dto에 대해")
class LottoResultDtoTest {

    @ParameterizedTest
    @MethodSource("lottosResources")
    @DisplayName("로또 결과에 따라 출력 형태를 얻는다.")
    void Given_CreateLottoResultDto_When_toResultLottoMessage_Then_EqualType(List<Numbers> values) {
        //given
        LottoResultDto lottoResultDto = new LottoResultDto(values);

        //when
        String resultLottoMessage = lottoResultDto.toResultLottoMessage();

        //then
        assertThat(resultLottoMessage).isEqualTo(
                """
                        2개를 구매했습니다.
                        [1,2,3,4,5,6]
                        [7,8,9,10,11,12]
                        """
        );

    }

    static Stream<List<Numbers>> lottosResources() {
        Numbers numbers1 = new Numbers(List.of(1, 2, 3, 4, 5, 6));
        Numbers numbers2 = new Numbers(List.of(7, 8, 9, 10, 11, 12));
        return Stream.of(List.of(numbers1, numbers2));
    }
}
