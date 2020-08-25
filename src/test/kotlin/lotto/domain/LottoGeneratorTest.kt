package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoGeneratorTest {

    @DisplayName("로또 생성 반환값 테스트 ")
    @Test
    fun validateLottoGenerator() {
        val lottoGameMoney = LottoGameMoney.from("2000")!!

        assertThat(LottoGenerator.createAutoLottoList(lottoGameMoney.getCountOfGame()))
            .hasSize(2)
    }
}
