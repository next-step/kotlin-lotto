package calculator.common.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class PositiveIntegerTest : FreeSpec({
    "0보다 큰 정수는 양의 정수로 생성할 수 있다" - {
        listOf(
            0,
            1,
            100,
            100_000
        ).forEach {
            "${it}은 양의 정수로 생성할 수 있다." {
                PositiveInteger(it).value shouldBe it
            }
        }

        listOf(
            -1,
            -100
        ).forEach {
            "${it}은 양의 정수로 생성할 수 없다." {
                shouldThrow<IllegalArgumentException> { PositiveInteger(it) }
            }
        }
    }
})
