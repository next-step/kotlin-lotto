package view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputViewTest {
    @Test
    @DisplayName("구입금액을 입력 받는다")
    fun `inputMoney`() {
        val inputView = InputView()
        val money = inputView.getMoney { "14000" }
        assertThat(money).isNotNull
    }

    @Test
    @DisplayName("구입금액이 숫자가 아니면 exception 을 반환한다")
    fun `inputMoneyNotValid`() {
        val inputView = InputView()
        assertThrows<IllegalArgumentException> {
            inputView.getMoney { "abcd" }
        }
    }

    @Test
    @DisplayName("당첨 번호를 입력 받는다")
    fun `inputPrizeLotto`() {
    }

    @Test
    @DisplayName("보너스 번호를 입력 받는다")
    fun `inputBonusNumber`() {
    }

    @Test
    @DisplayName("숫자, 쉼표, 스페이스가 아닌 값을 입력 받으면 exception 을 반환한다")
    fun `invalidInputThrowException`() {
    }
}
