package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AmountTest {
    @Test
    fun get_auto_amount() {
        val amount = Amount(10, 3)

        assertThat(amount.auto).isEqualTo(7)
    }
}
