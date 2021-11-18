package lotto.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InputViewKtTest {

    @Test
    fun getNumber() {
        assertThat(getNumber("1")).isEqualTo(1)
    }
}
