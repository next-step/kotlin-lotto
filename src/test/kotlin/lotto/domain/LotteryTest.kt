package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.infra.port.NumberGenerator
import lotto.vo.LotteryNumber

internal class LotteryTest : StringSpec({

    "주어진 번호가 로또 번호에 포함된 경우 참을 반환한다." {
        val lotteryNumberSet = listOf(1, 2, 3, 4, 5, 6).toLotteryNumberSet()
        val lottery = Lottery(lotteryNumberSet)

        val result = lottery.contains(LotteryNumber.of(1))

        result shouldBe true
    }

    "주어진 번호가 로또 번호에 포함되지 않은 경우 거짓을 반환한다." {
        val lotteryNumberSet = listOf(1, 2, 3, 4, 5, 6).toLotteryNumberSet()
        val lottery = Lottery(lotteryNumberSet)

        val result = lottery.contains(LotteryNumber.of(7))

        result shouldBe false
    }
})

class StubNumberGenerator(private val actualNumbers: List<Int>) : NumberGenerator<LotteryNumberSet> {

    override fun generate(): LotteryNumberSet =
        actualNumbers.map(LotteryNumber::of).let(::LotteryNumberSet)
}

fun List<Int>.toLotteryNumberSet() = map(LotteryNumber::of).let(::LotteryNumberSet)
