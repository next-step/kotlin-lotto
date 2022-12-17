package lotto.domain.vo

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

class LotteryNumbersTest : FreeSpec({
    "추첨 번호 목록을 생성할 수 있다" {
        val set = generateSet(1, 6)
        val lotteryNumbers = LotteryNumbers(lotteryNumbers = set)
        lotteryNumbers.shouldNotBeNull()
    }

    "추첨 번호 목록의 크기는 사전에 정의한 사이즈가 아니면 생성시 에러가 난다" {
        val setOfSizeOne = setOf(LotteryNumber(1))
        shouldThrow<IllegalArgumentException> { LotteryNumbers(lotteryNumbers = setOfSizeOne) }
    }

    "추첨 번호가 들어가있는지 확인을 할 수 있다" {
        val set = generateSet(1, 6)
        val lotteryNumbers = LotteryNumbers(lotteryNumbers = set)
        val targetLotteryNumber = LotteryNumber(value = 1)
        lotteryNumbers.contains(lotteryNumber = targetLotteryNumber)
    }

    "추첨번호가 몇개 일치하는지 비교할 수 있다" {
        val set = generateSet(1, 6)
        val targetSet = generateSet(4, 9)

        val winNumbers = LotteryNumbers(lotteryNumbers = set)
        val target = LotteryNumbers(lotteryNumbers = targetSet)

        val matchedNumber = winNumbers.countEqualLotteryNumbers(target)
        matchedNumber shouldBe 3
    }
})

fun generateSet(start: Int, end: Int): Set<LotteryNumber> {
    val mutableSet = mutableSetOf<LotteryNumber>()
    for (number in start..end) {
        mutableSet.add(LotteryNumber(number))
    }
    return mutableSet.toSet()
}
