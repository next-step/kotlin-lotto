package lotto.model.game

import lotto.model.input.InputReader
import lotto.model.input.Money
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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

    @Test
    fun `구매할 갯수를 인자로 주면, 해당 갯수만큼 로또가 반환된다`() {
        // given
        val inputReader = InputReader()
        val lottoMachine = LottoMachine()
        val lottoGame = LottoGame(lottoMachine, inputReader)
        val money = Money(15000)
        val lottoCount = lottoGame.ready(money)

        // when
        val myLottos = lottoGame.buy(lottoCount)

        // then
        assertThat(myLottos.lottos).hasSize(15)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 10, 15])
    fun `구매할 로또의 수는 예산으로 살 수 있는 갯수보다 작아야 한다`(lottoCount: Int) {
        // given
        val inputReader = InputReader()
        val lottoMachine = LottoMachine()
        val lottoGame = LottoGame(lottoMachine, inputReader)
        val money = Money(15000)
        val totalCount = lottoGame.ready(money)

        // when, then
        assertThat(totalCount).isGreaterThan(lottoCount)
        assertDoesNotThrow { lottoGame.buy(lottoCount) }
    }
}
