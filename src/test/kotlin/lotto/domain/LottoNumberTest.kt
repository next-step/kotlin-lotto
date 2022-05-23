package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class LottoNumberTest : StringSpec({

    "숫자를 받아 인스턴스를 생성한다" {
        val lottoNumber = LottoNumber(1)

        lottoNumber.value shouldBe 1
    }

    "1과 45 사이의 값을 제공하지 않으면 에러가 발생한다" {
        shouldThrow<java.lang.IllegalArgumentException> {
            LottoNumber(-1)
        }
        shouldThrow<java.lang.IllegalArgumentException> {
            LottoNumber(46)
        }
    }
})
