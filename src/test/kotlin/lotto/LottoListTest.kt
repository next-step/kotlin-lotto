package lotto

import lotto.domain.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoListTest {
    @Test
    fun `로또 리스트의 getResult가 잘 작동한다`() {
        val lottoList = LottoList(
            listOf(
                Lotto(LottoNumbers(1, 2, 3, 4, 5, 6)),
                Lotto(LottoNumbers(1, 2, 3, 4, 5, 7)),
                Lotto(LottoNumbers(1, 2, 3, 4, 5, 16)),
                Lotto(LottoNumbers(1, 2, 3, 4, 15, 16)),
                Lotto(LottoNumbers(1, 2, 3, 14, 15, 16)),
            )
        )
        val winningNumbers = WinningNumbers(LottoNumbers(1, 2, 3, 4, 5, 6), LottoNumber(7))

        val result = lottoList.getResult(winningNumbers)
        assertThat(result.count(LottoRank.FIRST)).isEqualTo(1)
        assertThat(result.count(LottoRank.SECOND)).isEqualTo(1)
        assertThat(result.count(LottoRank.THIRD)).isEqualTo(1)
        assertThat(result.count(LottoRank.FOURTH)).isEqualTo(1)
        assertThat(result.count(LottoRank.FIFTH)).isEqualTo(1)
    }
}
