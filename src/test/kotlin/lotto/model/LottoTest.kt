package lotto.model

import lotto.model.generator.LottoNumberGenerater
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoTest {

    class FakeNumberGenerator(val numbers: String) : LottoNumberGenerater {
        override fun generate() = numbers.toNumbers()
    }

    @DisplayName(value = "같은 숫자 6개일 경우, 상금은 1등이여야한다.")
    @Test
    fun whenCreateLottoIsMatching6() {
        val input = "1,2,3,4,5,6"
        val lotto = Lotto.newAutoInstance(FakeNumberGenerator(input))
        Assertions.assertThat(lotto.checkNumbers(input.toNumbers()).getPrizeMoney())
            .isEqualTo(Prize.PrizeMoney.ONE.prizeMoney)
    }

    @DisplayName(value = "같은 숫자 0개일 경우, 상금은 0원이여야한다.")
    @Test
    fun whenCreateLottoIsMatching0() {
        val input = "1,2,3,4,5,6"
        val lotto = Lotto.newAutoInstance(FakeNumberGenerator(input))
        val winningNumbers = "11,22,33,44,55,66"
        Assertions.assertThat(lotto.checkNumbers(winningNumbers.toNumbers()).getPrizeMoney())
            .isEqualTo(Prize.PrizeMoney.ZERO.prizeMoney)
    }
}
