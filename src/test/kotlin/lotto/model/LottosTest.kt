package lotto.model

import lotto.model.Lottos.Companion.EXCEPTION_INPUT_NUMBER_NULL
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottosTest {
    @Test
    @DisplayName("로또 1등 당첨되는 경우 확인")
    fun `check result of first winner`() {
        // given
        val price = Price(1000)
        val purchasedList = listOf(Lotto(listOf(LottoNumber(10),
            LottoNumber(1),
            LottoNumber(13),
            LottoNumber(23),
            LottoNumber(33),
            LottoNumber(43))))
        val winNumber = "10,1,13,23,33,43"

        // when
        val lottos = Lottos.inputWinNumber(price, purchasedList, winNumber)

        // then
        Assertions.assertThat(lottos.compareLottoResult())
            .isEqualTo(LottoStatisticFormat(price, hashMapOf(LottoRank.FIRST to 1)))
    }

    @Test
    @DisplayName("지난주 당첨 번호 입력값이 없는 경우")
    fun `incorrect win number list format`() {
        // given
        val price = Price(1000)
        val purchasedList = listOf(Lotto(listOf(LottoNumber(10),
            LottoNumber(1),
            LottoNumber(13),
            LottoNumber(23),
            LottoNumber(33),
            LottoNumber(43))))
        val winNumber = null

        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Lottos.inputWinNumber(price, purchasedList, winNumber) }
            .withMessage(EXCEPTION_INPUT_NUMBER_NULL)
    }
}
