package lotto.domain

import io.kotest.core.spec.style.StringSpec
import org.assertj.core.api.Assertions
import java.lang.IllegalArgumentException

class WinningNumberTest : StringSpec({
    "winning number should have exact 6 numbers else throw IllegalArgumentException" {
        Assertions.assertThatThrownBy {
            WinningNumber(
                listOf(1, 2, 3, 4, 5)
                    .map { LottoNumber(it) }
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid size: ${WinningNumber::class.java.name}")

        Assertions.assertThatThrownBy {
            WinningNumber(
                listOf(1, 2, 3, 4, 5, 6, 7)
                    .map { LottoNumber(it) }
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid size: ${WinningNumber::class.java.name}")
    }

    "winning number with same number should throw IllegalArgumentException" {
        Assertions.assertThatThrownBy {
            WinningNumber(
                listOf(1, 2, 3, 4, 5, 5)
                    .map { LottoNumber(it) }
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Duplicated number: ${WinningNumber::class.java.name}")
    }
})
