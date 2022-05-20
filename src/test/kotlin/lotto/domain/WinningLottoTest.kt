package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.enums.LottoRank

class WinningLottoTest : FunSpec({

    val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 45)

    test("로또 숫자 6개가 일치할 때, 1등으로 매칭된다.") {
        val lotto = lotto(1, 2, 3, 4, 5, 6)
        winningLotto.match(lotto).matchingMap shouldBe mapOf(LottoRank.FIRST to 1)
    }

    test("로또 숫자 5개가 일치하고, 보너스 번호가 일치할 때, 2등으로 매칭된다.") {
        val lotto = lotto(1, 2, 3, 4, 5, 45)
        winningLotto.match(lotto).matchingMap shouldBe mapOf(LottoRank.SECOND to 1)
    }

    test("로또 숫자 5개가 일치할 때, 3등으로 매칭된다.") {
        val lotto = lotto(1, 2, 3, 4, 5, 16)
        winningLotto.match(lotto).matchingMap shouldBe mapOf(LottoRank.THIRD to 1)
    }

    test("로또 숫자 4개가 일치할 때, 4등으로 매칭된다.") {
        val lotto = lotto(1, 2, 3, 4, 15, 16)
        winningLotto.match(lotto).matchingMap shouldBe mapOf(LottoRank.FOURTH to 1)
    }

    test("로또 숫자 3개가 일치할 때, 5등으로 매칭된다.") {
        val lotto = lotto(1, 2, 3, 14, 15, 16)
        winningLotto.match(lotto).matchingMap shouldBe mapOf(LottoRank.FIFTH to 1)
    }
})
