package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.enums.LottoRank

class WinningLottoTest : FunSpec({

    test("match") {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6))
        val lottoList = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 10)),
            Lotto(listOf(1, 2, 3, 4, 10, 20)),
        )
        val matchResult = winningLotto.match(lottoList)

        matchResult.matchingMap shouldBe mapOf(
            LottoRank.FOURTH to 1,
            LottoRank.THIRD to 1,
            LottoRank.FIRST to 1
        )
    }
})
