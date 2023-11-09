package study.lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class LottoNumbersTest {
    @Test
    fun `LottoNumbers 생성 시 유효한 로또 번호 리스트일 경우 정상적으로 생성해야 한다`() {
        val numbers = listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(6))

        val lottoNumbers = LottoNumbers(numbers)

        assertEquals(numbers, lottoNumbers)
    }

    @Test
    fun `LottoNumbers 생성 시 로또 번호 리스트가 비어있으면 예외를 던져야 한다`() {
        val emptyNumbers = emptyList<LottoNumber>()

        val exception = assertThrows(IllegalArgumentException::class.java) {
            LottoNumbers(emptyNumbers)
        }
        assertEquals("LottoNumbers cannot be empty", exception.message)
    }

    @Test
    fun `LottoNumbers 생성 시 로또 번호 리스트의 크기가 정확히 6이 아니면 예외를 던져야 한다`() {
        val invalidNumbers = listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5))

        val exception = assertThrows(IllegalArgumentException::class.java) {
            LottoNumbers(invalidNumbers)
        }
        assertEquals("LottoNumbers size must be equal to ${LottoNumbers.NUMBERS_COUNT}", exception.message)
    }
}
