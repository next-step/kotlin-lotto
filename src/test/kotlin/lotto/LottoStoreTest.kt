package lotto

import lotto.domain.LottoStore
import lotto.domain.ManualLottoNumbers
import lotto.domain.Wallet
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoStoreTest {

    @Test
    fun `14000원으로 수동 로또를 안사면 자동 로또가 14장이 구매가 되어지는지 테스트`() {
        // given
        val wallet = Wallet(14000)
        val manualLottoNumbers = ManualLottoNumbers.generateManualLottoNumbers(listOf())
        val manualLottoSize = manualLottoNumbers.getManualLottoNumberSize()
        val lottoStore = LottoStore()

        // when
        val lottos = lottoStore.sellLotto(wallet.getAbleToBuyAutoLottoCounts(manualLottoSize), manualLottoNumbers)

        // then
        assertThat(lottos.getSize()).isEqualTo(14)
    }

    @Test
    fun `14000원으로 수동 로또 3장을 사면, 자동 11장이 사지고, 총 14장의 로또가 구매된다`() {
        // given
        val wallet = Wallet(14000)
        val manualLottoTexts = listOf("1,2,3,4,5,6", "1,2,3,4,5,6", "2,3,4,5,6,7")
        val manualLottoNumbers = ManualLottoNumbers.generateManualLottoNumbers(manualLottoTexts)
        val manualLottoSize = manualLottoNumbers.getManualLottoNumberSize()
        val lottoStore = LottoStore()

        // when
        val lottos = lottoStore.sellLotto(wallet.getAbleToBuyAutoLottoCounts(manualLottoSize), manualLottoNumbers)

        //
        assertThat(lottos.getSize()).isEqualTo(14)
    }
}
