package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import lotto.domain.Lottery
import lotto.domain.LotteryNumber

class LotteryTest : BehaviorSpec({

    Given("로또 번호가") {
        When("중복이 존재하면") {
            val nums = listOf(1, 1, 2, 3, 4, 5)
                .map { num ->
                    LotteryNumber(num)
                }

            Then("IllegalArgumentException 예외가 발생한다.") {
                shouldThrow<IllegalArgumentException> {
                    Lottery(nums)
                }
            }
        }

        When("6개가 아니면") {
            val numsList = listOf(listOf(1, 2, 3, 4, 5, 6, 7), listOf(1, 2, 3, 4, 5))
                .map { nums ->
                    nums.map { num ->
                        LotteryNumber(num)
                    }
                }

            numsList.forAll { nums ->
                Then("IllegalArgumentException 예외가 발생한다.") {
                    shouldThrow<IllegalArgumentException> {
                        Lottery(nums)
                    }
                }
            }
        }
    }

    Given("로또가") {
        val nums = listOf(1, 3, 5, 14, 22, 45)
            .map { num ->
                LotteryNumber(num)
            }
        val lottery = Lottery(nums)

        When("몇개의 당첨번호가 매치되는지 계산하면") {
            val winningNums = listOf(1, 2, 3, 4, 5, 6)
                .map { num ->
                    LotteryNumber(num)
                }
            val result = lottery.calculateMatch(winningNums)

            Then("일치하는 번호의 개수를 반환한다.") {
                result shouldBe 3
            }
        }
    }
})
