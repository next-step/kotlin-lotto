package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoGameTest {

    @DisplayName("생성된 로또 개수 확인")
    @Test
    fun createLottoList() {
        val lottoGameMoney = LottoGameMoney.from("2000")
        val lottoGame = LottoGame.of(lottoGameMoney!!)

        assertThat(lottoGame.lottoList.size).isEqualTo(2)
    }

    @DisplayName("보너스 숫자는 당첨번호에 포함되지 않아야함")
    @Test
    fun validateBonusNumberNotIncludedPrizeNumber() {
        val lottoGameMoney = LottoGameMoney.from("2000")
        val lottoGame = LottoGame.of(lottoGameMoney!!)

        assertThat(lottoGame.execute("1,2,3,4,5,6", "6"))
            .isInstanceOfAny(LottoGameResult.IsContainBonusNumber::class.java)
    }
}
