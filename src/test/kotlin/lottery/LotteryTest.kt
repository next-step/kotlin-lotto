package lottery

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe

class LotteryMachine {
    companion object {
        fun buy(count: Int): List<Lottery> {
            return List(count) { Lottery.create() }
        }
    }
}

class Lottery(val lotteryNumbers: LotteryNumbers) {
    companion object {
        fun create(): Lottery {
            return Lottery(LotteryNumbers.create())
        }
    }
}

data class LotteryNumbers(val numbers: List<Int>) {
    val size = numbers.size

    companion object {
        fun create(): LotteryNumbers {
            val numbers = (1..45).shuffled().take(6).sorted()
            return LotteryNumbers(numbers)
        }
    }
}

class LotteryTest : StringSpec({
    "원하는 갯수만큼 로또를 생성한다" {
        val lotteries = LotteryMachine.buy(1)
        lotteries.size shouldBe 1
    }

    "로또 하나에 6개의 랜덤번호가 들어있다" {
        Lottery.create().lotteryNumbers.size shouldBe 6
    }

    "로또의 범위는 1~45이다" {
        val numbers = Lottery.create().lotteryNumbers.numbers
        numbers.forAll { it shouldBeInRange 1..45 }
    }

    "로또번호들은 중복되지 않는다" {
        val numbers = Lottery.create().lotteryNumbers.numbers
        numbers.distinct().size shouldBe 6
    }
})
