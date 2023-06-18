package domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import mock.MockNumberGenerator

class LotteryTest : StringSpec({
    "복권 생성시 랜덤 값 6개가 생성된다." {
        val lottery = Lottery()
        lottery.randomNumbers.size shouldBe 6
    }

    "복권 랜덤 값은 1부터 45 사이 값이다." {
        val lottery = Lottery()
        lottery.randomNumbers.forEach { it shouldBeInRange 1..45 }
    }

    "복권에 일치하는 값 개수를 찾는다." {
        listOf(
            listOf(1, 2, 3, 8, 7, 9) to 3,
            listOf(1, 2, 3, 4, 7, 8) to 4,
            listOf(1, 2, 3, 4, 5, 7) to 5,
            listOf(1, 2, 3, 4, 5, 6) to 6
        ).forAll { (input, expected) ->
            val lottery = Lottery(MockNumberGenerator(input))
            val countMatchingLottery = lottery.countMatchingLottery(listOf(1, 2, 3, 4, 5, 6))
            countMatchingLottery shouldBe expected
        }
    }
})
