package lotto.domain.machine

import lotto.domain.Money
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class RandomLottoMachineTest {

    @CsvSource(value = ["1000:1", "14000:14"], delimiter = ':')
    @ParameterizedTest
    internal fun `로또 티켓이 발행 된다`(inputMoney: Int, expectedSize: Int) {
        // given
        val randomLottoMachine = RandomLottoMachine(Money.of(inputMoney))

        // when
        val lottoTickets = randomLottoMachine.publish()

        // then
        assertThat(lottoTickets.items).hasSize(expectedSize)
    }

    @Test
    internal fun `금액이 0원이면 0개가 발행된다`() {
        // given
        val money = 0
        // when, then
        assertThat(RandomLottoMachine(Money.of(money)).publish().count()).isEqualTo(0)
    }

    @ValueSource(ints = [900, 12100])
    @ParameterizedTest
    internal fun `잔금이 남으면 예외가 발행된다`(inputMoney: Int) {
        // given
        val money = 12100
        // when, then
        assertThatIllegalArgumentException().isThrownBy { RandomLottoMachine(Money.of(money)) }
    }

}
