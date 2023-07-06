package lotto.domain

import lotto.helper.LottoNumbersHelper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LottosTest {

    @Test
    fun `LottoRank 를 구하는데 성공한다`() {
        // given
        val lottoNumbers = LottoNumbersHelper.generate(1, 2, 3, 4, 5, 6)
        val autoLotto = Lotto(lottoNumbers, LottoType.AUTO)
        val manualLotto = Lotto(lottoNumbers, LottoType.MANUAL)

        val lottos = Lottos.of(listOf(autoLotto), listOf(manualLotto))
        val lottoWinningNumbers = LottoWinningNumbers.of(lottoNumbers.lottoNumbers.map { it.number }, 7)

        // when
        val lottoResult = lottos.getLottoResult(lottoWinningNumbers)

        // then
        assertThat(lottoResult.getRankCount(LottoRank.FIRST)).isEqualTo(2)
    }

    @Test
    fun `자동, 수동 로또 개수를 한 개씩 생성한 경우 각 개수는 1이다`() {
        // given
        val lottoNumbers = LottoNumbersHelper.generate(1, 2, 3, 4, 5, 6)
        val autoLotto = Lotto(lottoNumbers, LottoType.AUTO)
        val manualLotto = Lotto(lottoNumbers, LottoType.MANUAL)
        val lottos = Lottos.of(listOf(autoLotto), listOf(manualLotto))

        // when
        val manualLottoCount = lottos.getLottoCount(LottoType.MANUAL)
        val autoLottoCount = lottos.getLottoCount(LottoType.AUTO)

        // then
        assertAll({
            assertThat(manualLottoCount).isSameAs(1)
            assertThat(autoLottoCount).isSameAs(1)
        })
    }
}
