package lotto.usecase

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoNumberGeneratorTest {
    @Test
    fun `전략에 알맞는 숫자가 생성되는지 테스트`() {
        val actual = LottoNumberGenerator(TestHelperNumberGenerateStrategy()).generate()

        actual.forEach {
            assertEquals(6, it)
        }
    }
}
