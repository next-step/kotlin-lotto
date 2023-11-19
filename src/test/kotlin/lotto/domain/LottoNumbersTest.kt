package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumbersTest {

    @Test
    @DisplayName("유효한 숫자 목록으로 LottoNumbers 인스턴스가 생성된다")
    fun `유효한 숫자 목록으로 LottoNumbers 인스턴스가 생성된다`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lottoNumbers = LottoNumbers(numbers)
        assertEquals(numbers, lottoNumbers.readOnlyNumbers)
    }

    @Test
    @DisplayName("번호 갯수가 부족한 경우 예외 발생")
    fun `번호 갯수가 부족한 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            LottoNumbers(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    @DisplayName("번호가 중복된 경우 예외 발생")
    fun `번호가 중복된 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            LottoNumbers(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    @DisplayName("번호 범위를 벗어난 경우 예외 발생")
    fun `번호 범위를 벗어난 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            LottoNumbers(listOf(0, 2, 3, 4, 5, 6))
        }
    }
}
