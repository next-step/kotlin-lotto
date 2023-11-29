package lotto.domain

import io.kotest.core.spec.style.StringSpec
import org.assertj.core.api.Assertions
import java.lang.IllegalArgumentException

class LottoTicketTest : StringSpec({
    "lotto ticket should have exact 6 numbers else throw IllegalArgumentException" {
        Assertions.assertThatThrownBy {
            LottoTicket(
                listOf(1, 2, 3, 4, 5, 6, 7).map { LottoNumber(it) }
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid size")

        Assertions.assertThatThrownBy {
            LottoTicket(
                listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                )
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid size")
    }

    "lotto ticket with same numbers should throw IllegalArgumentException" {
        Assertions.assertThatThrownBy {
            LottoTicket(
                listOf(1, 2, 3, 4, 5, 5).map { LottoNumber(it) }
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Duplicated number")

        Assertions.assertThatThrownBy {
            LottoTicket(
                listOf(1, 1, 2, 3, 4, 5).map { LottoNumber(it) }
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Duplicated number")
    }
})
