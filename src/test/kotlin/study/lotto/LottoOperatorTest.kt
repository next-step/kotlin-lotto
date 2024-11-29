package study.lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith
import study.lotto.model.LottoStat
import study.lotto.model.LottoStats
import study.lotto.model.Rank

/**
 * @author 이상준
 */
class LottoOperatorTest : StringSpec({
    val lottoOperator = LottoOperator()

    "로또 0개 구매시 예외 테스트" {
        val count = 0
        val exception =
            shouldThrow<IllegalArgumentException> {
                lottoOperator.buyLotto(count)
            }
        exception.message should startWith("Failed requirement.")
    }
    "로또 1개 구매시 개수 테스트" {
        val count = 1
        val lottos = lottoOperator.buyLotto(count)

        lottos.lottoCount() shouldBe 1
    }
    "로또 2개 구매시 개수 테스트" {
        val count = 2
        val lottos = lottoOperator.buyLotto(count)

        lottos.lottoCount() shouldBe 2
    }
    "로또 당첨 수익률 테스트 14000원 구매" {
        val winLottoStatSet = LottoStats(mutableSetOf(LottoStat(Rank.FOURTH, 1)))
        lottoOperator.getProfitLotto(winLottoStatSet, 14000) shouldBe 0.35
    }
    "로또 당첨 수익률 테스트 5000원 구매" {
        val winLottoStatSet = LottoStats(mutableSetOf(LottoStat(Rank.FOURTH, 1)))
        lottoOperator.getProfitLotto(winLottoStatSet, 5000) shouldBe 1.0
    }
})
