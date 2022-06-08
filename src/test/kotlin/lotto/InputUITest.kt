package lotto

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.Money
import lotto.ui.InputUI
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputUITest {

    @Test
    fun `사용자가 금액을 입력하면, 금액을 리턴한다`() {
        System.setIn("14000".byteInputStream())
        assertThat(InputUI.receivePurchaseAmount()).isEqualTo(Money(14000))
    }

    @Test
    fun `사용자가 금액이 아닌 값을 입력하면, NumberFormatException 예외가 발생한다`() {
        assertThrows<NumberFormatException> {
            System.setIn("money".byteInputStream())
            InputUI.receivePurchaseAmount()
        }
    }

    @Test
    fun `사용자가 당첨번호를 입력하면, 당첨번호를 리턴한다`() {
        System.setIn("1,2,3,4,5,6".byteInputStream())
        assertThat(InputUI.receiveWinningNumbers()).isEqualTo(LottoNumbers(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `사용자가 수가 아닌 번호를 입력하면, NumberFormatException 예외가 발생한다`() {
        assertThrows<NumberFormatException> {
            System.setIn("money,money,money,money,money,money".byteInputStream())
            InputUI.receivePurchaseAmount()
        }
    }

    @Test
    fun `사용자가 잘못된 당첨번호를 입력하면, IllegalArgumentException 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            System.setIn("1,2,2,3,3,3".byteInputStream())
            InputUI.receiveWinningNumbers()
        }
    }

    @Test
    fun `사용자가 잘못된 보너스 번호를 입력하면, IllegalArgumentException 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            System.setIn("1".byteInputStream())
            InputUI.receiveBonusNumber()
        }
    }

    private fun LottoNumbers(vararg numbers: Int) = LottoNumbers(numbers.map(::LottoNumber))
}
