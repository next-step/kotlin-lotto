package lottery

import io.kotest.assertions.throwables.shouldThrow
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

    "로또 번호가 6개가 아니면 예외 발생한다" {
        shouldThrow<IllegalArgumentException> { LotteryNumbers(List(size = 7) { 0 }) }
    }

    "로또 번호 중복일 시 예외 발생한다" {
        shouldThrow<IllegalArgumentException> { LotteryNumbers(listOf(1,1,1,1,1,1)) }
    }

    "로또 번호가 1~45 범위를 벗어날 시 예외 발생한다" {
        listOf(0,-1,46,47).forAll { overNumber ->
            shouldThrow<IllegalArgumentException> { LotteryNumbers(listOf(overNumber,1,1,1,1,1)) }
        }
    }
})
