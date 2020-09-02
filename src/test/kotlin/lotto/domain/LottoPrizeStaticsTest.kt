package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoPrizeStaticsTest {

    @DisplayName("로또 상금 통계 리스트 유효성 체크")
    @Test
    fun validatePrizedLotto() {
        val prizeLotto = Lotto.from("1,2,3,4,5,6")!!
        val bonusNumber = LottoNumber.from("7")
        val winningLotto = WinningLotto(prizeLotto, bonusNumber)
        val lottoList = LottoGenerator.createAutoLottoList(3)

        val lottoListCount = LottoPrizeStatics(winningLotto, lottoList).prizeLottoMap.values.sum()

        assertThat(lottoListCount).isLessThanOrEqualTo(lottoList.size)
    }


    @DisplayName("당첨 로또 갯수 확인")
    @Test
    fun validatePrizedLottoList() {
        val prizeLotto = Lotto.from("1,2,3,4,5,6")!!
        val bonusNumber = LottoNumber.from("7")
        val winningLotto = WinningLotto(prizeLotto, bonusNumber)
        val lottoList = listOf(
            Lotto.from("1,2,3,4,5,6")!!,
            Lotto.from("1,2,3,4,5,6")!!,
            Lotto.from("1,2,3,4,5,7")!!
        )

        val prizedLottoCount = LottoPrizeStatics(winningLotto, lottoList).prizeLottoMap.filter { it.key == Prize.FIRST }.values.sum()

        assertThat(prizedLottoCount).isEqualTo(2)
    }


    @DisplayName("2등 당첨 로또 갯수 확인")
    @Test
    fun validatePrizedLottoSecondCount() {
        val prizeLotto = Lotto.from("1,2,3,4,5,6")!!
        val bonusNumber = LottoNumber.from("7")
        val winningLotto = WinningLotto(prizeLotto, bonusNumber)
        val lottoList = listOf(
            Lotto.from("7,2,3,4,5,6")!!,
            Lotto.from("1,7,3,4,5,6")!!,
            Lotto.from("1,2,7,4,5,6")!!
        )

        val secondPrizeLottoCount = LottoPrizeStatics(winningLotto, lottoList).prizeLottoMap.filter { it.key == Prize.SECOND }.values.sum()

        assertThat(secondPrizeLottoCount).isEqualTo(3)
    }

    @DisplayName("수익률 체크")
    @Test
    fun checkCalculateProfitRate() {
        val prizeLotto = Lotto.from("1,2,3,4,5,6")!!
        val bonusNumber = LottoNumber.from(7)

        val lotto1 = Lotto.from("11,12,13,14,15,16")!!
        val lotto2 = Lotto.from("21,12,13,14,15,16")!!
        val lottoList = listOf(lotto1, lotto2)
        val winningLotto = WinningLotto(prizeLotto, bonusNumber)
        val lottoPrizeStatics = LottoPrizeStatics(winningLotto, lottoList)
        val profitRate = lottoPrizeStatics.profitRate

        assertThat(profitRate).isEqualTo(0.0)
    }
}
