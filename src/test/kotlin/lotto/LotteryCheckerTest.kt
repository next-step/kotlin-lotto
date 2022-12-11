package lotto

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lottery
import lotto.domain.LotteryChecker
import lotto.domain.LotteryNumber
import lotto.domain.Rank

class LotteryCheckerTest : BehaviorSpec({

    Given("로또 번호와 로또 리스트로") {
        When("로또 번호 확인기가 동작되면") {
            val result = LotteryChecker(winningNumber, lotteries).run()
            Then("당첨 등수와 그에 해당하는 개수가 반환된다.") {
                result shouldBe expected
            }
        }
    }
}) {
    companion object {
        val winningNumber = listOf(1, 2, 3, 4, 5, 6)
            .map { num ->
                LotteryNumber(num)
            }
        val lotteries = listOf(
            listOf(1, 3, 5, 14, 22, 45),
            listOf(5, 9, 38, 41, 43, 44),
            listOf(2, 8, 9, 18, 19, 21)
        ).map { lotto ->
            Lottery(
                lotto.map { num ->
                    LotteryNumber(num)
                }
            )
        }
        val expected = mapOf(
            Rank.FIFTH to 1,
            Rank.FOURTH to 0,
            Rank.THIRD to 0,
            Rank.FIRST to 0
        )
    }
}
