package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoMachineTest {

    @Test
    fun `로또머신은 생성 시 로또금액을 입력받는다`() {
        val lottoPrice = Money(1000)
        val result = LottoMachine(lottoPrice = lottoPrice, lottoGenerator = DummyLottoGenerator())
        assertThat(result).isNotNull
    }

    @ParameterizedTest
    @CsvSource(
        "1000, 1000, 1",
        "10, 200, 20",
        "250, 1000, 4"
    )
    fun `로또금액에 따라 로또를 여러장 판매한다`(lottoPrice: Int, money: Int, expected: Int) {
        val lottoMachine = LottoMachine(lottoPrice = Money(lottoPrice), lottoGenerator = FakeLottoGenerator())
        val result = lottoMachine.sellLottos(money = Money(money))
        assertThat(result.size).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "1000, 1001",
        "10, 15"
    )
    fun `로또를 판매 시 받는 돈이 로또금액에 맞게 떨어지 않는 경우 예외를 반환한다`(lottoPrice: Int, money: Int) {
        val expectedMessage = "로또 구매 후 남은 돈이 있을 수 없습니다. money: $money, lottoPrice: $lottoPrice"
        val lottoMachine = LottoMachine(lottoPrice = Money(lottoPrice), lottoGenerator = FakeLottoGenerator())
        val result = assertThrows<IllegalArgumentException> { lottoMachine.sellLottos(money = Money(money)) }
        assertThat(result.message).isEqualTo(expectedMessage)
    }

    @ParameterizedTest
    @CsvSource(
        "1000, 999",
        "10, 5"
    )
    fun `로또를 판매 시 받는 돈이 로또 한개의 가격보다 작은 경우 예외를 반환한다`(lottoPrice: Int, money: Int) {
        val expectedMessage = "금액은 로또가격보다 크거나 같아야 합니다. money: $money, lottoPrice: $lottoPrice"
        val lottoMachine = LottoMachine(lottoPrice = Money(lottoPrice), lottoGenerator = FakeLottoGenerator())
        val result = assertThrows<IllegalArgumentException> { lottoMachine.sellLottos(money = Money(money)) }
        assertThat(result.message).isEqualTo(expectedMessage)
    }

    @Test
    fun `수동로또를 판매한다`() {
        val lottoPrice = 1000
        val money = 1000
        val manualLottoNumbers = (1..6).map(::LottoNumber)
        val manualLottos = listOf(ManualLottoGenerator(manualLottoNumbers))
        val expected = Lotto(manualLottoNumbers)
        val lottoMachine = LottoMachine(lottoPrice = Money(lottoPrice), lottoGenerator = DummyLottoGenerator())

        val result = lottoMachine.sellLottos(Money(money), manualLottos)

        assertThat(result).containsExactly(expected)
    }

    @Test
    fun `수동로또를 판매하고 남은 금액은 lottoGenerator가 생성한 로또를 판매한다`() {
        val lottoPrice = 1000
        val money = 3000
        val manualLottoNumbers = (1..6).map(::LottoNumber)
        val manualLottos = listOf(ManualLottoGenerator(manualLottoNumbers))
        val expected = listOf(Lotto(1..6), Lotto(11..16), Lotto(11..16))
        val lottoMachine = LottoMachine(lottoPrice = Money(lottoPrice), lottoGenerator = FakeLottoGenerator())

        val result = lottoMachine.sellLottos(Money(money), manualLottos)

        assertThat(result).containsExactly(*expected.toTypedArray())
    }

    @Test
    fun `수동로또를 구매하는데 금액이 부족한 경우 예외를 반환한다`() {
        val lottoPrice = 1000
        val money = 1000
        val manualLottoNumbers = (1..6).map(::LottoNumber)
        val manualLottos = listOf(ManualLottoGenerator(manualLottoNumbers), ManualLottoGenerator(manualLottoNumbers))
        val expected =
            "수동 로또를 구매하기에 부족한 금액입니다. money: $money, lottoPrice: $lottoPrice, manualLottoGenerators size: ${manualLottos.size}"
        val lottoMachine = LottoMachine(lottoPrice = Money(lottoPrice), lottoGenerator = DummyLottoGenerator())

        val result =
            assertThrows<IllegalArgumentException> { lottoMachine.sellLottos(Money(money), manualLottos) }

        assertThat(result.message).isEqualTo(expected)
    }

    private fun Lotto(number: IntRange) = Lotto(number.map(::LottoNumber))
}
