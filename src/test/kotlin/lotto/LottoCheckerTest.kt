package lotto

import io.kotest.matchers.shouldBe
import lotto.domain.LottoChecker
import org.junit.jupiter.api.Test

class LottoCheckerTest {
    @Test
    fun `로또 번호와 당첨 번호를 비교하여 일치하는 번호의 개수를 구할 수 있다`() {
        val lottoNumbers = listOf(1, 3, 5, 7, 9, 10)
        val winnerNumbers = listOf(2, 4, 6, 8, 10)

        val matchNumbers = LottoChecker.findMatchingNumbers(lottoNumbers, winnerNumbers)

        matchNumbers shouldBe 1
    }
}
