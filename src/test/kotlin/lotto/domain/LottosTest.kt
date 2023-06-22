package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class LottosTest : FunSpec({
    test("구입금액에 해당하는 개수만큼 로또를 자동으로 생성한다") {
        val lottos = Lottos.auto(quantity = 2)

        lottos.size shouldBe 2
    }

    test("로또를 수동으로 생성한다") {
        val lottos = Lottos.manual(
            listOf(
                listOf(1, 2, 3, 4, 5, 6),
                listOf(11, 12, 13, 14, 15, 16),
            )
        )

        lottos shouldBe Lottos(
            listOf(
                Lotto(1, 2, 3, 4, 5, 6),
                Lotto(11, 12, 13, 14, 15, 16),
            )
        )
    }

    test("당첨 상금을 구한다.") {
        val winningLotto = Lotto(1, 2, 3, 7, 8, 10)
        val secondPrizeLotto = Lotto(1, 2, 3, 7, 8, 9)
        val thirdPrizeLotto = Lotto(1, 2, 3, 7, 8, 11)
        val fourthPrizeLotto = Lotto(1, 2, 3, 7, 5, 6)
        val missPrizeLotto = Lotto(1, 2, 4, 5, 6, 9)
        val lottos = Lottos(
            listOf(
                winningLotto,
                secondPrizeLotto,
                thirdPrizeLotto,
                fourthPrizeLotto,
                fourthPrizeLotto,
                fourthPrizeLotto,
                missPrizeLotto
            )
        )

        val winningPrizes = lottos.getWinningPrizes(WinningLotto(winningLotto, LottoNumber(9)))

        winningPrizes[0] shouldBe Prize.FIRST
        winningPrizes[1] shouldBe Prize.SECOND
        winningPrizes[2] shouldBe Prize.THIRD
        winningPrizes[3] shouldBe Prize.FOURTH
        winningPrizes[4] shouldBe Prize.FOURTH
        winningPrizes[5] shouldBe Prize.FOURTH
        winningPrizes shouldHaveSize 6
    }

    test("상금별 당첨 로또 개수를 구한다.") {
        val winningLotto = Lotto(1, 2, 3, 7, 8, 10)
        val secondPrizeLotto = Lotto(1, 2, 3, 7, 8, 9)
        val thirdPrizeLotto = Lotto(1, 2, 3, 7, 8, 11)
        val fourthPrizeLotto = Lotto(1, 2, 3, 7, 5, 6)
        val missPrizeLotto = Lotto(1, 2, 4, 5, 6, 9)
        val lottos = Lottos(
            listOf(
                winningLotto,
                secondPrizeLotto,
                thirdPrizeLotto,
                fourthPrizeLotto,
                fourthPrizeLotto,
                fourthPrizeLotto,
                missPrizeLotto
            )
        )

        val winningLottoCountsByPrize =
            lottos.getWinningCountsByPrize(WinningLotto(winningLotto, LottoNumber(9)))

        winningLottoCountsByPrize[Prize.FIRST] shouldBe 1
        winningLottoCountsByPrize[Prize.SECOND] shouldBe 1
        winningLottoCountsByPrize[Prize.THIRD] shouldBe 1
        winningLottoCountsByPrize[Prize.FOURTH] shouldBe 3
        winningLottoCountsByPrize[Prize.FIFTH] shouldBe 0
        winningLottoCountsByPrize.contains(Prize.MISS) shouldBe false
    }

    test("로또들을 더한 결과를 반환한다") {
        val lotto1 = Lotto(1, 2, 3, 7, 8, 10)
        val lotto2 = Lotto(1, 2, 3, 7, 8, 9)
        val lotto3 = Lotto(1, 2, 3, 7, 8, 11)
        val lottos = Lottos(listOf(lotto1))
        val otherLottos = Lottos(listOf(lotto2, lotto3))

        val addedLottos = lottos + otherLottos

        addedLottos shouldBe Lottos(listOf(lotto1, lotto2, lotto3))
    }
})
