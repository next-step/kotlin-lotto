package lotto.domain.vo

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll

class LottoNumberTest : StringSpec({
    "로또 숫자를 생성할 수 있다" {
        shouldNotThrow<Throwable> { LottoNumber(1) }
    }

    "1 - 45 범위가 아닌경우 로또 숫자 생성시 Exception을 던진다" {
        listOf(-1, 46).forAll {
            shouldThrow<IllegalArgumentException> { LottoNumber(it) }
        }
    }
})
