package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class NumbersTest : FunSpec({

    test("입력받은 숫자 리스트와 일치하는 숫자 개수를 반환할 수 있다.") {
        // given
        val numbers = Numbers(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 7)
        val expected = 5

        // when
        val actual = numbers.countMatchingNumbers(winningNumbers)

        // then
        actual shouldBe expected
    }
})
