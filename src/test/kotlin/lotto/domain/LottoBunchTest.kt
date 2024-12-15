package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoBunchTest : StringSpec({
    "당첨 로또수를 계산한다." {
        val classUnderTest: LottoBunch =
            getLottoBunch(
                listOf(
                    Pair(listOf(1, 2, 3, 4, 5, 6), 30),
                    Pair(listOf(1, 2, 3, 4, 5, 6), 30),
                    Pair(listOf(1, 2, 3, 4, 5, 6), 30),
                    Pair(listOf(1, 2, 3, 4, 5, 6), 30),
                    Pair(listOf(1, 2, 3, 4, 5, 45), 30),
                    Pair(listOf(1, 2, 3, 4, 5, 45), 30),
                    Pair(listOf(1, 2, 3, 4, 5, 45), 30),
                    Pair(listOf(1, 2, 3, 4, 44, 45), 30),
                    Pair(listOf(1, 2, 3, 4, 44, 45), 30),
                    Pair(listOf(1, 2, 3, 43, 44, 45), 30),
                    Pair(listOf(1, 2, 3, 4, 5, 45), 15),
                    Pair(listOf(1, 2, 3, 4, 5, 45), 15),
                ),
            )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.get(it) }
        val bonusNumber = LottoNumber.get(15)
        val expected =
            mapOf(
                MatchingResult.MATCHED_THREE to 1,
                MatchingResult.MATCHED_FOUR to 2,
                MatchingResult.MATCHED_FIVE to 3,
                MatchingResult.MATCHED_SIX to 4,
                MatchingResult.MATCHED_FIVE_WITH_BONUS to 2,
            )
        classUnderTest.getMatchLottoResult(winningNumbers, bonusNumber) shouldBe expected
    }

    "수익률을 계산한다." {
        val classUnderTest: LottoBunch =
            getLottoBunch(
                listOf(
                    Pair(listOf(1, 2, 3, 4, 5, 6), 30),
                    Pair(listOf(1, 2, 3, 4, 5, 45), 15),
                    Pair(listOf(1, 2, 3, 4, 5, 45), 30),
                    Pair(listOf(1, 2, 3, 4, 44, 45), 30),
                    Pair(listOf(1, 2, 3, 43, 44, 45), 30),
                ),
            )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.get(it) }
        val bonusNumber = LottoNumber.get(15)
        val purchaseAmount = 10000
        val totalPrize = MatchingResult.entries.map { it.prizeAmount }.sum()

        classUnderTest.getYield(
            winningNumbers,
            bonusNumber,
            purchaseAmount,
        ) shouldBe totalPrize.toDouble() / purchaseAmount
    }
}) {
    private companion object {
        fun getLottoBunch(numbers: List<Pair<List<Int>, Int>>): LottoBunch =
            LottoBunch(
                numbers.map {
                    Lotto(RandomGenerator).apply {
                        setLottoByManual(
                            it.second,
                            *it.first.toIntArray(),
                        )
                    }
                },
            )
    }
}
