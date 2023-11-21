package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumbersTest {

    @Test
    @DisplayName("유효한 숫자 목록으로 LottoNumbers 인스턴스가 생성된다")
    fun `유효한 숫자 목록으로 LottoNumbers 인스턴스가 생성된다`() {
        val validNumbers = (1..LottoConstants.NUMBERS_PER_TICKET).toList()
        val lottoNumbers = LottoNumbers.from(validNumbers)
        assertNotNull(lottoNumbers)
        assertEquals(LottoConstants.NUMBERS_PER_TICKET, lottoNumbers.readOnlyNumbers.size)
    }

    @Test
    @DisplayName("번호 갯수가 부족한 경우 예외 발생")
    fun `번호 갯수가 부족한 경우 예외 발생`() {
        val invalidNumbers = listOf(1, 2, 3, 4, 5)
        assertThrows<IllegalArgumentException> {
            LottoNumbers.from(invalidNumbers)
        }
    }

    @Test
    @DisplayName("번호가 중복된 경우 예외 발생")
    fun `번호가 중복된 경우 예외 발생`() {
        val duplicateNumbers = listOf(1, 1, 2, 3, 4, 5)
        assertThrows<IllegalArgumentException> {
            LottoNumbers.from(duplicateNumbers)
        }
    }

    @Test
    @DisplayName("번호 범위를 벗어난 경우 예외 발생")
    fun `번호 범위를 벗어난 경우 예외 발생`() {
        val outOfRangeNumbers = listOf(0, 46, 2, 3, 4, 5)
        assertThrows<IllegalArgumentException> {
            LottoNumbers.from(outOfRangeNumbers)
        }
    }
}
