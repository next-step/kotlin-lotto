package lotto.domain

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class LottoDrawMachineTest : ShouldSpec({
    context("당첨 번호 [1, 2, 3, 4, 5, 6] / 보너스 7") {

        val lottoNumbers = (1..6).map { LottoNumber(it) }
        val winningLotto = WinningLotto(Lotto.from(lottoNumbers), LottoNumber(7))
        val lottoDrawMachine = LottoDrawMachine(winningLotto)

        context("로또 번호 [1, 2, 3, 4, 5, 6]") {
            val lotto = Lotto.from((1..6).map { LottoNumber(it) })
            val drawResult = lottoDrawMachine.draw(listOf(lotto))
            should("1등 당첨 순위 수 = 1") { drawResult.countOf(LottoRank.FIRST) shouldBe 1 }
            should("당첨 금액 = 1등 당첨금") { drawResult.totalReward shouldBe LottoRank.FIRST.reward }
            should("수익률 = 1등 당첨금(당첨금 / (구매 장 수 * 로또 가격)") {
                drawResult.profitability() shouldBe LottoRank.FIRST.reward / (1 * LottoStore.LOTTO_PRICE)
            }
        }

        context("로또 번호 [7, 8, 9, 10, 11, 12]") {
            val lotto = Lotto.from((7..12).map { LottoNumber(it) })
            val drawResult = lottoDrawMachine.draw(listOf(lotto))
            should("1등 당첨 순위 수 = 0") { drawResult.countOf(LottoRank.FIRST) shouldBe 0 }
            should("당첨 금액 = 0") { drawResult.totalReward shouldBe 0 }
            should("수익률 = 0") {
                drawResult.profitability() shouldBe 0
            }
        }
    }
})
