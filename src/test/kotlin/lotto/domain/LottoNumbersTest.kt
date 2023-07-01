package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class LottoNumbersTest : FunSpec({

    test("요소 사이즈가 6이 아닐 경우, IllegalArgumentException 을 반환한다.") {
        shouldThrow<IllegalArgumentException> { LottoNumbers(1, 2) }
            .also {
                it.message shouldBe "로또 사이즈는 $LOTTO_SIZE 입니다. [입력 사이즈: 2]"
            }
    }

    test("입력받은 숫자 리스트와 일치하는 숫자 개수를 반환할 수 있다.") {
        // given
        val numbers = LottoNumbers(1, 2, 3, 4, 5, 6)
        val winningNumbers = LottoNumbers(1, 2, 3, 4, 5, 7)
        val expected = 5

        // when
        val actual = numbers.countMatchingNumbers(winningNumbers)

        // then
        actual shouldBe expected
    }
})
