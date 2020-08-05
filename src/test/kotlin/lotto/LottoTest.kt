package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoGameTest {

    @DisplayName("구매 금액 확인")
    @ParameterizedTest
    @ValueSource(strings = ["", "200", "-30"])
    fun checkAmountValidation(amount: String) {
        assertThatThrownBy { LottoGame(amount) }.isInstanceOf(IllegalArgumentException::class.java)
    }

    // checkAmountValidation
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5,", "r", "1.2.3.4.5.6", "1,1,1,1,1,1"])
    fun `당첨번호 입력값 확인`(prizeNumberString: String) {
        val lotto = LottoGame("3000")
        assertThatThrownBy { lotto.execute(prizeNumberString) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    // checkPrizeNumbersValidation
    @Test
    fun `당첨번호 확인`() {
        val lotto = LottoGame("3000")
        assertThat(lotto.execute("1,2,3,4,5,6"))
            .isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }

    // createLotto
    @Test
    fun `숫자 6개 뽑기`() {
        val lotto = LottoGame("2000")
        assertThat(lotto.createLotto().size)
            .isEqualTo(COUNT_OF_NUMBERS)
    }

    // checkMatch
    @Test
    fun `당첨여부 확인`() {
        val lotto = LottoGame("2000")
        lotto.execute("1,2,3,4,5,6")
        assertThat(lotto.profitRate).isGreaterThanOrEqualTo(0.0)
    }
}
