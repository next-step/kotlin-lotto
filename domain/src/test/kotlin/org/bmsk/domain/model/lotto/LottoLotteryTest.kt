package org.bmsk.domain.model.lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoLotteryTest : FunSpec({

    test("sorted 함수를 사용하면 로또 번호를 정렬할 수 있다.") {
        val numbers = listOf(1, 45, 2, 44, 3, 43)
        val lottery = LottoLottery(numbers)
        val sortedLottery = lottery.sorted()
        numbers.sorted() shouldBe sortedLottery.numbers
    }

    test("contains 함수를 사용하면 특정 번호가 포함되어 있는지 알 수 있다.") {
        val number = 3
        val lottery = LottoLottery(listOf(1, 2, 3, 4, 5, 6))

        lottery.contains(number) shouldBe true
    }

    test("중복된 숫자로 생성하면 예외를 발생시킨다.") {
        shouldThrow<IllegalArgumentException> {
            LottoLottery(listOf(1, 1, 1, 1, 1, 1))
        }
    }
})
