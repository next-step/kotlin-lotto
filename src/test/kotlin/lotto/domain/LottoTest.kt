package lotto.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec

class LottoTest : StringSpec({

    "로또 번호가 6개가 아니면 예외가 발생한다." {
        listOf(0, 1, 2, 3, 4, 5).forEach { count ->
            // given
            val numbers = List(count) { it }

            // expected
            shouldThrowWithMessage<IllegalArgumentException>("로또 번호는 6개여야 합니다.") {
                Lotto(numbers)
            }
        }
    }

    "로또 번호가 중복이면 예외가 발생한다." {
        // given
        val numbers = listOf(1, 1, 2, 3, 4, 5)

        // expected
        shouldThrowWithMessage<IllegalArgumentException>("로또 번호는 중복되지 않아야 합니다.") {
            Lotto(numbers)
        }
    }
})
