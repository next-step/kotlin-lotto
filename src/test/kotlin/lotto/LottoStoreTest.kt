package lotto

import lotto.domain.LottoStore
import lotto.domain.Wallet
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LottoStoreTest {

    @Test
    fun `수동 로또를 안사면 자동 로또만 사진다`() {
        // given
        val wallet = Wallet(14000)

        // when
        val purchaseLotto = LottoStore.purchaseLotto(wallet)

        // then
        assertThat(purchaseLotto.getAutoLottoSize()).isEqualTo(14)
    }

    @Test
    fun `수동 로또와 자동 로또의 갯수가 맞는지 테스트`() {
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
