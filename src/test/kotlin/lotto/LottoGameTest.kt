package lotto

import lotto.domain.Lotto
import lotto.domain.LottoGame
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
        lottoGame.execute("1,2,3,4,5,6", "7")
        assertThat(lottoGame.lottoList.size).isEqualTo(2)
    }

    @DisplayName("Lotto 테스트, 갯수 확인")
    @Test
    fun validateLottoCount() {
        assertThatThrownBy { Lotto("1,2,3,4") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @DisplayName("Lotto 테스트, 중복 및 갯수 확인")
    @Test
    fun validateLottoCountAndDuplication() {
        assertThatThrownBy { Lotto("1,2,3,4,5,5") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @DisplayName("당첨번호 입력값 확인")
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5,", "r", "1.2.3.4.5.6", "1,1,1,1,1,1", "$"])
    fun validatePrizeLotto(prizeNumberString: String) {
        val lottoGame = LottoGame("3000")
        assertThatThrownBy { lottoGame.execute(prizeNumberString, "7") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @DisplayName("보너스 숫자는 당첨번호에 포함되지 않아야함")
    @Test
    fun validateBonusNumberNotIncludedPrizeNumber() {
        val lottoGame = LottoGame("2000")
        assertThatThrownBy { lottoGame.execute("1,2,3,4,5,6", "6") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
