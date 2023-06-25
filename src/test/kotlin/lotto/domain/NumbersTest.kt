package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumbers.Companion.toNumbers
import java.lang.IllegalArgumentException

class NumbersTest : FunSpec({

    test("요소 사이즈가 6이 아닐 경우, IllegalArgumentException 을 반환한다.") {
        // given
        val values = listOf(LottoNumber(1))
        listOf(
            listOf(LottoNumber(1)),
            listOf(LottoNumber(1), LottoNumber(2))
        ).forAll {
            // when, then
            shouldThrow<IllegalArgumentException> { LottoNumbers(values) }
        }
    }

    test("입력받은 숫자 리스트와 일치하는 숫자 개수를 반환할 수 있다.") {
        // given
        val numbers = listOf(1, 2, 3, 4, 5, 6).toNumbers()
        val winningNumbers = listOf(1, 2, 3, 4, 5, 7).toNumbers()
        val expected = 5

        // when
        val actual = numbers.countMatchingNumbers(winningNumbers)

        // then
        actual shouldBe expected
    }
})
