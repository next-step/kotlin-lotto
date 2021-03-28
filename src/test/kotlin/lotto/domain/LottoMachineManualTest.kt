package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoMachineManualTest {

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
