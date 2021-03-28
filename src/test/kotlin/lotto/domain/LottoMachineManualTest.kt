package lotto.domain

import lotto.domain.FakeLottoGenerator.Companion.fakeLottoNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoMachineManualTest {

    private val lottoPrice = 1000
    private val oneToSixLottoNumbers = (1..6).map(::LottoNumber)
    private val oneToSixManualLottoGenerator = ManualLottoGenerator(oneToSixLottoNumbers)

    @Test
    fun `수동로또를 판매한다`() {
        val money = 1000
        val manualLottoGenerators = listOf(oneToSixManualLottoGenerator)
        val expected = Lotto(oneToSixLottoNumbers)
        val lottoMachine = LottoMachine(lottoPrice = Money(lottoPrice), lottoGenerator = DummyLottoGenerator())

        val result = lottoMachine.sellLottos(Money(money), manualLottoGenerators)

        assertThat(result).containsExactly(expected)
    }

    @Test
    fun `수동로또를 판매하고 남은 금액은 lottoGenerator가 생성한 로또를 판매한다`() {
        val money = 3000
        val manualLottoGenerators = listOf(oneToSixManualLottoGenerator)
        val expected = listOf(Lotto(oneToSixLottoNumbers), Lotto(fakeLottoNumbers), Lotto(fakeLottoNumbers))
        val lottoMachine = LottoMachine(lottoPrice = Money(lottoPrice), lottoGenerator = FakeLottoGenerator())

        val result = lottoMachine.sellLottos(Money(money), manualLottoGenerators)

        assertThat(result).containsExactly(*expected.toTypedArray())
    }

    @Test
    fun `수동로또를 구매하는데 금액이 부족한 경우 예외를 반환한다`() {
        val money = 1000
        val manualLottoGenerators = listOf(oneToSixManualLottoGenerator, oneToSixManualLottoGenerator)
        val expected =
            "수동 로또를 구매하기에 부족한 금액입니다. money: $money, lottoPrice: $lottoPrice, manualLottoGenerators size: ${manualLottoGenerators.size}"
        val lottoMachine = LottoMachine(lottoPrice = Money(lottoPrice), lottoGenerator = DummyLottoGenerator())

        val result =
            assertThrows<IllegalArgumentException> { lottoMachine.sellLottos(Money(money), manualLottoGenerators) }

        assertThat(result.message).isEqualTo(expected)
    }
}
