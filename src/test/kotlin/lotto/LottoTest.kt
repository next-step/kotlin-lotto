package lotto

import lotto.domain.Amount
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

    @Test
    fun `로또 번호가 1~45 범위 내 무작위로 선택된다`() {

        val machine = LottoMachine(RandomGenerator())
        val lotto = machine.issue(Amount(1_000))[0]

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
        val lotto = machine.issue(Amount(1_000))[0]

        assertThat(lotto).containsExactlyInAnyOrder(
            LottoNum.of(2), LottoNum.of(7), LottoNum.of(10),
            LottoNum.of(40), LottoNum.of(41), LottoNum.of(45)
        )
    }

}