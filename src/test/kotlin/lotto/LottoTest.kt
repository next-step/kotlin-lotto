package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class LottoTest : FreeSpec({
    "유효하지 않은 번호 개수를 입력하면 예외를 발생시킨다" - {
        listOf(
            emptySet(),
            setOf(1, 2, 3, 4, 5),
            setOf(1, 2, 3, 4, 5, 6, 7)
        ).forEach { numbers ->
            "입력값: $numbers" {
                shouldThrow<InvalidLottoNumberCountException> { Lotto(numbers) }
            }
        }
    }

    "유효하지 않은 번호 값을 입력하면 예외를 발생시킨다" - {
        listOf(
            setOf(0, 1, 2, 3, 4, 5),
            setOf(-1, 1, 2, 3, 4, 5),
            setOf(1, 2, 3, 4, 5, 46)
        ).forEach { numbers ->
            "입력값: $numbers" {
                shouldThrow<InvalidLottoNumberException> { Lotto(numbers) }
            }
        }
    }
})