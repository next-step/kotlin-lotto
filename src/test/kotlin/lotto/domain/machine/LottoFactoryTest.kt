package lotto.domain.machine

import org.assertj.core.api.Assertions.*

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoFactoryTest {


    @ValueSource(ints = [900, 12100])
    @ParameterizedTest
    internal fun `로또 티켓 가격보다 낮거나, 잔금이 남으면 기계 생성에 실패한다`(inputMoney: Int) {
        // given
        // when, then
        assertThatIllegalArgumentException().isThrownBy { LottoFactory(inputMoney) }
    }

    @Test
    fun `입력받은 금액 내에 구매 가능한지 확인한다`() {
        // given
        val lottoFactory = LottoFactory(2000)

        // when, then
        assertThat(lottoFactory.isBuyAble(3)).isFalse
        assertThat(lottoFactory.isBuyAble(1)).isTrue
    }

    @Test
    fun `입력받은 티켓이 없어도 남은 금액으로 티켓 구매가 이뤄진다`() {
        // given
        val lottoFactory = LottoFactory(14000)

        // when
        val tickets = lottoFactory.buyTickets(emptyList())

        // then
        assertThat(tickets.count()).isEqualTo(14)
    }

    @Test
    fun `수기로 모든 티켓을 입력받아도 티켓 구매가 이뤄진다`() {
        // given
        val lottoFactory = LottoFactory(2000)

        // when
        val tickets = lottoFactory.buyTickets(
            listOf(
                listOf(1, 2, 3, 4, 5, 6),
                listOf(2, 3, 4, 5, 6, 7)
            )
        )

        // then
        assertThat(tickets.count()).isEqualTo(2)
    }


    @Test
    fun `입력받은 티켓을 제외하고 남은 금액으로 티켓 구매가 이뤄진다`() {
        // given
        val lottoFactory = LottoFactory(3000)

        // when
        val tickets = lottoFactory.buyTickets(
            listOf(
                listOf(1, 2, 3, 4, 5, 6),
                listOf(2, 3, 4, 5, 6, 7)
            )
        )

        // then
        assertThat(tickets.count()).isEqualTo(3)
    }


}
