package lotto.domain.machine

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class RandomLottoMachineTest {

    @CsvSource(value = ["1000:1", "14000:14"], delimiter = ':')
    @ParameterizedTest
    internal fun `로또 티켓이 발행 된다`(inputMoney: Int, expectedSize: Int) {
        // given
        val randomLottoMachine = RandomLottoMachine(inputMoney)

        // when
        val lottoTickets = randomLottoMachine.publish()

        // then
        assertThat(lottoTickets.items).hasSize(expectedSize)
    }

    @ValueSource(ints = [900, 12100])
    @ParameterizedTest
    internal fun `로또 티켓 가격보다 낮거나, 잔금이 남으면 기계 생성에 실패한다`(inputMoney: Int) {
        // given
        // when, then
        assertThatIllegalArgumentException().isThrownBy { RandomLottoMachine(inputMoney) }
    }

}
