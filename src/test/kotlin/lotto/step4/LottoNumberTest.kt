package lotto.step4

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.step4.domain.LottoNumber

class LottoNumberTest : FunSpec({
    test("로또 번호는 1부터 45까지의 숫자이다.") {
        // given
        (1..45).forEach { number ->
            // when, then
            shouldNotThrow<IllegalArgumentException> {
                LottoNumber(number)
            }
        }
    }

    test("로또 번호는 1부터 45까지의 숫자가 아니면 예외를 던진다.") {
        // given
        val invalidNumber = 46

        // when, then
        shouldThrow<IllegalArgumentException> {
            LottoNumber(invalidNumber)
        }.message shouldBe "로또 번호는 1부터 45까지의 숫자여야 합니다. [number=$invalidNumber]"
    }
})
