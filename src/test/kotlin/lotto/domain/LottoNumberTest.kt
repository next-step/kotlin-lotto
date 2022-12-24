package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import java.lang.IllegalArgumentException

class LottoNumberTest: StringSpec({
    "로또 숫자는 1이상 43이하의 숫자만 가질 수 있어요." {
        forAll(
            row(0), row(44),
        ) { number ->
            shouldThrow<IllegalArgumentException> {
                LottoNumber(number)
            }
        }
    }
})