package lottery.domain

import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoGameTest {
    @ParameterizedTest(name = "구매 금액 {0}원을 입력하면 로또 {1}장이 생성된다")
    @CsvSource("999,0", "1000,1", "1001,1", "3500,3")
    @DisplayName("로또 구입 금액을 입력받아 로또 구매 장수를 생성한다")
    fun lottoGameInit(price: String, amount: Int) {
        val lottoGame = LottoGame(price)

        lottoGame.amount shouldBe amount
    }

    @Test
    @DisplayName("로또 구입 금액이 숫자가 아니면 구매가 불가능하다")
    fun validateAmount() {
        assertThatThrownBy {
            LottoGame("lotto")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
