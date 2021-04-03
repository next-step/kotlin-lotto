package lotto.domain

import lotto.domain.FakeLottoGenerator.Companion.fakeLottoNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMachineManualTest {

    private val lottoPrice = 1000
    private val oneToSixLottoNumbers = (1..6).map(::LottoNumber)
    private val oneToSixManualLottoGenerator = ManualLottoGenerator(oneToSixLottoNumbers)

    @Test
    fun `수동로또를 판매한다`() {
        val money = 1000
        val manualLottoGenerators = listOf(oneToSixManualLottoGenerator)
        val expected = Lotto(oneToSixLottoNumbers)
        val lottoMachine = LottoMachine(lottoPrice = Money(lottoPrice), randomLottoGenerator = DummyLottoGenerator())

        val result = lottoMachine.sellLottos(Money(money), manualLottoGenerators)

        assertThat(result).containsExactly(expected)
    }

    @Test
    fun `수동로또를 판매하고 남은 금액은 lottoGenerator가 생성한 로또를 판매한다`() {
        val money = 3000
        val manualLottoGenerators = listOf(oneToSixManualLottoGenerator)
        val expected = listOf(Lotto(oneToSixLottoNumbers), Lotto(fakeLottoNumbers), Lotto(fakeLottoNumbers))
        val lottoMachine = LottoMachine(lottoPrice = Money(lottoPrice), randomLottoGenerator = FakeLottoGenerator())

        val result = lottoMachine.sellLottos(Money(money), manualLottoGenerators)

        assertThat(result).containsExactly(*expected.toTypedArray())
    }
}
