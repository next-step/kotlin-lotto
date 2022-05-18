package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

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
            4 to 1,
            5 to 1,
            6 to 1
        )
    }
})
