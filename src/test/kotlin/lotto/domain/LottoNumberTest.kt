package lotto.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec

class LottoNumberTest : StringSpec({

    "로또 번호는 1~45 사이의 값이 아니면 예외가 발생한다." {
        listOf(0, 46).forEach { number ->
            shouldThrowWithMessage<IllegalArgumentException>("로또 번호는 1부터 45 사이 값이어야 합니다.") {
                LottoNumber(number)
            }
        }
    }
},)
