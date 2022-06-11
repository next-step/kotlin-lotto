package lotto

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec

internal class LottoNumberTest : FunSpec({

    test("로또 번호는 1~45 사이의 숫자이다.") {
        // given
        listOf(1, 45).forEach() {
            // when then
            shouldNotThrowAny {
                LottoNumber.of(it)
            }
        }
    }

    test("로또 번호가 1~45 사이의 숫자가 아니라면 예외가 발생한다.") {
        // given
        listOf(-1, 0, 46).forEach() {
            // when then
            shouldThrow<IllegalArgumentException> {
                LottoNumber.of(it)
            }
        }
    }
})
