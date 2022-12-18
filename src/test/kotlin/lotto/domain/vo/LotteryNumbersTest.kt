package lotto.domain.vo

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import lotto.domain.enums.Prize

class LotteryNumbersTest : FreeSpec({
    "추첨 번호 목록을 생성할 수 있다" {
        val list = generateList(1, 6)
        val lotteryNumbers = LotteryNumbers(lotteryNumbers = list)
        lotteryNumbers.shouldNotBeNull()
    }

    "추첨 번호 목록의 크기는 사전에 정의한 사이즈가 아니면 생성시 에러가 난다" {
        val listOfSizeOne = listOf(LotteryNumber(1))
        shouldThrow<IllegalArgumentException> { LotteryNumbers(lotteryNumbers = listOfSizeOne) }
    }

    "추첨 번호가 들어가있는지 확인을 할 수 있다" {
        val list = generateList(1, 6)
        val lotteryNumbers = LotteryNumbers(lotteryNumbers = list)
        val targetLotteryNumber = LotteryNumber(value = 1)
        lotteryNumbers.contains(lotteryNumber = targetLotteryNumber)
    }

    "추첨번호가 일치하는 상품을 가져올 수 있다" {
        val list = generateList(1, 6)
        val targetList = generateList(4, 9)

        val winNumbers = LotteryNumbers(lotteryNumbers = list)
        val target = LotteryNumbers(lotteryNumbers = targetList)

        val prize = winNumbers.findPrize(target)
        prize shouldBe Prize.FOURTH
    }
})

fun generateList(start: Int, end: Int): List<LotteryNumber> {
    val mutableSet = mutableSetOf<LotteryNumber>()
    for (number in start..end) {
        mutableSet.add(LotteryNumber(number))
    }
    return mutableSet.toList()
}
