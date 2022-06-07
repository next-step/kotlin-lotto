package lotto

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.FunSpec

internal class LottoNumberTest : FunSpec({

    test("로또 번호는 1~45 사이의 숫자이다.") {
        // given
        listOf(1, 45).forEach() {
            // when then
            shouldNotThrowAny {
                LottoNumber(it)
            }
        }
    }
})
