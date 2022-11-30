package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WalletTest {

    @Test
    fun `지갑에 3000원이 있으면 로또를 3개를 구매한다`() {
        val wallet = Wallet(KRW(3000))
        wallet.buyLottos()

        assertThat(wallet.lottos.size).isEqualTo(3)
    }
}
