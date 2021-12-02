package lotto

import lotto.domain.LottoGame
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoGameTest {
    @ParameterizedTest
    @ValueSource(strings = ["100", "1000", "10000"])
    fun `구매 금액에 따른 구매 개수 테스트`(input: String) {
        val money = input.toInt()
        val lottoGame = LottoGame(money)
        assertThat(lottoGame.count).isEqualTo(money / LottoGame.PRICE)
    }
}
