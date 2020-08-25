package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoGameMoneyTest {

    @DisplayName("로또 구매 금액 입력값 확인하기, 에러")
    @ParameterizedTest
    @ValueSource(strings = ["-1000", "500", "ss", "%"])
    fun validateLottoGameMoneyInput(gameMoney: String) {
        assertThat(LottoGameMoney.from(gameMoney))
            .isNull()
    }

    @DisplayName("로또 구매 금액 입력값 확인하기")
    @Test
    fun validateLottoGameMoneyInput() {
        assertThat(LottoGameMoney.from("1300"))
            .isInstanceOfAny(LottoGameMoney::class.java)
    }

    @DisplayName("로또 구매 금액에 따른 게임 횟수")
    @Test
    fun checkCountOfGameByGameMoney() {
        val firstCountOfLotto = LottoGameMoney.from("1300")!!.getCountOfGame()
        val secondCountOfLotto = LottoGameMoney.from("5000")!!.getCountOfGame()
        assertAll(
            { assertThat(firstCountOfLotto).isEqualTo(1) },
            { assertThat(secondCountOfLotto).isEqualTo(5) }
        )
    }
}
