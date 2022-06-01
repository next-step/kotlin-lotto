package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.infra.port.NumberGenerator
import lotto.vo.LotteryNumber
import lotto.vo.LotteryNumberSet

internal class LotteryTest : BehaviorSpec({

    given("주어진 번호가") {
        val lotteryNumberSet = listOf(1, 2, 3, 4, 5, 6).toLotteryNumberSet()
        val lottery = Lottery(lotteryNumberSet)

        `when`("포함된 경우") {
            val result = lottery.contains(LotteryNumber.of(1))

            then("true") {
                result shouldBe true
            }
        }

        `when`("포함되지 않은 경우") {
            val result = lottery.contains(LotteryNumber.of(7))

            then("false") {
                result shouldBe false
            }
        }
    }
})

class StubNumberGenerator(private val actualNumbers: List<Int>) : NumberGenerator<LotteryNumberSet> {

    override fun generate(): LotteryNumberSet =
        actualNumbers.map(LotteryNumber::of).let(::LotteryNumberSet)
}

fun List<Int>.toLotteryNumberSet() = map(LotteryNumber::of).let(::LotteryNumberSet)
