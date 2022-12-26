package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf

class RoundTest : DescribeSpec ({
    describe("로또 회차 테스트") {
        val lottoNumbers = (1..6).map { LottoNumber.of(it) }.toSet()
        val lotto = Lotto(lottoNumbers)
        val purchasedLottos = Lottos(listOf(lotto))

        val winningLottosNumbers = (3..8).map { LottoNumber.of(it) }.toSet()
        val bonusNumber = LottoNumber.of(9)
        val winningLotto = WinningLotto(Lotto(winningLottosNumbers), bonusNumber)

        val round = Round(purchasedLottos, winningLotto)
        val aggregateResult = round.aggregate()

        it("구매한 로또 리스트들과 당첨 로또 사이의 랭킹을 집계를 할 수 있다.") {
            aggregateResult.shouldBeInstanceOf<RoundResult>()
            aggregateResult.getCountOfRank(Rank.FOURTH) shouldBe 1
            aggregateResult.getCountOfRank(Rank.FIFTH) shouldBe 0
        }

        it("구매한 로또 리스트들과 당첨 로또 사이의 수익률을 계산할 수 있다.") {
            val earningRate = aggregateResult.calculateEarningRate()

            earningRate shouldBe 50
        }
    }
})
