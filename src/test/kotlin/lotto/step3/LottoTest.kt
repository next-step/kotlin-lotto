package lotto.step3

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.step3.domain.Lotto

class LottoTest : FunSpec({
    test("로또를 처음 생성하면 numbers의 개수는 6이다.") {
        // given
        val givenNumbers = listOf(1, 2, 3, 4, 5, 6)

        // when
        val result = Lotto.of(givenNumbers)

        // then
        result.numbers.size shouldBe 6
    }

    test("로또를 생성할 때 중복된 번호가 있으면 IllegalArgumentException이 발생한다.") {
        // given
        val givenNumbers = listOf(1, 1, 2, 3, 4, 5)

        // when & then
        shouldThrow<IllegalArgumentException> {
            Lotto.of(givenNumbers)
        }
    }
})
