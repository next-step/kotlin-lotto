package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class MachineTest {

    @ParameterizedTest
    @CsvSource(
        value = [
            "10000, 10",
            "10001, 10",
            "11001, 11",
            "900, 0",
            "0, 0",
        ]
    )
    fun `구매 금액 기준 구매할 수 있는 로또 수 확인`(money: Int, expected: Int) {
        assertThat(Machine(money).lottoCount).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "10000, 10",
            "10001, 10",
            "11001, 11",
            "900, 0",
            "0, 0",
        ]
    )
    fun `구매 금액 기준 실제 생성된 로또의 수 확인`(money: Int, expected: Int) {
        assertThat(Machine(money).apply {
            this.checkResult("1,2,3,4,5,6")
        }.lottoResultList.size).isEqualTo(expected)
    }
}
