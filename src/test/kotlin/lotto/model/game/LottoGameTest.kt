package lotto.model.game

import lotto.model.input.InputReader
import lotto.model.input.Money
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoGameTest {

    @Test
    fun `금액을 인자로 주면, 구매 가능한 로또 갯수를 반환한다`() {
        // given
        val inputReader = InputReader()
        val lottoMachine = LottoMachine()
        val lottoGame = LottoGame(lottoMachine, inputReader)
        val money = Money(15000)

        // when
        val lottoCount = lottoGame.ready(money)

        // then
        assertThat(lottoCount).isEqualTo(15)
    }
}
