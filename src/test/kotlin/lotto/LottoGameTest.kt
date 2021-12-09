package lotto

import lotto.domain.LottoGame
import lotto.view.InputView
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class LottoGameTest {

    @Test
    fun `로또 구입금액에 빈 문자열 또는 null을 입력한 경우`() {
        assertThrows<IllegalArgumentException> { LottoGame(InputView.validateMoney(null)) }
        assertThrows<IllegalArgumentException> { LottoGame(InputView.validateMoney("")) }
    }

    @Test
    fun `로또 구입금액에 숫자가 아닌 값을 입력한 경우`() {
        assertThrows<IllegalArgumentException> { LottoGame(InputView.validateMoney("abc")) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["100", "1000", "10000"])
    fun `구매 금액에 따른 구매 개수 테스트`(input: String) {
        val money = input.toInt()
        val lottoGame = LottoGame(money)
        assertThat(lottoGame.count).isEqualTo(money / LottoGame.PRICE)
    }
}
