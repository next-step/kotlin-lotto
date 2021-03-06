package lotto.model

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

internal class LottoNumbersTest {
    @Test
    fun `LottoNumbers는 LottoNumber 객체 6개로 만들어진다`() {
        // given
        val lottoNumbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )


        // when, then
        assertDoesNotThrow { LottoNumbers(lottoNumbers) }
    }
}