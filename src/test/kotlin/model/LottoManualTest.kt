package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class LottoManualTest {
    @Test
    fun `inputManualCount`() {
        assertThat(LottoManual(10)).isNotNull
    }
    @Test
    fun `invalidInputManualCountThrowException`() {
        assertThrows<IllegalArgumentException> { LottoManual("a") }
    }
}
