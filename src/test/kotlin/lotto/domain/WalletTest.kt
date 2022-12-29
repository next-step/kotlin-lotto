package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WalletTest {

    @Test
    fun `지갑을 생성할 땐 0원으로 생성할 수 없다`() {
        assertThrows<IllegalArgumentException> {
            Wallet(KRW(0))
        }
    }

    @Test
    fun `지갑에 1000원이 있으면 자동으로 로또를 구매할 수 있다`() {
        val wallet = Wallet(KRW(1000))
        wallet.buyAutoLottos()
        assertThat(wallet.lottos.size).isEqualTo(1)
        assertThat(wallet.krw.money).isEqualTo(0)
    }

    @Test
    fun `지갑에 1000원이 있으면 수동으로 로또를 구매할 수 있다`() {
        val wallet = Wallet(KRW(1000))
        wallet.buyManualLottos(lotto = listOf("1,2,3,4,5,6"))

        assertThat(wallet.lottos.size).isEqualTo(1)
        assertThat(wallet.krw.money).isEqualTo(0)
    }

    @Test
    fun `지갑에 2000원이 있으면 자동과 수동으로 각각 1장씩 로또를 구매할 수 있다`() {
        val wallet = Wallet(KRW(2000))
        wallet.buyManualLottos(lotto = listOf("1,2,3,4,5,6"))
        assertThat(wallet.manualLottoCount).isEqualTo(1)
        assertThat(wallet.lottos.size).isEqualTo(1)
        assertThat(wallet.krw.money).isEqualTo(1000)

        wallet.buyAutoLottos()
        assertThat(wallet.autoLottoCount).isEqualTo(1)
        assertThat(wallet.lottos.size).isEqualTo(2)
        assertThat(wallet.krw.money).isEqualTo(0)
    }
}
