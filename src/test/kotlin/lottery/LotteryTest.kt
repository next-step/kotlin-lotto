package lottery

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LotteryMachine {
    companion object {
        fun buy(count: Int): List<Lottery> {
            return List(count) { Lottery.create() }
        }
    }
}

class Lottery(val numbers: Numbers) {
    companion object {
        fun create(): Lottery {
            return Lottery(Numbers.create())
        }
    }
}

class Numbers(numbers: List<Int>) {
    val size = numbers.size

    companion object {
        fun create(): Numbers {
            val numbers = (1..45).shuffled().take(6).sorted()
            return Numbers(numbers)
        }
    }
}

class LotteryTest : StringSpec({
    "원하는 갯수만큼 로또를 생성한다" {
        val lotteries = LotteryMachine.buy(1)
        lotteries.size shouldBe 1
    }

    "로또 하나에 6개의 랜덤번호가 들어있다" {
        Lottery.create().numbers.size shouldBe 6
    }
})
