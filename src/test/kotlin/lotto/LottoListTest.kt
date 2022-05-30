package lotto

import lotto.domain.LottoList
import lotto.domain.LottoNumbers
import lotto.domain.WinningNumbers
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoListTest {

    @Test
    fun `전체 로또의 등수를 리턴한다`() {
        val lotto1 = LottoNumbers(listOf(1, 2, 3, 4, 5, 6))
        val lotto2 = LottoNumbers(listOf(1, 2, 3, 4, 5, 45))
        val lotto3 = LottoNumbers(listOf(1, 2, 3, 4, 44, 45))
        val lotto4 = LottoNumbers(listOf(1, 2, 3, 43, 44, 45))
        val lotto5 = LottoNumbers(listOf(1, 2, 42, 43, 44, 45))

        val lottoList = LottoList(listOf(lotto1, lotto2, lotto3, lotto4, lotto5))

        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6))

        val result = lottoList.calculateLottoResult(winningNumbers)

        result.forEach { grade, count ->
            Assertions.assertThat(count).isEqualTo(1)
        }
    }
}
