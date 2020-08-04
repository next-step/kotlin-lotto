package lotto.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PrizeTest {

    @DisplayName(value = "matchingCount가 6일 경우, 상금은 1등상금과 같아야한다.")
    @Test
    fun checkPrizeMoneyCase6() {
        val input = 6
        val prize = Prize.newInstance(input)
        Assertions.assertThat(prize.getPrizeMoney()).isEqualTo(Prize.PrizeMoney.ONE.prizeMoney)
        Assertions.assertThat(prize.isType(Prize.PrizeMoney.ONE)).isTrue()
    }

    @DisplayName(value = "matchingCount가 [3,4,5]일 경우, 상금은 4등 상금보다 크거나 같아야 한다,")
    @ParameterizedTest
    @ValueSource(ints = [3, 4, 5])
    fun checkPrizeMoneyCase345(input: Int) {
        val prize = Prize.newInstance(input)
        Assertions.assertThat(prize.getPrizeMoney()).isGreaterThan(0)
        Assertions.assertThat(prize.getPrizeMoney()).isGreaterThanOrEqualTo(Prize.PrizeMoney.FOUR.prizeMoney)
    }

    @DisplayName(value = "matchingCount가 2이하 또는 음수일 경우, 상금은 0원 ")
    @ParameterizedTest
    @ValueSource(ints = [2, 1, 0, -1])
    fun checkPrizeMoney(input: Int) {
        val prize = Prize.newInstance(input)
        Assertions.assertThat(prize.getPrizeMoney()).isEqualTo(Prize.PrizeMoney.ZERO.prizeMoney)
        Assertions.assertThat(prize.isType(Prize.PrizeMoney.ZERO)).isTrue()
    }
}
