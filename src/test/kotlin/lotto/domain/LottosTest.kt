package lotto.domain

import lotto.helper.LottoNumbersHelper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LottosTest {

    @Test
    fun `LottoRank 를 구하는데 성공한다`() {
        // given
        val lottoNumbers = (1..6).map { LottoNumber(it) }
        val manualLottoNumbers = LottoNumbersHelper.generate(1, 2, 3, 4, 5, 6)

        val lottos = Lottos.of(1, listOf(manualLottoNumbers), FakeLottoNumberGenerator())
        val lottoWinningNumbers = LottoWinningNumbers.of(lottoNumbers.map { it.number }, 7)

        // when
        val lottoResult = lottos.getLottoResult(lottoWinningNumbers)

        // then
        assertThat(lottoResult.getRankCount(LottoRank.FIRST)).isEqualTo(2)
    }

    @Test
    fun `자동, 수동 로또 개수를 구하는데 성공한다`() {
        // given
        val lottos = Lottos.of(2, listOf(LottoNumbersHelper.generate(1, 2, 3, 4, 5, 6)), FakeLottoNumberGenerator())

        // when
        val manualLottoCount = lottos.getLottoCount(LottoType.MANUAL)
        val autoLottoCount = lottos.getLottoCount(LottoType.AUTO)

        // then
        assertAll({
            assertThat(manualLottoCount).isSameAs(1)
            assertThat(autoLottoCount).isSameAs(2)
        })
    }
}
