package lotto.domain

import lotto.entity.Lottery
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class DrawTest {
    private val draw = Draw()
    private val lotteryPrice = 1000

    @DisplayName(value = "구입금액으로 산 갯수를 계산한다")
    @ParameterizedTest
    @ValueSource(ints = [1000, 100000, 1000000])
    fun calculateBuyNum(num: Int) {
        assertThat(draw.calculateBuyNum(num)).isEqualTo(num / lotteryPrice)
    }

    @DisplayName(value = "로또 당첨 갯수를 계산한다")
    @Test
    fun calculateWin() {
        val winNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lotteries = listOf(Lottery(listOf(1, 2, 3, 11, 12, 13)), Lottery(listOf(1, 2, 3, 4, 5, 6)))
        val winLotteryResult = draw.calculateWin(winNumbers, lotteries)
        assertThat(winLotteryResult.matchThree.matchNum).isEqualTo(1)
        assertThat(winLotteryResult.matchSix.matchNum).isEqualTo(1)
    }

}
