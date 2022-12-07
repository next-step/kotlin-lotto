package lotto

import lotto.domain.LottoMachine
import lotto.domain.generator.RandomGenerator
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoMachineTest {

    @ParameterizedTest
    @CsvSource(value = ["10000,10", "14000,14", "1000,1"], delimiter = ',')
    fun `로또를 발행한다(금액 10000)`(amount: Int, count: Int) {
        val machine = LottoMachine(RandomGenerator())
        val lottos = machine.issue(amount)
        assertThat(lottos.size).isEqualTo(count)
    }
}