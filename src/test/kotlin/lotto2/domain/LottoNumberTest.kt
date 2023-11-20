package lotto2.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoNumberTest : StringSpec({

    "로또 번호는 1이상 45 사의 숫자만 생성이 가능하다." {
        forAll(
            row(1),
            row(21),
            row(30),
            row(45)
        ) { expect: Int ->
            val lottoNumber = LottoNumber(expect)

            lottoNumber.number shouldBe expect
        }
    }

    "로또 번호가 0 이하일 경우 예외가 발생한다." {
        forAll(
            row(0),
            row(-2),
            row(-20),
            row(-45)
        ) { number: Int ->
            shouldThrow<IllegalArgumentException> {
                LottoNumber(number)
            }
        }
    }

    "로또 번호가 46 이상일 경우 예외가 발생한다." {
        forAll(
            row(46),
            row(47),
            row(77),
            row(100)
        ) { number: Int ->
            shouldThrow<IllegalArgumentException> {
                LottoNumber(number)
            }
        }
    }
})
