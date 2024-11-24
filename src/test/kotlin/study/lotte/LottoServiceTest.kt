package study.lotte

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import study.lotto.LotteService
import study.lotto.model.LottePrize
import study.lotto.model.Lotto

/**
 * @author 이상준
 */
class LottoServiceTest : StringSpec({
    val lotteService = LotteService()
    val winLottoStatMap = mutableMapOf<LottePrize, Int>()

    "로또 0원으로 구매시 개수 테스트" {
        val money = 0
        val lottos = lotteService.buyLotto(money)

        lottos.size shouldBe 0
    }
    "로또 2000원으로 구매시 개수 테스트" {
        val money = 2000
        val lottos = lotteService.buyLotto(money)

        lottos.size shouldBe 2
    }
    "로또 당첨 매칭 테스트 3개 일치" {
        val lotte = Lotto(setOf(1, 2, 3, 4, 5, 6))
        val winLotte = Lotto(setOf(1, 2, 3, 7, 8, 9))

        lotteService.matchLotto(lotte, winLotte) shouldBe 3
    }
    "로또 당첨 매칭 테스트 4개 일치" {
        val lotte = Lotto(setOf(1, 2, 3, 4, 5, 6))
        val winLotte = Lotto(setOf(1, 2, 3, 4, 8, 9))

        lotteService.matchLotto(lotte, winLotte) shouldBe 4
    }
    "로또 당첨 매칭 테스트 5개 일치" {
        val lotte = Lotto(setOf(1, 2, 3, 4, 5, 6))
        val winLotte = Lotto(setOf(1, 2, 3, 4, 5, 9))

        lotteService.matchLotto(lotte, winLotte) shouldBe 5
    }
    "로또 당첨 매칭 테스트 6개 일치" {
        val lotte = Lotto(setOf(1, 2, 3, 4, 5, 6))
        val winLotte = Lotto(setOf(1, 2, 3, 4, 5, 6))

        lotteService.matchLotto(lotte, winLotte) shouldBe 6
    }
    "로또 당첨 매칭 테스트 불일치" {
        val lotte = Lotto(setOf(1, 2, 3, 4, 5, 6))
        val winLotte = Lotto(setOf(7, 8, 9, 10, 11, 12))

        lotteService.matchLotto(lotte, winLotte) shouldBe 0
    }
    "로또 당첨 수익률 테스트 14000원 구매" {
        LottePrize.entries.forEach {
            winLottoStatMap[it] = 0
        }
        winLottoStatMap[LottePrize.FOURTH] = 1

        lotteService.profitLotto(winLottoStatMap, 14000) shouldBe 0.35
    }
    "로또 당첨 수익률 테스트 5000원 구매" {
        LottePrize.entries.forEach {
            winLottoStatMap[it] = 0
        }
        winLottoStatMap[LottePrize.FOURTH] = 1

        lotteService.profitLotto(winLottoStatMap, 5000) shouldBe 1.0
    }
})
