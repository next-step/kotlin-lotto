package lotto.usecase

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoNumberGeneratorTest {
    @Test
    fun `번호 생성시 6개 생성 되는지 확인`() {
        val actual = LottoNumberGenerator().generate()

        assertEquals(6, actual.size)
    }
}
