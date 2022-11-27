package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WalletResultTest {

    @Test
    fun `로또 당첨 수를 분류할 수 있다`() {
        val results = listOf(
            LottoResult.FirstWin,
            LottoResult.SecondWin,
            LottoResult.SecondWin,
            LottoResult.ThirdWin,
            LottoResult.ThirdWin,
            LottoResult.ThirdWin,
            LottoResult.FourthWin,
            LottoResult.FourthWin,
            LottoResult.FourthWin,
            LottoResult.FourthWin
        )

        val walletResult = WalletResult(results)

        assertThat(walletResult.getFirstWinCount()).isEqualTo(1)
        assertThat(walletResult.getSecondWinCount()).isEqualTo(2)
        assertThat(walletResult.getThirdWinCount()).isEqualTo(3)
        assertThat(walletResult.getFourthWinCount()).isEqualTo(4)
    }
}
