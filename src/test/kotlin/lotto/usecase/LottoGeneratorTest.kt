package lotto.usecase

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoGeneratorTest {

    private val generator = LottoGenerator()

    @Test
    fun `전달된 인자로 Lotto가 만들어 진다`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = generator.generate(numbers, 1000)

        assertEquals(numbers, lotto.numbers)
    }
}
