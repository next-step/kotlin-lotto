package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WalletTest {

    @Test
    fun `지갑에 1000원이 있으면 자동으로 로또를 구매할 수 있다`() {
        val wallet = Wallet(KRW(1000))
        val lottos = wallet.buyAutoLottos()

        assertThat(lottos.size).isEqualTo(1)
        assertThat(wallet.krw.money).isEqualTo(0)
    }

    @Test
    fun `지갑에 1000원이 있으면 수동으로 로또를 구매할 수 있다`() {
        val wallet = Wallet(KRW(1000))
        val lottos = wallet.buyManualLottos(lotto = listOf("1,2,3,4,5,6"))

        assertThat(lottos.size).isEqualTo(1)
        assertThat(wallet.krw.money).isEqualTo(0)
    }

    @Test
    fun `지갑에 2000원이 있으면 자동과 수동으로 각각 1장씩 로또를 구매할 수 있다`() {
        val wallet = Wallet(KRW(2000))
        val manualLottos = wallet.buyManualLottos(lotto = listOf("1,2,3,4,5,6"))
        assertThat(manualLottos.size).isEqualTo(1)
        assertThat(wallet.krw.money).isEqualTo(1000)

        val autoLottos = wallet.buyAutoLottos()
        assertThat(autoLottos.size).isEqualTo(2)
        assertThat(wallet.krw.money).isEqualTo(0)
    }
}
