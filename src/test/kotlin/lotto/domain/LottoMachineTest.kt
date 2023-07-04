package lotto.domain

import lotto.helper.LottoNumbersHelper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMachineTest {

    @Test
    fun `5500원으로 로또 구매시 2장은 수동 로또를 구매한다`() {
        // given
        val price = 5_500
        val manualLottoCount = ManualLottoCount(2, price)
        val lottoNumbers = List(2) { LottoNumbersHelper.generate(1, 2, 3, 4, 5, 6) }

        // when
        val lottos = LottoMachine(FakeLottoNumberGenerator()).buy(manualLottoCount, lottoNumbers)

        // then
        assertThat(lottos.lottos.size).isEqualTo(5)
    }
}
