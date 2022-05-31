package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoNumberTest : StringSpec({

    "로또 번호는 1~45 범위의 숫자를 가질 수 있다" {
        (1..45).forEach { number ->
            LottoNumber.from(number).number shouldBe number
        }
    }

    "로또 번호는 1~45 범위의 숫자를 입력하지 않은 경우 IllegalArgumentException을 발생한다" {
        forAll(
            row(0),
            row(46)
        ) { number ->
            shouldThrowExactly<IllegalArgumentException> {
                LottoNumber.from(number)
            }
        }
    }
})
