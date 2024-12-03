package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoNumberTest : FreeSpec({
    "유효하지 않은 번호 값을 입력하면 예외를 발생시킨다" - {
        listOf(-1, 0, 46).forEach { number ->
            "입력값: $number" {
                shouldThrow<InvalidLottoNumberException> { LottoNumber(number) }
            }
        }
    }
})
