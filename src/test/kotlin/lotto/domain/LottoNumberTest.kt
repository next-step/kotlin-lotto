package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoNumberTest : StringSpec({
    "로또의 범위는 1 ~ 45 사이여야 한다" {
        forAll(
            row(1),
            row(45)
        ) { number ->
            val lottoNumber = LottoNumber(number)
            lottoNumber.value shouldBe number
        }
    }

    "로또 번호가 1 보다 작거나 45보다 크면 IllegalArgumentException을 발생 키신다." {
        forAll(
            row(0),
            row(46)
        ) { number ->
            val exception = shouldThrow<IllegalArgumentException> { LottoNumber(number) }

            exception.message shouldBe "로또 번호는 1 ~ 45 사이여야 합니다."
        }
    }
})
