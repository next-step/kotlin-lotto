package nextstep.mission.lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottosTest : StringSpec({

    "로또를 입력받은 금액만큼의 갯수를 관리한다." {
        Lottos(10000).lottos.size shouldBe 10
    }

    "당첨번호를 입력받아 통계를 반환한다." {
        val lottos = Lottos(
            listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                Lotto(listOf(11, 12, 13, 14, 15, 16)),
                Lotto(listOf(40, 41, 42, 43, 44, 45)),
            )
        )
        lottos.checkWinningNumbers(listOf(1, 2, 3, 4, 5, 6)) shouldBe WinningResult(0, 0, 0, 1)
    }
})
