package lotto.usecase

import lotto.domain.model.LottoNumber
import lotto.domain.model.LottoNumbers
import lotto.domain.model.Price
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoGeneratorTest {

    private val generator = LottoGenerator()

    @Test
    fun `전달된 인자로 Lotto가 만들어 진다`() {
        val numbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6),
        )
        val lotto = generator.generate(
            numbers = LottoNumbers(numbers),
            price = Price(1000)
        )

        assertEquals(LottoNumbers(numbers), lotto.numbers)
    }
}
