package lotto.domain

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
        val result = LottoMachine(lottoPrice = lottoPrice, lottoGenerator = DummyLottoGenerator())
        assertThat(result).isNotNull
    }

    @ParameterizedTest
    @ValueSource(ints = [-1000, 0])
    fun `로또금액이 음수이거나 0인 경우 예외를 반환한다`(lottoPrice: Int) {
        val expectedMessage = "로또금액은 0보다 커야합니다"
        val result = assertThrows<IllegalArgumentException> {
            LottoMachine(lottoPrice = lottoPrice, lottoGenerator = DummyLottoGenerator())
        }
        assertThat(result.message).isEqualTo(expectedMessage)
    }

    @ParameterizedTest
    @CsvSource(
        "1000, 1000, 1",
        "10, 200, 20",
        "250, 1000, 4"
    )
    fun `로또금액에 따라 로또를 여러장 판매한다`(lottoPrice: Int, money: Int, expected: Int) {
        val lottoMachine = LottoMachine(lottoPrice = lottoPrice, lottoGenerator = FakeLottoGenerator())
        val result = lottoMachine.sellLottos(money = money)
        assertThat(result.size).isEqualTo(expected)
    }


    @ParameterizedTest
    @CsvSource(
        "1000, 1001",
        "10, 15"
    )
    fun `로또를 판매 시 받는 돈이 로또금액에 맞게 떨어지 않는 경우 예외를 반환한다`(lottoPrice: Int, money: Int) {
        val expectedMessage = "로또 구매 후 남은 돈이 있을 수 없습니다. money: $money, lottoPrice: $lottoPrice"
        val lottoMachine = LottoMachine(lottoPrice = lottoPrice, lottoGenerator = FakeLottoGenerator())
        val result = assertThrows<java.lang.IllegalArgumentException> { lottoMachine.sellLottos(money = money) }
        assertThat(result.message).isEqualTo(expectedMessage)
    }


    @ParameterizedTest
    @CsvSource(
        "1000, 999",
        "10, 5",
        "1, -1"
    )
    fun `로또를 판매 시 받는 돈이 로또 한개의 가격보다 작은 경우 예외를 반환한다`(lottoPrice: Int, money: Int) {
        val expectedMessage = "금액은 로또가격보다 크거나 같아야 합니다. money: $money, lottoPrice: $lottoPrice"
        val lottoMachine = LottoMachine(lottoPrice = lottoPrice, lottoGenerator = FakeLottoGenerator())
        val result = assertThrows<java.lang.IllegalArgumentException> { lottoMachine.sellLottos(money = money) }
        assertThat(result.message).isEqualTo(expectedMessage)
    }
}
