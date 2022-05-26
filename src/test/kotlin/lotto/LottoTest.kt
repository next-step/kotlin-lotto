package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class LottoTest : FreeSpec({
    "로또의 숫자는" - {
        "중복되지 않는 6개의 숫자이다" {
            val numbers = listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber).toSet()
            val lotto = Lotto(numbers)
            lotto.numbers.size shouldBe 6
        }
        "6개 미만인 경우 에러" {
            val numbers = listOf(1, 2, 3, 4, 6, 6).map(::LottoNumber).toSet()
            val exception = shouldThrow<IllegalArgumentException> {
                Lotto(numbers)
            }
            println(exception.message)
        }
        "6개 초과인 경우 에러" {
            val numbers = listOf(1, 2, 3, 4, 5, 6, 7).map(::LottoNumber).toSet()
            val exception = shouldThrow<IllegalArgumentException> {
                Lotto(numbers)
            }
            println(exception.message)
        }
    }
})
