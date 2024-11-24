package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class BoughtLottoTest : StringSpec({
    "구입한 로또에 대한 결과를 계산한다." {
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
            Lotto(listOf(1, 2, 3, 4, 8, 9)),
            Lotto(listOf(1, 2, 3, 8, 9, 10)),
            Lotto(listOf(1, 2, 8, 9, 10, 11)),
            Lotto(listOf(1, 8, 9, 10, 11, 12)),
        )
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        val sut = BoughtLotto(lottos, winningLotto)

        val actual = sut.matchResult()

        actual shouldBe mapOf(
            Reward.FIRST to 1,
            Reward.SECOND to 1,
            Reward.THIRD to 1,
            Reward.FOURTH to 1,
            Reward.NONE to 2,
        )
    }
})
