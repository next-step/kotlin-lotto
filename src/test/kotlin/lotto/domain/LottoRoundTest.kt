package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoRoundTest {

    @Test
    fun `새로운 로또를 개수만큼 추가할 수 있다`() {
        // given
        val sut = LottoRound(LottoRoundElements())
        val newLottoSize = 3

        // when
        sut.addNewLottos(newLottoSize)

        // then
        assertThat(sut.getLottos().size).isEqualTo(newLottoSize)
    }

    @Test
    fun `로또 추첨결과를 얻을 수 있다`() {
        // given
        val winningLotto = (1..6).map { LottoNumber(it) }.toList().let { Lotto(it) }
        val sut = LottoRound(LottoRoundElements())
        val newLottoSize = 3
        sut.addNewLottos(3)

        // when
        val result = sut.lotteryDraw(winningLotto)

        // then
        assertThat(result.lottoResults.size).isEqualTo(newLottoSize)
    }
}
