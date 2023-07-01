package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import lotto.domain.model.Money
import org.junit.jupiter.api.Test

class MoneyTest {
    @Test
    fun `음수가 되면 IllegalArgumentException이 발생한다`() {
        shouldThrow<IllegalArgumentException> {
            Money(-1)
        }
    }
}
