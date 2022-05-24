package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoUserTest {
    private lateinit var lottoUser: LottoUser

    @BeforeEach
    fun setup() {
        lottoUser = LottoUser()
    }

    @Test
    fun `당첨 번호를 알려주면 로또 당첨금의 총합을 계산한다`() {
        lottoUser.purchaseLotto(3000)
        lottoUser.lottos[0].processLotto(listOf(0, 0, 3, 1, 2, 0))
        lottoUser.lottos[1].processLotto(listOf(1, 2, 3, 10, 0, 0))
        lottoUser.lottos[2].processLotto(listOf(1, 0, 3, 0, 0, 0))
        assertThat(lottoUser.calculateWinningMoney(listOf(1, 2, 3, 10, 6, 7))).isEqualTo(55000)
    }

    @Test
    fun `수익률은 (당첨금의 모든 합) 나누기 (구매한 금액)로 계산하여 소수점 두자리까지 계산한다`() {
        val spendMoney = 6000
        lottoUser.purchaseLotto(spendMoney)
        lottoUser.lottos[0].processLotto(listOf(0, 0, 3, 1, 2, 0))
        lottoUser.lottos[1].processLotto(listOf(1, 2, 3, 10, 0, 0))
        lottoUser.lottos[2].processLotto(listOf(1, 0, 3, 0, 0, 0))
        lottoUser.lottos[3].processLotto(listOf(1, 0, 3, 0, 0, 0))
        lottoUser.lottos[4].processLotto(listOf(1, 0, 3, 0, 0, 0))
        lottoUser.lottos[5].processLotto(listOf(1, 0, 3, 0, 0, 0))
        val winningMoney = lottoUser.calculateWinningMoney(listOf(1, 2, 3, 10, 6, 7)) // 55_000
        assertThat(lottoUser.calculateRateOfReturn(spendMoney = spendMoney, winningMoney = winningMoney)).isEqualTo(9.17)
    }
}
