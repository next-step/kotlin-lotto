package lotto.vo

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import lotto.domain.vo.LotteryNumber
import lotto.domain.vo.LotteryNumbers

class LotteryNumbersTest : FreeSpec({
    "추첨 번호 목록을 생성할 수 있다" {
        val list = setOf(LotteryNumber(1), LotteryNumber(2), LotteryNumber(3), LotteryNumber(4), LotteryNumber(5), LotteryNumber(6))
        val lotteryNumbers = LotteryNumbers(lotteryNumbers = list)
        lotteryNumbers.shouldNotBeNull()
    }

    "추첨 번호 목록의 크기는 사전에 정의한 사이즈가 아니면 생성시 에러가 난다" {
        val listOfSizeOne = setOf(LotteryNumber(1))
        shouldThrow<IllegalArgumentException> { LotteryNumbers(lotteryNumbers = listOfSizeOne) }
    }

    "추첨 번호가 들어가있는지 확인을 할 수 있다" {
        val list = setOf(LotteryNumber(1), LotteryNumber(2), LotteryNumber(3), LotteryNumber(4), LotteryNumber(5), LotteryNumber(6))
        val lotteryNumbers = LotteryNumbers(lotteryNumbers = list)
        val targetLotteryNumber = LotteryNumber(value = 1)
        lotteryNumbers.contains(lotteryNumber = targetLotteryNumber)
    }
})
