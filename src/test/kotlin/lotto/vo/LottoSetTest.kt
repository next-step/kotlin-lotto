package lotto.vo

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.NormalLottery

internal class LottoSetTest : BehaviorSpec({

    given("로또 번호들 중") {
        val normalLotterySet = LottoSet(
            listOf(
                NormalLottery(listOf(1, 2, 3, 4, 5, 6)),

                NormalLottery(listOf(1, 2, 3, 4, 5, 7)),
                NormalLottery(listOf(1, 2, 3, 4, 5, 7)),

                NormalLottery(listOf(1, 2, 3, 4, 9, 8)),
                NormalLottery(listOf(1, 2, 3, 4, 9, 8)),
                NormalLottery(listOf(1, 2, 3, 4, 9, 8)),

                NormalLottery(listOf(1, 2, 3, 12, 11, 10)),
                NormalLottery(listOf(1, 2, 3, 12, 11, 10)),
                NormalLottery(listOf(1, 2, 3, 12, 11, 10)),
                NormalLottery(listOf(1, 2, 3, 12, 11, 10)),

                NormalLottery(listOf(1, 2, 16, 15, 14, 13)),
                NormalLottery(listOf(1, 2, 16, 15, 14, 13)),
                NormalLottery(listOf(1, 2, 16, 15, 14, 13)),
                NormalLottery(listOf(1, 2, 16, 15, 14, 13)),
                NormalLottery(listOf(1, 2, 16, 15, 14, 13)),
            )
        )
        val lastWeekNormalLottery = NormalLottery(listOf(1, 2, 3, 4, 5, 6))

        `when`("1등 당첨자 조회시") {
            val result = normalLotterySet.countPlace(lastWeekNormalLottery, LotteryRank.ONE_PLACE)

            then("1등 당첨자 수를 반환한다.") {
                result shouldBe 1
            }
        }

        `when`("2등 당첨자 조회시") {
            val result = normalLotterySet.countPlace(lastWeekNormalLottery, LotteryRank.TWO_PLACE)

            then("2등 당첨자 수를 반환한다.") {
                result shouldBe 2
            }
        }

        `when`("3등 당첨자 조회시") {
            val result = normalLotterySet.countPlace(lastWeekNormalLottery, LotteryRank.THIRD_PLACE)

            then("3등 당첨자 수를 반환한다.") {
                result shouldBe 3
            }
        }

        `when`("4등 당첨자 조회시") {
            val result = normalLotterySet.countPlace(lastWeekNormalLottery, LotteryRank.FOUR_PLACE)

            then("4등 당첨자 수를 반환한다.") {
                result shouldBe 4
            }
        }

        `when`("꽝 조회시") {
            val result = normalLotterySet.countPlace(lastWeekNormalLottery, LotteryRank.NONE)

            then("꽝 수를 반환한다.") {
                result shouldBe 5
            }
        }

        `when`("결과를 기준으로 그룹핑 시") {
            val result = normalLotterySet.groupPlace(lastWeekNormalLottery)

            then("각 등수의 당첨자 수를 Map으로 반환한다.") {
                result[LotteryRank.ONE_PLACE] shouldBe 1
                result[LotteryRank.TWO_PLACE] shouldBe 2
                result[LotteryRank.THIRD_PLACE] shouldBe 3
                result[LotteryRank.FOUR_PLACE] shouldBe 4
                result[LotteryRank.NONE] shouldBe 5
            }
        }

        `when`("수익률 계산 시") {
            val result = normalLotterySet.rate(lastWeekNormalLottery)

            then("구매비용 대비 당첨금의 수익률을 반환한다.") {
                result shouldBe 133544.67
            }
        }
    }
})
