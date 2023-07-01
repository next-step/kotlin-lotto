package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import lotto.domain.model.Count
import org.junit.jupiter.api.Test

class CountTest {
    @Test
    fun `음수가 되면 IllegalArgumentException이 발생한다`() {
        shouldThrow<IllegalArgumentException> {
            Count(-1)
        }
    }
}
