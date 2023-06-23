package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoAnalyzerTest : StringSpec({
    "1개를 구입해서 5등에 1개 당첨된 경우, 올바른 lottoStatics를 생성한다" {
        val lottoPrice = 1000
        val winLotto = WinLotto.create(listOf(1, 2, 3, 4, 5, 6), 7)

        val lottos = listOf(Lotto(listOf(1, 2, 3, 7, 8, 9).map { number -> LottoNumber(number) }.toHashSet()))

        val lottoStatics = LottoAnalyzer(winLotto, lottoPrice).createLottoStatics(lottos)
        lottoStatics.ranks.size shouldBe 1
        lottoStatics.totalBuyAmount shouldBe lottoPrice * lottos.size
        lottoStatics.totalWinningPrice shouldBe LottoRank.FIFTH.winningMoney * lottoStatics.ranks[LottoRank.FIFTH]!!
        lottoStatics.rateOfReturn shouldBe LottoRank.FIFTH.winningMoney / lottoPrice * lottos.size.toDouble()
    }

    "10개를 구입해서 5등에 3개 당첨된 경우, 올바른 lottoStatics를 생성한다" {
        val lottoPrice = 1000
        val winLotto = WinLotto.create(listOf(1, 2, 3, 4, 5, 6), 7)
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 7, 8, 9).map { number -> LottoNumber(number) }.toHashSet()), // 5등
            Lotto(listOf(1, 2, 3, 7, 8, 9).map { number -> LottoNumber(number) }.toHashSet()), // 5등
            Lotto(listOf(1, 2, 3, 7, 8, 9).map { number -> LottoNumber(number) }.toHashSet()), // 5등
            Lotto(listOf(11, 22, 33, 7, 8, 9).map { number -> LottoNumber(number) }.toHashSet()), // 낙첨
            Lotto(listOf(11, 22, 33, 7, 8, 9).map { number -> LottoNumber(number) }.toHashSet()), // 낙첨
            Lotto(listOf(11, 22, 33, 7, 8, 9).map { number -> LottoNumber(number) }.toHashSet()), // 낙첨
            Lotto(listOf(11, 22, 33, 7, 8, 9).map { number -> LottoNumber(number) }.toHashSet()), // 낙첨
            Lotto(listOf(11, 22, 33, 7, 8, 9).map { number -> LottoNumber(number) }.toHashSet()), // 낙첨
            Lotto(listOf(11, 22, 33, 7, 8, 9).map { number -> LottoNumber(number) }.toHashSet()), // 낙첨
            Lotto(listOf(11, 22, 33, 7, 8, 9).map { number -> LottoNumber(number) }.toHashSet()), // 낙첨
        )

        val lottoStatics = LottoAnalyzer(winLotto, lottoPrice).createLottoStatics(lottos)
        lottoStatics.ranks.size shouldBe 1
        lottoStatics.totalBuyAmount shouldBe lottoPrice * lottos.size
        lottoStatics.totalWinningPrice shouldBe LottoRank.FIFTH.winningMoney * 3
        lottoStatics.rateOfReturn shouldBe LottoRank.FIFTH.winningMoney * 3 / (lottoPrice * lottos.size).toDouble()
    }

    "10개를 구입해서 5등에 3개, 2등에 1개 당첨된 경우, 올바른 lottoStatics를 생성한다" {
        val lottoPrice = 1000
        val winLotto = WinLotto.create(listOf(1, 2, 3, 4, 5, 6), 7)
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 7, 8, 9).map { number -> LottoNumber(number) }.toHashSet()), // 5등
            Lotto(listOf(1, 2, 3, 7, 8, 9).map { number -> LottoNumber(number) }.toHashSet()), // 5등
            Lotto(listOf(1, 2, 3, 7, 8, 9).map { number -> LottoNumber(number) }.toHashSet()), // 5등
            Lotto(listOf(1, 2, 3, 4, 5, 7).map { number -> LottoNumber(number) }.toHashSet()), // 2등
            Lotto(listOf(11, 22, 33, 7, 8, 9).map { number -> LottoNumber(number) }.toHashSet()), // 낙첨
            Lotto(listOf(11, 22, 33, 7, 8, 9).map { number -> LottoNumber(number) }.toHashSet()), // 낙첨
            Lotto(listOf(11, 22, 33, 7, 8, 9).map { number -> LottoNumber(number) }.toHashSet()), // 낙첨
            Lotto(listOf(11, 22, 33, 7, 8, 9).map { number -> LottoNumber(number) }.toHashSet()), // 낙첨
            Lotto(listOf(11, 22, 33, 7, 8, 9).map { number -> LottoNumber(number) }.toHashSet()), // 낙첨
            Lotto(listOf(11, 22, 33, 7, 8, 9).map { number -> LottoNumber(number) }.toHashSet()), // 낙첨
        )

        val lottoStatics = LottoAnalyzer(winLotto, lottoPrice).createLottoStatics(lottos)
        lottoStatics.ranks.size shouldBe 2
        lottoStatics.totalBuyAmount shouldBe lottoPrice * lottos.size
        lottoStatics.totalWinningPrice shouldBe LottoRank.FIFTH.winningMoney * 3 + LottoRank.SECOND.winningMoney
        lottoStatics.rateOfReturn shouldBe (LottoRank.FIFTH.winningMoney * 3 + LottoRank.SECOND.winningMoney) / (lottoPrice * lottos.size).toDouble()
    }

    "10개를 구입해서 5등에 3개, 3등에 2개, 2등에 1개 당첨된 경우, 올바른 lottoStatics를 생성한다" {
        val lottoPrice = 1000
        val winLotto = WinLotto.create(listOf(1, 2, 3, 4, 5, 6), 7)
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 7, 8, 9).map { number -> LottoNumber(number) }.toHashSet()), // 5등
            Lotto(listOf(1, 2, 3, 7, 8, 9).map { number -> LottoNumber(number) }.toHashSet()), // 5등
            Lotto(listOf(1, 2, 3, 7, 8, 9).map { number -> LottoNumber(number) }.toHashSet()), // 5등
            Lotto(listOf(1, 2, 3, 4, 5, 9).map { number -> LottoNumber(number) }.toHashSet()), // 3등
            Lotto(listOf(1, 2, 3, 4, 5, 9).map { number -> LottoNumber(number) }.toHashSet()), // 3등
            Lotto(listOf(1, 2, 3, 4, 5, 7).map { number -> LottoNumber(number) }.toHashSet()), // 2등
            Lotto(listOf(11, 22, 33, 7, 8, 9).map { number -> LottoNumber(number) }.toHashSet()), // 낙첨
            Lotto(listOf(11, 22, 33, 7, 8, 9).map { number -> LottoNumber(number) }.toHashSet()), // 낙첨
            Lotto(listOf(11, 22, 33, 7, 8, 9).map { number -> LottoNumber(number) }.toHashSet()), // 낙첨
            Lotto(listOf(11, 22, 33, 7, 8, 9).map { number -> LottoNumber(number) }.toHashSet()), // 낙첨
        )

        val lottoStatics = LottoAnalyzer(winLotto, lottoPrice).createLottoStatics(lottos)
        lottoStatics.ranks.size shouldBe 3
        lottoStatics.totalBuyAmount shouldBe lottoPrice * lottos.size
        lottoStatics.totalWinningPrice shouldBe LottoRank.FIFTH.winningMoney * 3 + LottoRank.THIRD.winningMoney * 2 + LottoRank.SECOND.winningMoney
        lottoStatics.rateOfReturn shouldBe (LottoRank.FIFTH.winningMoney * 3 + LottoRank.THIRD.winningMoney * 2 + LottoRank.SECOND.winningMoney) / (lottoPrice * lottos.size).toDouble()
    }

    "0개를 구입한 경우, 올바른 lottoStatics를 생성한다" {
        val lottoPrice = 1000
        val winLotto = WinLotto.create(listOf(1, 2, 3, 4, 5, 6), 7)
        val lottos = emptyList<Lotto>()

        val lottoStatics = LottoAnalyzer(winLotto, lottoPrice).createLottoStatics(lottos)
        lottoStatics.ranks.size shouldBe 0
        lottoStatics.totalBuyAmount shouldBe lottoPrice * lottos.size
        lottoStatics.totalWinningPrice shouldBe 0
        lottoStatics.rateOfReturn shouldBe 0
    }
})
