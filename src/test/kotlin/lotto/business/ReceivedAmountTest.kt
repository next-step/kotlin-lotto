package lotto.business

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ReceivedAmountTest {

    @ParameterizedTest
    @ValueSource(ints = [999, 900, 0, -1, -1000])
    fun `금액이 1000원 이하이면 예외를 던진다`(amount: Int) {
        assertThatThrownBy { ReceivedAmount(amount) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또 구입 금액은 ${ReceivedAmount.LOTTO_PRICE}원 이상이어야 합니다.")
    }

    @ParameterizedTest
    @ValueSource(ints = [1001, 1100, 2001, 2100, 3001, 3100, 4001, 4100, 5001, 5100])
    fun `금액이 1000원 단위가 아니면 예외를 던진다`(amount: Int) {
        assertThatThrownBy { ReceivedAmount(amount) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또 구입 금액은 ${ReceivedAmount.LOTTO_PRICE}원 단위로 입력해주세요.")
    }

    @ParameterizedTest
    @ValueSource(ints = [1000, 2000, 3000, 4000, 5000])
    fun `금액이 1000원 이상이고 1000원 단위이면 예외를 던지지 않는다`(amount: Int) {
        ReceivedAmount(amount)
    }

    @ParameterizedTest
    @ValueSource(ints = [1000, 2000, 3000, 4000, 5000])
    fun `금액이 1000원 이상이고 1000원 단위이면 티켓 수를 반환한다`(amount: Int) {
        // when
        val receivedAmount = ReceivedAmount(amount)

        // then
        assertThat(receivedAmount.getTicketCount()).isEqualTo(amount / ReceivedAmount.LOTTO_PRICE)
    }
}
