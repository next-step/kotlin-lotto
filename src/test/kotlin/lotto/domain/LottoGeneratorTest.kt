package lotto.domain

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

class LottoGeneratorTest {

    @Suppress("NonAsciiCharacters")
    @Test
    fun `랜덤한 LottoNumbers를 생성한다`() {
        assertDoesNotThrow {
            LottoGenerator.randomTicket()
        }
    }
}
