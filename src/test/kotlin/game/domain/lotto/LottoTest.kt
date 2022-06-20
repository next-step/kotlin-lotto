package game.domain.lotto

import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `빈 티켓으로 로또 생성시 예외 발생`() {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { Lotto(emptyList()) }
    }
}