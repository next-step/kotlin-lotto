package lotto.model

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll

@DisplayName("로또 번호")
class LottoNumberTest : StringSpec({

    "1 ~ 45 사이의 숫자로 생성 가능" {
        listOf(1, 10, 20, 45).forAll {
            shouldNotThrowAny {
                LottoNumber(it)
            }
        }
    }

    "1 ~ 45 사이의 숫자가 아니면 예외 발생" {
        listOf(Int.MIN_VALUE, -1, 0, 46, Int.MAX_VALUE).forAll {
            shouldThrowExactly<IllegalArgumentException> {
                LottoNumber(it)
            }
        }
    }
})
