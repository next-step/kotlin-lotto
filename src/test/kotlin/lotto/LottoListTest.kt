package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoListTest {
    @Test
    fun getResult() {
        val lottoList = LottoList(
            listOf(
                Lotto(LottoNumbers(1, 2, 3, 4, 5, 6)),
                Lotto(LottoNumbers(1, 2, 3, 4, 5, 16)),
                Lotto(LottoNumbers(1, 2, 3, 4, 15, 16)),
                Lotto(LottoNumbers(1, 2, 3, 14, 15, 16)),
            )
        )
        val winningNumbers = WinningNumbers(LottoNumbers(1, 2, 3, 4, 5, 6))

        val result = lottoList.getResult(winningNumbers)
        assertThat(result.count(LottoRank.FIRST)).isEqualTo(1)
        assertThat(result.count(LottoRank.SECOND)).isEqualTo(1)
        assertThat(result.count(LottoRank.THIRD)).isEqualTo(1)
        assertThat(result.count(LottoRank.FOURTH)).isEqualTo(1)
    }
}
