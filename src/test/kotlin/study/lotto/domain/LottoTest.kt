package study.lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `Lotto 생성 시 번호가 6개가 아니면 예외를 발생시킨다`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            val invalidNumbers = listOf(1, 2, 3, 4, 5).map(::LottoNumber).let(::LottoNumbers)
            Lotto(invalidNumbers)
        }

        assertTrue(exception.message!!.contains("LottoNumbers size must be equal to 6"))
    }

    @Test
    fun `Lotto 생성 시 번호가 올바르면 Lotto 객체를 반환한다`() {
        val validNumbers = listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber).let(::LottoNumbers)
        val lotto = Lotto(validNumbers)
        assertThat(lotto.numbers).isEqualTo(validNumbers)
    }

    @Test
    fun `당첨 번호와 일치하는 번호의 개수를 올바르게 계산한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber).let(::LottoNumbers))
        val winningNumbers = Lotto(listOf(4, 5, 6, 7, 8, 9).map(::LottoNumber).let(::LottoNumbers))
        assertEquals(3, lotto.countMatches(winningNumbers))
    }
}
