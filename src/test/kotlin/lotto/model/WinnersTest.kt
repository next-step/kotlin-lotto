package lotto.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class WinnersTest {

    @DisplayName(value = "여러 WinnerType(등수)이 섞여 있을때, 등수를 잘 가져와야한다.")
    @Test
    fun checkPrizeMoneyCase6() {
        val list = mutableListOf<Prize>().apply {
            add(Prize.newInstance(Prize.PrizeMoney.ONE.matchingCount))
            add(Prize.newInstance(Prize.PrizeMoney.ONE.matchingCount))
            add(Prize.newInstance(Prize.PrizeMoney.ONE.matchingCount))
            add(Prize.newInstance(Prize.PrizeMoney.TWO.matchingCount))
            add(Prize.newInstance(Prize.PrizeMoney.THREE.matchingCount))
            add(Prize.newInstance(Prize.PrizeMoney.FOUR.matchingCount))
            add(Prize.newInstance(Prize.PrizeMoney.ZERO.matchingCount))
        }
        val winners = Winners(list)
        Assertions.assertThat(winners.getWinnerType(Prize.PrizeMoney.ONE).size).isSameAs(3)
    }

    @DisplayName(value = "하나도 당첨되지 않았을 경우, 전체 수익률을 0 ")
    @Test
    fun checkWinnersTotalYieldZero() {
        val list = mutableListOf<Prize>().apply {
            add(Prize.newInstance(Prize.PrizeMoney.ZERO.matchingCount))
            add(Prize.newInstance(Prize.PrizeMoney.ZERO.matchingCount))
        }
        val winners = Winners(list)
        Assertions.assertThat(winners.getTotalYield()).isEqualTo(0.0)
    }

    @DisplayName(value = "하나 이상 당첨되었을 경우, 전체 수익률을 1.0보다 커야한다. ")
    @ParameterizedTest
    @ValueSource(ints = [3, 4, 5, 6])
    fun checkWinnersTotalYield(input: Int) {
        val list = mutableListOf<Prize>().apply {
            add(Prize.newInstance(input))
        }
        val winners = Winners(list)
        Assertions.assertThat(winners.getTotalYield()).isGreaterThan(1.0)
    }
}
