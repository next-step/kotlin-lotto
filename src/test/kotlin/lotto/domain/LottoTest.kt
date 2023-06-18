package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class LottoTest : StringSpec({
    "로또 번호는 6개이다." {
        shouldNotThrowAny {
            generateLotto(1, 2, 3, 4, 5, 6)
        }
    }

    "로또 번호가 6개가 아니면 예외를 던진다." {
        shouldThrow<IllegalArgumentException> {
            generateLotto(1, 2, 3, 4, 5)
        }

        shouldThrow<IllegalArgumentException> {
            generateLotto(1, 2, 3, 4, 5, 6, 7)
        }
    }

    "로또 번호중에 중복되는 숫자가 있으면 예외를 던진다." {
        shouldThrow<IllegalArgumentException> {
            generateLotto(1, 1, 2, 3, 4, 5)
        }
    }
})

fun generateLotto(vararg number: Int): Lotto {
    val lottoNumbers = number.toList().map { LottoNumber(it) }
    return Lotto(lottoNumbers)
}
