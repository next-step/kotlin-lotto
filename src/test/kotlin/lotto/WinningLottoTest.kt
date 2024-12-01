package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumber
import lotto.domain.Order
import lotto.domain.Rank
import lotto.domain.WinningLotto

class WinningLottoTest : StringSpec({
    "각 등수에 대해 각각 몇개씩 일치하는지 정보를 제공한다." {
        val lotto = createLotto(1, 2, 3, 7, 8, 9)
        val order = Order(1000, listOf(lotto))
        val winningLotto = WinningLotto(createLotto(1, 2, 3, 4, 5, 6), LottoNumber.getNumber(7))

        val result = winningLotto.extractWinningResult(order)
        val expected =
            listOf(
                Rank.FIFTH to 1,
                Rank.FOURTH to 0,
                Rank.THIRD to 0,
                Rank.SECOND to 0,
                Rank.FIRST to 0,
            )

        // println(result.winningMatchCounts)
        expected.forEachIndexed { index, pair ->
            pair.first shouldBe result.winningMatchCounts[index].rank
            pair.second shouldBe result.winningMatchCounts[index].totalMatchCount
        }
    }

    "수익을 제공한다." {
        val order = Order(1000, listOf(createLotto(1, 2, 3, 4, 5, 6)))
        val winningLotto = WinningLotto(createLotto(1, 2, 3, 4, 5, 6), LottoNumber.getNumber(7))

        val result = winningLotto.extractWinningResult(order)

        result.revenue shouldBe 2_000_000_000
    }

    "수익률을 제공한다." {
        val order = Order(1000, listOf(createLotto(1, 2, 3, 4, 5, 6)))
        val winningLotto = WinningLotto(createLotto(1, 2, 3, 4, 5, 6), LottoNumber.getNumber(7))

        val result = winningLotto.extractWinningResult(order)

        result.rate shouldBe 2000000.0
    }
})
