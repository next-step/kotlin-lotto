package lotto.model

import lotto.model.prize.Prize
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PrizeTest {

    @DisplayName(value = "matchingCount가 6일 경우, 상금은 1등상금과 같아야한다.")
    @Test
    fun checkPrizeMoneyCase6() {
        val input = 6
        val prize = Prize.getPrize(input)
        assertThat(prize.prizeMoney).isEqualTo(Prize.ONE.prizeMoney)
        assertThat(prize).isEqualTo(Prize.ONE)
    }

    @DisplayName(value = "matchingCount= 2를 제외한 숫자는, BonusBall matching과는 영향이 없어야한다.")
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 6])
    fun checkPrizeMoneyCasesAndBonusBallMatching(input: Int) {
        val bonusBall = true
        val prize = Prize.getPrize(input, bonusBall)
        assertThat(prize.prizeMoney).isEqualTo(Prize.getPrize(input).prizeMoney)
        assertThat(prize).isEqualTo(Prize.getPrize(input))
    }

    @DisplayName(value = "matchingCount= 5, BonusBall matching이 안되었을 경우, 상금은 2등 보너스 상금과 같아야한다.")
    @Test
    fun checkPrizeMoneyCase5() {
        val input = 5
        val bonusBall = false
        val prize = Prize.getPrize(input, bonusBall)
        println(prize)
        assertThat(prize.prizeMoney).isEqualTo(Prize.TWO.prizeMoney)
        assertThat(prize).isEqualTo(Prize.TWO)
    }

    @DisplayName(value = "matchingCount= 5, BonusBall matching이 되었을 경우, 상금은 2등 보너스 상금과 같아야한다.")
    @Test
    fun checkPrizeMoneyCase5AndBonus() {
        val input = 5
        val bonusBall = true
        val prize = Prize.getPrize(input, bonusBall)
        assertThat(prize.prizeMoney).isEqualTo(Prize.TWO_BONUS.prizeMoney)
        assertThat(prize).isEqualTo(Prize.TWO_BONUS)
    }

    @DisplayName(value = "matchingCount가 [3,4,5]일 경우, 상금은 4등 상금보다 크거나 같아야 한다,")
    @ParameterizedTest
    @ValueSource(ints = [3, 4, 5])
    fun checkPrizeMoneyCase345(input: Int) {
        val prize = Prize.getPrize(input)
        assertThat(prize.prizeMoney.value).isGreaterThan(0)
        assertThat(prize.prizeMoney.value).isGreaterThanOrEqualTo(Prize.FOUR.prizeMoney.value)
    }

    @DisplayName(value = "matchingCount가 2이하 또는 음수일 경우, 상금은 0원 ")
    @ParameterizedTest
    @ValueSource(ints = [2, 1, 0, -1])
    fun checkPrizeMoney(input: Int) {
        val prize = Prize.getPrize(input)
        assertThat(prize.prizeMoney).isEqualTo(Prize.ZERO.prizeMoney)
        assertThat(prize).isEqualTo(Prize.ZERO)
    }

    @DisplayName(value = "matchingCount가 2이하 또는 음수일때는, 보너스 볼이 같아도, 상금은 0원 ")
    @ParameterizedTest
    @ValueSource(ints = [2, 1, 0, -1])
    fun checkPrizeMoneyZeroBonusBall(input: Int) {
        val bonusBall = true
        val prize = Prize.getPrize(input, bonusBall)
        assertThat(prize.prizeMoney).isEqualTo(Prize.ZERO.prizeMoney)
        assertThat(prize).isEqualTo(Prize.ZERO)
    }
}
