package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class LottoNumberTest : StringSpec({
    "로또 번호는 1부터 45까지의 숫자이다." {
        listOf(1, 2, 45)
            .forEach {
                shouldNotThrowAny { LottoNumber(it) }
            }
    }

    "로또 번호가 1보다 작으면 예외를 던진다." {
        listOf(-1, 0)
            .forEach {
                shouldThrow<IllegalArgumentException> { LottoNumber(it) }
            }
    }

    "로또 번호가 45보다 크면 예외를 던진다." {
        listOf(46, 47)
            .forEach {
                shouldThrow<IllegalArgumentException> { LottoNumber(it) }
            }
    }
})
