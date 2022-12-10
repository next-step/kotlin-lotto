package lotto

import lotto.domain.Amount
import lotto.domain.LottoMachine
import lotto.domain.generator.RandomGenerator
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import kotlin.random.Random

class LottoMachineTest {

    @ParameterizedTest
    @CsvSource(value = ["10000,10", "14000,14", "1000,1"], delimiter = ',')
    fun `로또를 발급한다(금액 10_000)`(amount: Int, count: Int) {
        val machine = LottoMachine(RandomGenerator())
        val lottos = machine.issue(Amount(amount))
        assertThat(lottos.size).isEqualTo(count)
    }
}