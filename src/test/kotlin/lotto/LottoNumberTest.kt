package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import lotto.domain.LottoNumber
import java.lang.IllegalArgumentException

class LottoNumberTest : FreeSpec({
    "1~45 사이의 로또 숫자를 생성할 수 있다" {
        listOf(1, 2, 3, 4, 5, 45).map(::LottoNumber).toSet()
    }

    "1~45 범위 외의 로또숫자는 생성하지 못한다." {
        val exception = shouldThrow<IllegalArgumentException> {
            listOf(1, 2, 3, 4, 5, 66).map(::LottoNumber).toSet()
        }
        println(exception.message)
    }
})
