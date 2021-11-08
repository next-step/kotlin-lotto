package lotto

import lotto.domain.LottoStore
import lotto.domain.Wallet
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LottoStoreTest {

    @Test
    fun `14000원으로 수동 로또를 안사면 자동 로또가 14장이 구매가 되어지는지 테스트`() {
        // given
        val wallet = Wallet(14000)

        // when
        val purchaseLotto = LottoStore.purchaseLotto(wallet)

        // then
        assertThat(purchaseLotto.getAutoLottoSize()).isEqualTo(14)
    }

    @Test
    fun `14000원으로 수동 로또 3장을 사면, 수동 로또는 3장, 자동 로또는 11장인지 테스트`() {
        // given
        val wallet = Wallet(14000)
        val manualLottoTexts = listOf("1,2,3,4,5,6", "1,2,3,4,5,6", "2,3,4,5,6,7")

        // when
        val purchaseLotto = LottoStore.purchaseLotto(wallet, manualLottoTexts)

        //
        assertAll({
            assertThat(purchaseLotto.getAutoLottoSize()).isEqualTo(11)
            assertThat(purchaseLotto.getManualLottoSize()).isEqualTo(3)
        })
    }
}
