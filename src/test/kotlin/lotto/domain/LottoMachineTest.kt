package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoMachineTest {

    @Test
    fun `로또머신은 생성 시 로또금액을 입력받는다`() {
        val lottoPrice = Money(1000)
        val result = LottoMachine(lottoPrice = lottoPrice, randomLottoGenerator = DummyLottoGenerator())
        assertThat(result).isNotNull
    }

    @ParameterizedTest
    @CsvSource(
        "1000, 1000, 1",
        "10, 200, 20",
        "250, 1000, 4"
    )
    fun `로또금액에 따라 로또를 여러장 판매한다`(lottoPrice: Int, money: Int, expected: Int) {
        val lottoMachine = LottoMachine(lottoPrice = Money(lottoPrice), randomLottoGenerator = FakeLottoGenerator())
        val result = lottoMachine.sellLottos(money = Money(money))
        assertThat(result.size).isEqualTo(expected)
    }
}
