package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoPrizeStatics
import lotto.domain.Prize
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
        val prizeLotto = Lotto("1,2,3,4,5,6")
        val bonusNumber = LottoNumber.newInstance(7)
        val lottoList = listOf(
            Lotto("11,12,13,14,15,16"),
            Lotto("21,12,13,14,15,16")
        )
        lottoPrizeStatics.checkMatches(prizeLotto, bonusNumber, lottoList)
        val profitRate = lottoPrizeStatics.profitRate

        assertThat(profitRate).isEqualTo(0.0)
    }
}
