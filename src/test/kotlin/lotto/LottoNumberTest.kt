package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import lotto.domain.LottoNumber
import java.lang.IllegalArgumentException

class LottoNumberTest : FreeSpec({
    "로또의 숫자가 1~45 사이가 아닌경우 에러" {
        val exception = shouldThrow<IllegalArgumentException> {
            listOf(1, 2, 3, 4, 5, 66).map(::LottoNumber).toSet()
        }
        println(exception.message)
    }
})
