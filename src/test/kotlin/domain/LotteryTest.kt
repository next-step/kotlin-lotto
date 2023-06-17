package domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import mock.MockNumberGenerator

class LotteryTest : StringSpec({
    "복권 생성시 랜덤 값 6개가 생성된다." {
        val lottery = Lottery()
        lottery.randomNumber.size shouldBe 6
    }

    "복권 랜덤 값은 1부터 45 사이 값이다." {
        val lottery = Lottery()
        lottery.randomNumber.forEach { it in 1..45 }
    }

    "복권에 일치하는 값 개수를 찾는다." {
        listOf(
            setOf(1, 2, 3, 8, 7, 9) to 3,
            setOf(1, 2, 3, 4, 7, 8) to 4,
            setOf(1, 2, 3, 4, 5, 7) to 5,
            setOf(1, 2, 3, 4, 5, 6) to 6
        ).forAll { (input, expected) ->
            val lottery = Lottery(MockNumberGenerator(input))
            val countMatchingLottery = lottery.getPrizeByLottery(setOf(1, 2, 3, 4, 5, 6))
            countMatchingLottery!!.matches shouldBe expected
        }
    }

    "2등과 3등을 구분할 수 있다." {
        listOf(
            setOf(1, 2, 3, 4, 5, 7) to Prize.SECOND_PLACE,
            setOf(1, 2, 3, 4, 5, 8) to Prize.THIRD_PLACE
        ).forAll { (input, expected) ->
            val lottery = Lottery(MockNumberGenerator(input))
            val countMatchingLottery = lottery.getPrizeByLottery(setOf(1, 2, 3, 4, 5, 6), 7)
            countMatchingLottery shouldBe expected
        }
    }

    "2등 당첨 시 3_000_000을 지급한다." {
        val lottery = Lottery(MockNumberGenerator(setOf(1, 2, 3, 4, 5, 7)))
        val countMatchingLottery = lottery.getPrizeByLottery(setOf(1, 2, 3, 4, 5, 6), 7)
        countMatchingLottery shouldBe Prize.SECOND_PLACE
        countMatchingLottery!!.prizeMoney shouldBe 3_000_000
    }
})
