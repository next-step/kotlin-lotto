package lotto.vo

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lottery

internal class LottoSetTest : BehaviorSpec({

    given("로또 번호들 중") {
        val lotterySet = LottoSet(
            listOf(
                Lottery(listOf(1, 2, 3, 4, 5, 6)),

                Lottery(listOf(1, 2, 3, 4, 5, 7)),
                Lottery(listOf(1, 2, 3, 4, 5, 7)),

                Lottery(listOf(1, 2, 3, 4, 9, 8)),
                Lottery(listOf(1, 2, 3, 4, 9, 8)),
                Lottery(listOf(1, 2, 3, 4, 9, 8)),

                Lottery(listOf(1, 2, 3, 12, 11, 10)),
                Lottery(listOf(1, 2, 3, 12, 11, 10)),
                Lottery(listOf(1, 2, 3, 12, 11, 10)),
                Lottery(listOf(1, 2, 3, 12, 11, 10)),

                Lottery(listOf(1, 2, 16, 15, 14, 13)),
                Lottery(listOf(1, 2, 16, 15, 14, 13)),
                Lottery(listOf(1, 2, 16, 15, 14, 13)),
                Lottery(listOf(1, 2, 16, 15, 14, 13)),
                Lottery(listOf(1, 2, 16, 15, 14, 13)),
            )
        )
        val lastWeekLottery = Lottery(listOf(1, 2, 3, 4, 5, 6))

        `when`("1등 당첨자 조회시") {
            val result = lotterySet.countPlace(lastWeekLottery, LottoScore.ONE_PLACE)

            then("1등 당첨자 수를 반환한다.") {
                result shouldBe 1
            }
        }

        `when`("2등 당첨자 조회시") {
            val result = lotterySet.countPlace(lastWeekLottery, LottoScore.TWO_PLACE)

            then("2등 당첨자 수를 반환한다.") {
                result shouldBe 2
            }
        }

        `when`("3등 당첨자 조회시") {
            val result = lotterySet.countPlace(lastWeekLottery, LottoScore.THIRD_PLACE)

            then("3등 당첨자 수를 반환한다.") {
                result shouldBe 3
            }
        }

        `when`("4등 당첨자 조회시") {
            val result = lotterySet.countPlace(lastWeekLottery, LottoScore.FOUR_PLACE)

            then("4등 당첨자 수를 반환한다.") {
                result shouldBe 4
            }
        }

        `when`("꽝 조회시") {
            val result = lotterySet.countPlace(lastWeekLottery, LottoScore.NONE)

            then("꽝 수를 반환한다.") {
                result shouldBe 5
            }
        }

        `when`("결과를 기준으로 그룹핑 시") {
            val result = lotterySet.groupPlace(lastWeekLottery)

            then("각 등수의 당첨자 수를 Map으로 반환한다.") {
                result[LottoScore.ONE_PLACE] shouldBe 1
                result[LottoScore.TWO_PLACE] shouldBe 2
                result[LottoScore.THIRD_PLACE] shouldBe 3
                result[LottoScore.FOUR_PLACE] shouldBe 4
                result[LottoScore.NONE] shouldBe 5
            }
        }

        `when`("수익률 계산 시") {
            val result = lotterySet.rate(lastWeekLottery)

            then("구매비용 대비 당첨금의 수익률을 반환한다.") {
                result shouldBe 133544.0
            }
        }
    }
})
