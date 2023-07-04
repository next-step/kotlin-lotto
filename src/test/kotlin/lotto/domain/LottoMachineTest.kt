package lotto.domain

import lotto.dto.LottoOrder
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoMachineTest {

    private lateinit var lottoMachine: LottoMachine

    @BeforeEach()
    fun setUp() {
        lottoMachine = LottoMachine(LotteryPaperFactory(RandomLottoNumberGenerationStrategy()))
    }

    @ParameterizedTest
    @ValueSource(strings = ["14000", "3000"])
    fun `입력받은 구입 금액을 로또 개당 가격으로 나눈 숫자만큼 티켓을 구매한다`(money: Int) {
        val lottoOrder = LottoOrder()
        val actual = lottoMachine.buyLottoTicket(lottoOrder).lotteryPaperList.size
        Assertions.assertThat(actual).isEqualTo(money / LottoMachine.LOTTO_TICKET_PRICE)
    }

    @ParameterizedTest
    @ValueSource(strings = ["999", "0", "-1000"])
    fun `구입 금액이 1000원 미만이면 IllegalArgumentException을 throw한다`(money: Int) {
        assertThrows<IllegalArgumentException> {
            lottoMachine.buyLottoTicket(money)
        }
    }
}
