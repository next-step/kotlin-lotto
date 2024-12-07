package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoBunchTest : StringSpec({
    "당첨 로또수를 계산한다." {
        val classUnderTest: LottoBunch =
            getLottoBunch(
                listOf(
                    listOf(1, 2, 3, 4, 5, 6),
                    listOf(1, 2, 3, 4, 5, 6),
                    listOf(1, 2, 3, 4, 5, 6),
                    listOf(1, 2, 3, 4, 5, 6),
                    listOf(1, 2, 3, 4, 5, 45),
                    listOf(1, 2, 3, 4, 5, 45),
                    listOf(1, 2, 3, 4, 5, 45),
                    listOf(1, 2, 3, 4, 44, 45),
                    listOf(1, 2, 3, 4, 44, 45),
                    listOf(1, 2, 3, 43, 44, 45),
                ),
            )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.get(it) }
        val expected =
            mapOf(
                MatchingResult.MATCHED_THREE to 1,
                MatchingResult.MATCHED_FOUR to 2,
                MatchingResult.MATCHED_FIVE to 3,
                MatchingResult.MATCHED_SIX to 4,
            )
        classUnderTest.getMatchLottoResult(winningNumbers) shouldBe expected
    }

    "수익률을 계산한다." {
        val classUnderTest: LottoBunch =
            getLottoBunch(
                listOf(
                    listOf(1, 2, 3, 4, 5, 6),
                    listOf(1, 2, 3, 4, 5, 45),
                    listOf(1, 2, 3, 4, 44, 45),
                    listOf(1, 2, 3, 43, 44, 45),
                ),
            )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.get(it) }
        val purchaseAmount = 10000
        val totalPrize = MatchingResult.entries.map { it.prizeAmount }.sum()

        classUnderTest.getYield(winningNumbers, purchaseAmount) shouldBe totalPrize.toDouble() / purchaseAmount
    }
}) {
    private companion object {
        fun getLottoBunch(numbers: List<List<Int>>): LottoBunch =
            LottoBunch(numbers.map { Lotto(RandomGenerator).apply { setLottoByManual(*it.toIntArray()) } })
    }
}
