package view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputViewTest {
    lateinit var inputView: InputView
    @BeforeEach
    fun `init`() {
        inputView = InputView()
    }

    @Test
    @DisplayName("구입금액을 입력 받는다")
    fun `inputMoney`() {
        val money = inputView.getMoney { "14000" }
        assertThat(money).isNotNull
    }

    @Test
    @DisplayName("구입금액이 숫자가 아니면 exception 을 반환한다")
    fun `inputInvalidMoney`() {
        assertThrows<IllegalArgumentException> {
            inputView.getMoney { "abcd" }
        }
    }

    @Test
    @DisplayName("당첨 번호를 입력 받는다")
    fun `inputPrizeLotto`() {
        val lotto = inputView.getPrizeLotto { "1, 2, 3, 4, 5, 6" }
        assertThat(lotto).isNotNull
    }

    @Test
    @DisplayName("같은 숫자가 로또에 있으면 exception 을 반환한다")
    fun `inputInvalidLotto`() {
        assertThrows<IllegalArgumentException> {
            inputView.getPrizeLotto { "1, 1, 3, 4, 5, 6" }
        }
    }

    @Test
    @DisplayName("잘못된 당첨 번호를 입력 받으면 exception 을 반환한다")
    fun `inputInvalidPrizeLotto`() {
        assertThrows<IllegalArgumentException> {
            inputView.getPrizeLotto { "1,2,3, a, b, c" }
        }
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
