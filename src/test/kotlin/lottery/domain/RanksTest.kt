package lottery.domain

import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import org.junit.jupiter.api.Test

class RanksTest {
    @Test
    fun `로또 번호와 당첨 번호, 한 장당 구매 금액을 받아 순위 정보를 가지는 객체를 생성한다`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val userLotto = Lottos(1, InputNumberGenerator(lottoNumbers))
        val bonusNumber = 7
        val winningLotto = WinningLotto.of(lottoNumbers, bonusNumber)

        val ranks = Ranks(userLotto, winningLotto, 1000)

        ranks.shouldBeInstanceOf<Ranks>()
    }

    @Test
    fun `순위 객체는 각 로또에 대한 순위 정보를 가지고 있다`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val userLotto = Lottos(1, InputNumberGenerator(lottoNumbers))
        val bonusNumber = 7
        val winningLotto = WinningLotto.of(lottoNumbers, bonusNumber)

        val ranks = Ranks(userLotto, winningLotto, 1000)

        ranks.rank[0] shouldBe Rank.FIRST
    }

    @Test
    fun `구매 금액 대비 당첨금 비율이 1 이상이면 true를 반환한다`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val userLotto = Lottos(1, InputNumberGenerator(lottoNumbers))
        val bonusNumber = 7
        val winningLotto = WinningLotto.of(lottoNumbers, bonusNumber)

        val ranks = Ranks(userLotto, winningLotto, 1000)

        ranks.isProfitable() shouldBe true
    }
}
