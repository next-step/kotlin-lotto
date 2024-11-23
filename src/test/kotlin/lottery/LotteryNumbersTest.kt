package lottery

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe

class LotteryNumbersTest : StringSpec({
    "로또 하나에 6개의 랜덤번호가 들어있다" {
        LotteryNumbers.create().numbers.size shouldBe 6
    }

    "로또의 범위는 1~45이다" {
        val numbers = LotteryNumbers.create().numbers
        numbers.forAll { it shouldBeInRange 1..45 }
    }

    "로또번호들은 중복되지 않는다" {
        val numbers = LotteryNumbers.create().numbers
        numbers.distinct().size shouldBe 6
    }
})
