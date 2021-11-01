package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@Suppress("NonAsciiCharacters")
class LottoMoneyTest {

    @Test
    fun `LottoMoney는 음수가 될 수 없다`() {
        // given
        val money = -1000

        // when
        val create: () -> Unit = { LottoMoney(money) }

        // then
        assertThrows<IllegalArgumentException>(create)
    }

    @ParameterizedTest
    @ValueSource(ints = [999, 1001, 1500, 1990, 1999])
    fun `1000원 단위가 아닌 LottoMoney 생성은 예외가 발생한다`(money: Int) {
        // when
        val create: () -> Unit = { LottoMoney(money) }

        // then
        assertThrows<IllegalArgumentException>(create)
    }

    @Test
    fun `티켓 갯수가 주어지면 갯수만큼 사고 남은 거스름돈을 계산한다`() {
        // given
        val money = LottoMoney(10000)
        val count = LottoTicketCount(6)

        // when
        val result = money.calculateChange(count)

        // then
        assertThat(result.value).isEqualTo(4000)
    }

    @Test
    fun `주어진 돈으로 살 수 있는 티켓 갯수를 계산한다`() {
        // given
        val money = LottoMoney(10000)

        // when
        val result = money.calculateCount()

        // then
        assertThat(result.value).isEqualTo(10)
    }
}
