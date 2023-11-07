package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {

    @Test
    fun `로또 1개 생성`() {
        val sut = LottoMachine()

        val actual = sut.create()

        assertThat(actual).hasSize(1)
    }
    
}
