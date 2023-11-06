package lottoTest

import lotto.Lotto
import lotto.LottoMachine
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoMachineTest {

    @ParameterizedTest
    @CsvSource(
        value = [
            "10000, 10",
            "12345, 12",
            "24680, 24",
        ]
    )
    fun `금액만큼 로또를 구매`(input: Int, expected: Int) {
        val lottoList: List<Lotto> = LottoMachine().purchase(input)

        assertEquals(expected, lottoList.count())
        lottoList.forEach {
            assertThat(it).isExactlyInstanceOf(Lotto::class.java)
        }
    }
}
