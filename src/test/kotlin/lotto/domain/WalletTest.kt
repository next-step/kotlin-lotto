package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WalletTest {

    @Test
    fun `Wallet 은 처음에 0원을 가진다`() {
        assertThat(Wallet().money).isEqualTo(0)
    }

    @Test
    fun `0원인 지갑에 3000원을 넣으면 3000원이 된다`() {
        val wallet = Wallet()
        wallet.insertMoney("3000")
        assertThat(wallet.money).isEqualTo(3000)
    }

    @Test
    fun `지갑에 3000원이 있으면 로또를 3개를 구매하고 0원이 된다`() {
        val wallet = Wallet(Value(3000))
        wallet.buyLottos()

        assertThat(wallet.money).isEqualTo(0)
        assertThat(wallet.lottos.size).isEqualTo(3)
    }
}
