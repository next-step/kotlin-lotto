package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoTest {

    private lateinit var lotto: Lotto

    @BeforeEach()
    fun setUp() {
        lotto = Lotto()
    }

    @ParameterizedTest
    @ValueSource(strings = ["14000", "3000"])
    fun `입력받은 구입 금액을 로또 개당 가격으로 나눈 숫자만큼 티켓을 구매한다`(money: Int) {
        Assertions.assertThat(lotto.buyLottoTicket(money)).isEqualTo(money / Lotto.LOTTO_TICKET_PRICE)
    }

    @ParameterizedTest
    @ValueSource(strings = ["14000", "3000"])
    fun `입력받은 구입 금액에 맞게 로또를 구매한다`(money: Int) {
        val buyLottoTicket = lotto.buyLottoTicket(money)
        lotto.generateLottoNumbers(buyLottoTicket)
        val lottoNumberList = lotto.lottoNumbers.lottoNumberList
        Assertions.assertThat(lottoNumberList).hasSize(buyLottoTicket)
    }

    @ParameterizedTest
    @ValueSource(strings = ["999", "0", "-1000"])
    fun `구입 금액이 1000원 미만이면 IllegalArgumentException을 throw한다`(money: Int) {
        assertThrows<IllegalArgumentException> {
            lotto.buyLottoTicket(money)
        }
    }
}
