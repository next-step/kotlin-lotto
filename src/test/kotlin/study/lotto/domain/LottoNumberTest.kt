package study.lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LottoNumberTest {
    @Test
    fun `유효한 로또 번호 생성`() {
        val number = LottoNumber(1)
        assertNotNull(number)
        assertEquals(1, number.number)
    }

    @Test
    fun `범위를 벗어난 번호로 인스턴스 생성 시 예외 발생`() {
        assertThrows(IllegalArgumentException::class.java) {
            LottoNumber(0)
        }
    }

    @Test
    fun `getLottoNumbers 함수는 45개의 유니크한 번호 반환`() {
        val lottoNumbers = LottoNumber.getLottoNumbers()
        assertEquals(45, lottoNumbers.size)
        assertEquals(45, lottoNumbers.distinct().size)
    }

    @Test
    fun `listOf 함수는 주어진 숫자들로 정렬된 로또 번호 리스트 반환`() {
        val numbers = LottoNumber.listOf(33, 1, 20, 15)
        assertEquals(listOf(1, 15, 20, 33), numbers.map { it.number })
    }

    @Test
    fun `LottoNumber 는 비교를 할 수 있다`() {
        val number1 = LottoNumber(10)
        val number2 = LottoNumber(20)
        assertTrue(number1 < number2)
    }
}