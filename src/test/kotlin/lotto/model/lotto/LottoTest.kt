package lotto.model.lotto

import lotto.model.generator.LottoNumberGenerator
import lotto.model.prize.Prize
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoTest {

    class FakeNumberGenerator(private val numbers: String) : LottoNumberGenerator {
        override fun generate() = numbers.toNumbers()
    }

    @DisplayName(value = "같은 숫자 6개일 경우, 상금은 1등이여야한다.")
    @Test
    fun whenCreateLottoIsMatching6() {
        val input = "1,2,3,4,5,6"
        val lotto = Lotto.newAutoInstance(FakeNumberGenerator(input))
        val winner = WinnerNumbers(input.toNumbers(), LottoNumber.from(4))
        assertThat(lotto.checkNumbers(winner).prizeMoney)
            .isEqualTo(Prize.ONE.prizeMoney)
    }

    @DisplayName(value = "같은 숫자 5개이고 보너스 맞을 경우, 상금은 2등이여야한다.")
    @Test
    fun whenCreateLottoIsMatching5AndBonus() {
        val input = "1,2,3,4,5,6"
        val lotto = Lotto.newAutoInstance(FakeNumberGenerator(input))
        val winningNumbers = "1,2,3,4,5,44"
        val winner = WinnerNumbers(winningNumbers.toNumbers(), LottoNumber.from(6))
        assertThat(lotto.checkNumbers(winner).prizeMoney)
            .isEqualTo(Prize.TWO_BONUS.prizeMoney)
    }

    @DisplayName(value = "같은 숫자 0개일 경우, 상금은 0원이여야한다.")
    @Test
    fun whenCreateLottoIsMatching0() {
        val input = "1,2,3,4,5,6"
        val lotto = Lotto.newAutoInstance(FakeNumberGenerator(input))
        val winningNumbers = "11,22,33,43,44,45"
        val winner = WinnerNumbers(winningNumbers.toNumbers(), LottoNumber.from(40))
        assertThat(lotto.checkNumbers(winner).prizeMoney)
            .isEqualTo(Prize.ZERO.prizeMoney)
    }
}
