package lotto.model

import lotto.model.generator.LottoNumberGenerater
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoTest {

    class FakeNumberGenerator(val numbers: String) : LottoNumberGenerater {
        override fun generate() = numbers.toNumbers()
    }

    @DisplayName(value = "같은 숫자 6개일 경우, 상금은 1등이여야한다.")
    @Test
    fun whenCreateLottoIsMatching6() {
        val input = "1,2,3,4,5,6"
        val lotto = Lotto.newAutoInstance(FakeNumberGenerator(input))
        Assertions.assertThat(lotto.checkNumbers(input.toNumbers(), 4).prizeMoney)
            .isEqualTo(Prize.ONE.prizeMoney)
    }

    @DisplayName(value = "같은 숫자 5개이고 보너스 맞을 경우, 상금은 2등이여야한다.")
    @Test
    fun whenCreateLottoIsMatching5AndBonus() {
        val input = "1,2,3,4,5,6"
        val lotto = Lotto.newAutoInstance(FakeNumberGenerator(input))
        val winningNumbers = "1,2,3,4,5,44"
        Assertions.assertThat(lotto.checkNumbers(winningNumbers.toNumbers(), 6).prizeMoney)
            .isEqualTo(Prize.TWO_BONUS.prizeMoney)
    }

    @DisplayName(value = "같은 숫자 0개일 경우, 상금은 0원이여야한다.")
    @Test
    fun whenCreateLottoIsMatching0() {
        val input = "1,2,3,4,5,6"
        val lotto = Lotto.newAutoInstance(FakeNumberGenerator(input))
        val winningNumbers = "11,22,33,44,55,66"
        Assertions.assertThat(lotto.checkNumbers(winningNumbers.toNumbers(), 44).prizeMoney)
            .isEqualTo(Prize.ZERO.prizeMoney)
    }

    @DisplayName(value = "일반 number에서, 로또의 범위의 숫자가 맞아야된다.")
    @ParameterizedTest
    @ValueSource(ints = [45, 23, 14, 5, 1])
    fun checkLottoNumberOK(input: Int) {
        Assertions.assertThat(Lotto.isLottoNumberRange(input)).isTrue()
        val noLottoRangeOver = input + Lotto.MAX_NUMBER
        Assertions.assertThat(Lotto.isLottoNumberRange(noLottoRangeOver)).isFalse()
        val noLottoRangeLess = input - Lotto.MAX_NUMBER
        Assertions.assertThat(Lotto.isLottoNumberRange(noLottoRangeLess)).isFalse()
    }
}
