package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LotteryPrizeAmountTest {

    @ParameterizedTest
    @CsvSource(
        value = [
            "0, false, MISS",
            "3, false, FIFTH",
            "4, false, FOURTH",
            "5, false, THIRD",
            "5, true, SECOND",
            "6, false, FIRST",
        ],
    )
    fun `로또를 몇 개 맞췄느냐에 따라서 등수 정보를 얻을 수 있습니다`(winNum: Int, bonusMatch: Boolean, expected: String) {
        val winningPrize = LotteryPrizeAmount.getWinningPrize(winNum, bonusMatch)
        winningPrize shouldBe LotteryPrizeAmount.valueOf(expected)
    }
}
