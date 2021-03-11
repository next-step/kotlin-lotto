package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoMachineTest {
    @ParameterizedTest
    @ValueSource(ints = [14000, 14100, 14500, 14999])
    fun test(budget: Int) {
        // given
        val lottoMachine = LottoMachine()
        val money = Money(budget)

        // when
        lottoMachine.insertMoney(money)

        // then
        val lottoCount = lottoMachine.getAvailableCount()
        assertThat(lottoCount).isEqualTo(14)
    }
}
