package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class BoughtLottoTest : StringSpec({
    "구입한 로또에 대한 결과를 계산한다." {
        val lottos = listOf(
            Lotto.manual(listOf(1, 2, 3, 4, 5, 6)),
            Lotto.manual(listOf(1, 2, 3, 4, 5, 7)),
            Lotto.manual(listOf(1, 2, 3, 4, 5, 8)),
            Lotto.manual(listOf(1, 2, 3, 4, 10, 11)),
            Lotto.manual(listOf(1, 8, 9, 10, 11, 12)),
            Lotto.manual(listOf(1, 8, 9, 10, 11, 13)),
        )
        val winningLotto = WinningLotto(Lotto.manual(listOf(1, 2, 3, 4, 5, 6)), BonusNumber(LottoNumber(7)))
        val sut = BoughtLotto(lottos, winningLotto)

        val actual = sut.matchResult()

        actual shouldBe LottoResult(
            mapOf(
                Reward.FIRST to 1,
                Reward.SECOND to 1,
                Reward.THIRD to 1,
                Reward.FOURTH to 1,
                Reward.FIFTH to 0,
                Reward.NONE to 2,
            )
        )
    }
})
