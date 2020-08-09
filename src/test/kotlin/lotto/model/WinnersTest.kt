package lotto.model

import lotto.model.prize.Prize
import lotto.model.prize.Winners
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class WinnersTest {

    @DisplayName(value = "여러 WinnerType(등수)이 섞여 있을때, 등수를 잘 가져와야한다.")
    @Test
    fun checkPrizeMoneyCase6() {
        val list = mutableListOf<Prize>().apply {
            add(Prize.getPrize(Prize.ONE.matchingCount))
            add(Prize.getPrize(Prize.ONE.matchingCount))
            add(Prize.getPrize(Prize.ONE.matchingCount))
            add(Prize.getPrize(Prize.TWO.matchingCount))
            add(Prize.getPrize(Prize.THREE.matchingCount))
            add(Prize.getPrize(Prize.FOUR.matchingCount))
            add(Prize.getPrize(Prize.ZERO.matchingCount))
        }
        val winners = Winners(list)
        assertThat(winners.getPrizeCount(Prize.ONE)).isSameAs(3)
    }

    @DisplayName(value = "하나도 당첨되지 않았을 경우, 전체 수익률을 0 ")
    @Test
    fun checkWinnersTotalYieldZero() {
        val list = mutableListOf<Prize>().apply {
            add(Prize.getPrize(Prize.ZERO.matchingCount))
            add(Prize.getPrize(Prize.ZERO.matchingCount))
        }
        val winners = Winners(list)
        assertThat(winners.getTotalYield()).isEqualTo(0.0)
    }

    @DisplayName(value = "하나 이상 당첨되었을 경우, 전체 수익률을 1.0보다 커야한다. ")
    @ParameterizedTest
    @ValueSource(ints = [3, 4, 5, 6])
    fun checkWinnersTotalYield(input: Int) {
        val list = mutableListOf<Prize>().apply {
            add(Prize.getPrize(input))
        }
        val winners = Winners(list)
        assertThat(winners.getTotalYield()).isGreaterThan(1.0)
    }
}
