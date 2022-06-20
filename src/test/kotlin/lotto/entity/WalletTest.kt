package lotto.entity

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class WalletTest {

    @Test
    fun `지갑에 있는 돈(money)를 꺼낼 수 있다`() {
        // given
        val wallet = Wallet(10000)

        // then
        Assertions.assertThat(wallet.money).isEqualTo(10000)
    }
}
