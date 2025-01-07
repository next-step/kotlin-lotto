package lotto

import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import org.junit.jupiter.api.Test

class LottoTest {

    @Test
    internal fun `로또 번호가 실제로 일치하는지`() {
        val winningLotto = Lotto(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(2, 4, 6, 8, 10, 12)

        lotto.countMatch(winningLotto) shouldBe 3
    }

    @Test
    internal fun `로또 번호는 6개 이다`() {
        val lottoNumbersSize = Lotto().lottoNumbers.size

        lottoNumbersSize shouldBe 6
    }

    @Test
    internal fun `로또 번호는 오름차순 이다`() {
        val lottoNumbers = Lotto().lottoNumbers

        lottoNumbers shouldBe lottoNumbers.sortedBy { it.number }
    }
}
