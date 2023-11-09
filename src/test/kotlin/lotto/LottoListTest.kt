package lotto

import lotto.domain.LottoList
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.LottoRank
import lotto.domain.ManualLotto
import lotto.domain.WinningNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoListTest {
    @Test
    fun `로또 리스트로부터 로또 결과 리스트를 뽑을 시, 순위가 개수대로 잘 분리되어있다`() {
        val lottoList = LottoList(
            listOf(
                ManualLotto(LottoNumbers(1, 2, 3, 4, 5, 6)),
                ManualLotto(LottoNumbers(1, 2, 3, 4, 5, 7)),
                ManualLotto(LottoNumbers(1, 2, 3, 4, 5, 16)),
                ManualLotto(LottoNumbers(1, 2, 3, 4, 15, 16)),
                ManualLotto(LottoNumbers(1, 2, 3, 14, 15, 16)),
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
