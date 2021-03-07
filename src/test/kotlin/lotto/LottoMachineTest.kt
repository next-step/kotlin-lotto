package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LottoMachineTest {

    @Test
    fun `로또머신은 생성 시 로또금액을 입력받는다`() {
        val lottoPrice = 1000
        val result = LottoMachine(lottoPrice = lottoPrice)
        assertThat(result).isNotNull
    }

    @ParameterizedTest
    @ValueSource(ints = [-1000, 0])
    fun `로또금액이 음수이거나 0인 경우 예외를 반환한다`(lottoPrice: Int) {
        val expectedMessage = "로또금액은 0보다 커야합니다"
        val result = assertThrows<IllegalArgumentException> { LottoMachine(lottoPrice = lottoPrice) }
        assertThat(result.message).isEqualTo(expectedMessage)
    }

    @ParameterizedTest
    @CsvSource(
        "1000, 1000, 1",
        "10, 200, 20",
        "250, 1000, 4"
    )
    fun `로또금액에 따라 로또를 여러장 판매한다`(lottoPrice: Int, money: Int, expected: Int) {
        val lottoMachine = LottoMachine(lottoPrice = lottoPrice)
        val result = lottoMachine.sellLottos(money = money)
        assertThat(result.size).isEqualTo(expected)
    }
}
