package lotto.domain

import io.kotest.core.spec.style.StringSpec
import org.assertj.core.api.Assertions
import java.lang.IllegalArgumentException

class LottoNumberTest : StringSpec({
    "each lotto ticket number not in 1..45 should throw IllegalArgumentException" {
        Assertions.assertThatThrownBy {
            LottoNumber(0)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid number")

        Assertions.assertThatThrownBy {
            LottoNumber(50)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid number")

        Assertions.assertThatThrownBy {
            LottoNumber(-4)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid number")
    }
})
