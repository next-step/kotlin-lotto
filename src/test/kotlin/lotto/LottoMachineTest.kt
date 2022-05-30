package lotto

import lotto.domain.LottoMachine
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoMachineTest {

    @ParameterizedTest
    @CsvSource("14000, 14", "13500,13", "0,0")
    fun `구매금액만큼 로또를 발급한다`(money: Int, expect: Int) {
        val lotto = LottoMachine.buy(money)
        Assertions.assertThat(lotto.size).isEqualTo(expect)
    }

    @Test
    fun `구매금액은 0보다 작으면, 예외가 IllegalArgumentException 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoMachine.buy(-1000)
        }
    }
}
