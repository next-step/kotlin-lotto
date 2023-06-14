package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoNumberTest : StringSpec({
    "로또숫자에 1~45 외 다른 숫자를 담으면 예외가 발생한다" {
        forAll(
            row(0),
            row(46),
        ) { number ->
            val exception = shouldThrow<IllegalArgumentException> { LottoNumber(number) }

            exception.message shouldBe "1~45 범위 숫자여야 합니다."
        }
    }
})
