package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec

class LottoNumbersTest : FreeSpec({
    "유효하지 않은 번호 개수를 입력하면 예외를 발생시킨다" - {
        listOf(
            intArrayOf(),
            intArrayOf(1, 2, 3, 4, 5),
            intArrayOf(1, 2, 3, 4, 5, 6, 7),
        ).forEach { numbers ->
            "입력값: ${numbers.toList()}" {
                shouldThrow<InvalidLottoNumberCountException> { LottoNumbers(*numbers) }
            }
        }
    }
})
