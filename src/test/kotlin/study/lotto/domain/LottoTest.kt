package study.lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `Lotto 생성 시 번호가 6개가 아니면 예외를 발생시킨다`() {
        val invalidNumbers = listOf(1, 2, 3, 4, 5)
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Lotto.generate(invalidNumbers)
        }

        assertTrue(exception.message!!.contains("must have exactly 6 numbers"))
    }

    @Test
    fun `Lotto 생성 시 번호가 1부터 45 범위를 벗어나면 예외를 발생시킨다`() {
        val invalidNumbers = listOf(0, 1, 2, 3, 4, 46)
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Lotto.generate(invalidNumbers)
        }

        assertTrue(exception.message!!.contains("must be in the range 1 to 45"))
    }

    @Test
    fun `Lotto 생성 시 번호가 올바르면 Lotto 객체를 반환한다`() {
        val validNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto.generate(validNumbers)
        assertThat(lotto.numbers).isEqualTo(validNumbers)
    }

    @Test
    fun `당첨 번호와 일치하는 번호의 개수를 올바르게 계산한다`() {
        val lotto = Lotto.generate(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = Lotto.generate(listOf(4, 5, 6, 7, 8, 9))
        assertEquals(3, lotto.countMatches(winningNumbers))
    }
}
