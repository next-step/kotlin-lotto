package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumber

class LottoNumberTest : StringSpec({
    "로또 숫자의 최소 수는 0이다." {
        val minNumber = LottoNumber.NUMBERS.minOf { (number, _) -> number }
        minNumber shouldBe 0
    }

    "로또 숫자의 최대 수는 45이다." {
        val maxNumber = LottoNumber.NUMBERS.maxOf { (number, _) -> number }
        maxNumber shouldBe 45
    }

    "로또 숫자 범위가 아니면 예외 발생한다." {
        forAll(
            row(-1),
            row(100),
        ) { number ->
            shouldThrow<IllegalArgumentException> {
                LottoNumber.from(number)
            }
        }
    }
})
