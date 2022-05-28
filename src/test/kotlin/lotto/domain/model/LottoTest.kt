package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `Lotto는 발급받은 로또의 번호들을 보관한다`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(lottoNumbers)

        assertThat(lotto.numbers).isEqualTo(lottoNumbers)
    }

    @Test
    fun `Lotto의 숫자가 6개가 아니면 IllegalArgumentException이 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `checkWith를 통해 WinningNumbers를 받아 번호가 몇 개 일치하는지 확인할 수 있다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6))

        assertThat(lotto checkWith winningNumbers).isEqualTo(5)
    }
}
