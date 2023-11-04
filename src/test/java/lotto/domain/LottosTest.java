package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;

@DisplayName("로또들 객체에 대해")
class LottosTest {

    private final LottoPurchasePrice purchasePrice = mock(LottoPurchasePrice.class);

    @Test
    @DisplayName("로또 구입 금액에 따라 로또들을 저장한다.")
    void Given_LottoAmountReturn2_When_SaveLottos_Then_hasSize2 () {
        //given
        Lottos lottos = new Lottos();
        given(purchasePrice.getLottosAmount()).willReturn(2);

        //when
        lottos.saveLottos(purchasePrice);
        List<Numbers> lottoValues = lottos.getLottoValues();

        //then
        assertThat(lottoValues).hasSize(2);
    }
}
