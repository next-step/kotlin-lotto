package lotto.domain

import lotto.domain.ExceptionType.BUDGET_UNSIGNED_INT
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class LottoBudgetTest {
    @Test
    fun `로또 구매 금액이 음수 또는 문자열 이면 예외가 발생한다`() {
        assertThatIllegalArgumentException().isThrownBy { LottoBudget(-111) }.withMessage(BUDGET_UNSIGNED_INT)
        assertThatIllegalArgumentException().isThrownBy { LottoBudget("-111") }.withMessage(BUDGET_UNSIGNED_INT)
        assertThatIllegalArgumentException().isThrownBy { LottoBudget("ABC") }.withMessage(BUDGET_UNSIGNED_INT)
    }

    @Test
    fun `로또 구매 가능 횟수 를 확인 할 수 있다`() {
        val money = 10000
        val expected = money / LottoBudget.PRICE_OF_GAME
        val actual = LottoBudget(money).getNumberOfGames()
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `로또 수익률을 알수 있다`() {
        val money = 10000
        val winning = 50000
        val expected = winning / money.toDouble()
        val actual = LottoBudget(money).getWinningRatio(winning)
        assertThat(actual).isEqualTo(expected)
    }
}
