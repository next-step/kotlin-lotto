package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoPrizeStaticsTest {

    @DisplayName("로또 상금 통계 리스트 유효성 체크")
    @Test
    fun validatePrizedLotto() {
        assertThat(LottoPrizeStatics().prizedLotto.size)
            .isEqualTo(Prize.values().size - 1)
    }

    @DisplayName("수익률 체크")
    @Test
    fun checkCalculateProfitRate() {
        val lottoPrizeStatics = LottoPrizeStatics()
        val prizeLotto = Lotto.from("1,2,3,4,5,6")!!
        val bonusNumber = LottoNumber.from(7)

        val lotto1 = Lotto.from("11,12,13,14,15,16")!!
        val lotto2 = Lotto.from("21,12,13,14,15,16")!!
        val lottoList = listOf(lotto1, lotto2)
        val winningLotto = WinningLotto(prizeLotto, bonusNumber)
        lottoPrizeStatics.calculateResult(winningLotto, lottoList)
        val profitRate = lottoPrizeStatics.profitRate

        assertThat(profitRate).isEqualTo(0.0)
    }
}
