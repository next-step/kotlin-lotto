package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

internal class LottoTest {
    @Test
    fun `로또는 로또숫자열 하나로 생성된다`() {
        assertDoesNotThrow { Lotto(LottoNumbers(1, 2, 3, 4, 5, 6)) }
    }

    @Test
    fun `로또는 숫자 6개로도 생성된다`() {
        assertDoesNotThrow {
            Lotto(listOf(1, 2, 3, 4, 5, 6))
            Lotto(1, 2, 3, 4, 5, 6)
        }
    }

    @Test
    fun `다른 로또숫자열을 받아, 자신의 로또숫자열과 일치하는 수가 몇 개인지 반환한다`() {
        val winningNumbers = LottoNumbers(1, 2, 3, 4, 5, 6)
        assertThat(Lotto(1, 2, 3, 4, 5, 6).countMatchedBy(winningNumbers)).isEqualTo(6)
        assertThat(Lotto(2, 3, 4, 5, 6, 7).countMatchedBy(winningNumbers)).isEqualTo(5)
        assertThat(Lotto(3, 4, 5, 6, 7, 8).countMatchedBy(winningNumbers)).isEqualTo(4)
        assertThat(Lotto(4, 5, 6, 7, 8, 9).countMatchedBy(winningNumbers)).isEqualTo(3)
        assertThat(Lotto(5, 6, 7, 8, 9, 10).countMatchedBy(winningNumbers)).isEqualTo(2)
        assertThat(Lotto(6, 7, 8, 9, 10, 11).countMatchedBy(winningNumbers)).isEqualTo(1)
        assertThat(Lotto(7, 8, 9, 10, 11, 12).countMatchedBy(winningNumbers)).isEqualTo(0)
    }
}
