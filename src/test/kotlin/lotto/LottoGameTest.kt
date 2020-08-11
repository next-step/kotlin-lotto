package lotto

import lotto.domain.Lotto
import lotto.domain.LottoGame
import lotto.domain.LottoPrizeStatics
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

    @DisplayName("당첨번호 입력값 확인")
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5,", "r", "1.2.3.4.5.6", "1,1,1,1,1,1", "$"])
    fun validatePrizeLotto(prizeNumberString: String) {
        val lottoGame = LottoGame("3000")
        assertThatThrownBy { lottoGame.execute(prizeNumberString) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @DisplayName("생성된 로또 개수 확인")
    @Test
    fun createLottos() {
        val lottoGame = LottoGame("2000")
        lottoGame.execute("1,2,3,4,5,6")
        assertThat(lottoGame.lottos.size).isEqualTo(2)
    }

    @DisplayName("로또 당첨개수 확인")
    @Test
    fun checkMatches() {
        val lottoPrizeStatics = LottoPrizeStatics()
        lottoPrizeStatics.checkMatches(Lotto("1,2,3,4,5,6"), listOf(Lotto("1,2,3,10,11,12")))
        assertThat(lottoPrizeStatics.profitRate)
            .isEqualTo(5.0)
    }
}
