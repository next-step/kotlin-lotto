package lotto.domain

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoValidatorTest {

    private lateinit var lottoValidator: LottoValidator

    @BeforeEach
    fun setUp() {
        lottoValidator = LottoValidator()
    }

    @Test
    fun `구입하려는 금액이 로또 1개의 금액보다 작으면 IllegalArgumentException을 throw한다`() {
        val money = LottoMachine.LOTTO_TICKET_PRICE - 1
        assertThrows<IllegalArgumentException> { lottoValidator.validateInputMoneyCanBuyLottoTicket(money) }
    }

    @Test
    fun `구입하는 숫자보다 수동 구매 번호 숫자가 많으면 IllegalArgumentException을 throw한다`() {
        // given
        val manualBuyLotteryPaper = LottoTestHelper.createPurchasedLotteryPapers()
        val numberOfLottoTicket = manualBuyLotteryPaper.size - 1
        // then
        assertThrows<IllegalArgumentException> {
            lottoValidator.validateLottoTicket(
                numberOfLottoTicket,
                manualBuyLotteryPaper
            )
        }
    }


}