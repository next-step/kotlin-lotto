package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoGameTest {

    @DisplayName("구매 금액 확인")
    @ParameterizedTest
    @ValueSource(strings = ["", "200", "-30"])
    fun validateGameMoney(amount: String) {
        assertThatThrownBy { LottoGame(amount) }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @DisplayName("생성된 로또 개수 확인")
    @Test
    fun createLottoList() {
        val lottoGame = LottoGame("2000")
        assertThat(lottoGame.lottoList.size).isEqualTo(2)
    }

    @DisplayName("보너스 숫자는 당첨번호에 포함되지 않아야함")
    @Test
    fun validateBonusNumberNotIncludedPrizeNumber() {
        val lottoGame = LottoGame("2000")
        assertThat(lottoGame.execute("1,2,3,4,5,6", "6"))
            .isInstanceOfAny(LottoGameResult.IsContainBonusNumber::class.java)
    }
}
