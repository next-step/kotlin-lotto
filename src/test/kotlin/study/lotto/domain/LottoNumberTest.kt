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
    fun `LottoNumber 는 비교를 할 수 있다`() {
        val number1 = LottoNumber(10)
        val number2 = LottoNumber(20)
        assertTrue(number1 < number2)
    }
}
