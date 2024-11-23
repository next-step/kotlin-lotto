package lottery

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe

class LotteryTest : StringSpec({
    "원하는 갯수만큼 로또를 생성한다" {
        val lotteries = LotteryMachine.buy(1)
        lotteries.size shouldBe 1
    }

    "로또 하나에 6개의 랜덤번호가 들어있다" {
        Lottery.create().lotteryNumbers.numbers.size shouldBe 6
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
