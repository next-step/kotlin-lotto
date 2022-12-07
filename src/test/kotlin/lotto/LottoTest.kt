package lotto

import lotto.domain.Lotto
import lotto.domain.LottoMachine
import lotto.domain.LottoNum
import lotto.domain.generator.Generator
import lotto.domain.generator.RandomGenerator
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoTest {

    @ParameterizedTest
    @CsvSource(value = ["10000,10", "14000,14", "1000,1"], delimiter = ',')
    fun `로또를 발행한다(금액 10000)`(amount: Int, count: Int) {
        val machine = LottoMachine(RandomGenerator())
        val lottos = machine.issue(amount)
        assertThat(lottos.size).isEqualTo(count)
    }

    @Test
    fun `로또 번호가 1~45 범위 내 무작위로 선택된다`() {

        val machine = LottoMachine(RandomGenerator())
        val lotto = machine.issue(1_000)[0]

        for(num in lotto) {
            assertThat(num.value).isGreaterThanOrEqualTo(1)
            assertThat(num.value).isLessThanOrEqualTo(45)
        }
    }

    @Test
    fun `로또 번호가 작은 수에서 큰 수로 정렬된다`() {

        val machine = LottoMachine(
            object : Generator {
                private val list = listOf(10, 2, 7, 45, 41, 40)

                override fun generate(): List<Int> {
                    return list
                }
            }
        )
        val lotto = machine.issue(1_000)[0]

        assertThat(lotto).containsExactlyInAnyOrder(
            LottoNum.of(2), LottoNum.of(7), LottoNum.of(10),
            LottoNum.of(40), LottoNum.of(41), LottoNum.of(45)
        )
    }

}