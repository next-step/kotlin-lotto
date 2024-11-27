package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll

class LottoNumberTest : StringSpec({
    "로또 번호가 1~45 범위를 벗어날 시 예외 발생한다" {
        listOf(-1, 0, 46, 47).forAll {
            shouldThrow<IllegalArgumentException> { LottoNumber(it) }
        }
    }
})
