package lotto

import lotto.AutoLottoController.getWinningTicket
import lotto.dto.PurchaseAmountDto
import lotto.domain.vo.LottoNumber
import lotto.domain.vo.LottoTicket
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class AutoLottoControllerTest {
    @Test
    fun `로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야한다`() {
        // given
        val inputPrice = 2000

        // when
        val lottoTickets = AutoLottoController.play(PurchaseAmountDto(inputPrice))

        // then
        assertEquals(2, lottoTickets.size)
    }

    // 테스트 방법 ?
    @Test
    fun `로또 번호는 1부터 45까지의 숫자 중에서 6개를 랜덤으로 뽑는다`() {
        // given
        val inputPrice = 2000
        val lottoTickets = AutoLottoController.play(PurchaseAmountDto(inputPrice))

        val a = lottoTickets[0]
        println(a)
    }

    @Test
    fun `로또 번호 6개는 중복되지 않는다`() {
        val inputNumber = listOf(1, 2, 2, 2, 2, 2).map { LottoNumber(it) }
        assertThrows<IllegalArgumentException> { LottoTicket(inputNumber) }
    }

    @Test
    fun `지난 주 당첨 번호는 "," 구분자로 입력할 수 있다 공백은 있어도 된다`() {
        val inputNumber = "1,2,3, 4,5, 6"
        assertDoesNotThrow { getWinningTicket(inputNumber) }
    }

    @Test
    fun `지난 주 당첨 번호는 "," 외에 다른 구분자를 사용하면 번호를 파싱할 수 없다`() {
        val inputNumber = "1:2,3, 4,5, 6"
        assertThrows<Exception> { getWinningTicket(inputNumber) }
    }

    @Test
    fun `지난 주 당첨 번호를 입력할 수 있다`() {
        val inputNumber = "1, 2, 3, 4, 5, 6"
        assertDoesNotThrow { getWinningTicket(inputNumber) }
    }
}
