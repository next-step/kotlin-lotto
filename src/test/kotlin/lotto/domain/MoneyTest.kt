package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

internal class MoneyTest : FreeSpec({

    "돈은 0보다 작을 수 없다." - {
        listOf(
            -1,
            -10,
            -999
        ).forEach { value ->
            "Money 값 '$value'는 예외가 발생한다." {
                val exception =
                    shouldThrowExactly<java.lang.IllegalArgumentException> { Money(value = BigDecimal.valueOf(value.toLong())) }

                exception.message shouldBe "돈은 0 보다 작을 수 없습니다."
            }
        }
    }
})
