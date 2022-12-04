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
                private var index = 0
                private val list = listOf(10, 2, 7, 45, 41, 40)

                override fun generate(): Int {
                    if(index < list.size) return list[index++]
                    else throw IllegalStateException()
                }
            }
        )
        val lotto = machine.issue(1_000)[0]

        assertThat(lotto).containsExactlyInAnyOrder(LottoNum(2), LottoNum(7), LottoNum(10),
            LottoNum(40), LottoNum(41), LottoNum(45))
    }

}