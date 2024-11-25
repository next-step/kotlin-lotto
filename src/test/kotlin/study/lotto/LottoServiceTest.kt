package study.lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith
import study.lotto.model.LottoPrize
import study.lotto.model.LottoStat

/**
 * @author 이상준
 */
class LottoServiceTest : StringSpec({
    val lottoService = LottoService()

    "로또 0원으로 구매시 예외 테스트" {
        val money = 0
        val exception = shouldThrow<IllegalArgumentException> {
            lottoService.buyLotto(money)
        }
        exception.message should startWith("로또 구입금액은 최소")

    }
    "로또 2000원으로 구매시 개수 테스트" {
        val money = 2000
        val lottos = lottoService.buyLotto(money)

        lottos.size shouldBe 2
    }
    "로또 당첨 수익률 테스트 14000원 구매" {
        val winLottoStatSet = mutableSetOf<LottoStat>()
        winLottoStatSet.add(LottoStat(LottoPrize.FOURTH, 1))
        lottoService.profitLotto(winLottoStatSet, 14000) shouldBe 0.35
    }
    "로또 당첨 수익률 테스트 5000원 구매" {
        val winLottoStatSet = mutableSetOf<LottoStat>()
        winLottoStatSet.add(LottoStat(LottoPrize.FOURTH, 1))
        lottoService.profitLotto(winLottoStatSet, 5000) shouldBe 1.0
    }
})
