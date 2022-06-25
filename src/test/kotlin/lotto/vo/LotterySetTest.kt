package lotto.vo

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import lotto.domain.Lottery
import lotto.domain.LotterySet
import lotto.domain.toLotteryNumberSet
import lotto.policy.LotteryWithBonusPolicy

internal class LotterySetTest : StringSpec({

    val normalLotterySet = LotterySet(
        listOf(
            Lottery(listOf(1, 2, 3, 4, 5, 6).toLotteryNumberSet()),
            Lottery(listOf(1, 2, 3, 4, 5, 7).toLotteryNumberSet()),
            Lottery(listOf(1, 2, 3, 4, 9, 8).toLotteryNumberSet()),
            Lottery(listOf(1, 2, 3, 12, 11, 10).toLotteryNumberSet()),
            Lottery(listOf(1, 2, 16, 15, 14, 13).toLotteryNumberSet()),
        )
    )
    val lastWeekNormalLottery = LotteryWithBonusPolicy(listOf(1, 2, 3, 4, 5, 6).toLotteryNumberSet(), LotteryNumber(10))

    "각 등수에 포함된 당첨자 수를 반환한다." {
        listOf(
            LotteryRank.ONE_PLACE,
            LotteryRank.TWO_PLACE,
            LotteryRank.THIRD_PLACE,
            LotteryRank.FOUR_PLACE,
            LotteryRank.NONE,

        ).forAll { rank ->
            val result = normalLotterySet.countPlace(lastWeekNormalLottery, rank)

            result shouldBe 1
        }
    }

    "투자금에 비해 당첨금의 이익률을 계산한다." {
        val result = normalLotterySet.rate(lastWeekNormalLottery)

        result shouldBe 400311.0
    }
})
