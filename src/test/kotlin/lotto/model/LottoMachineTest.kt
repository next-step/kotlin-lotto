package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoMachineTest {
    @ParameterizedTest
    @ValueSource(ints = [14000, 14100, 14500, 14999])
    fun `돈을 넣으면, 예산만큼 살 수 있는 로또 갯수를 반환한다`(budget: Int) {
        // given
        val lottoMachine = LottoMachine()
        val money = Money(budget)

        // when
        lottoMachine.insertMoney(money)

        // then
        val lottoCount = lottoMachine.getAvailableCount()
        assertThat(lottoCount).isEqualTo(14)
    }

    @Test
    fun `로또 넘버 풀을 인자로 주면, 로또가 발행된다`() {
        // given
        val lottoMachine = LottoMachine()
        val money = Money(15000)
        lottoMachine.insertMoney(money)

        // when
        val myLottos: Lottos = lottoMachine.buy()

        // then
        assertThat(myLottos.lottos.size).isEqualTo(15)
    }
}
