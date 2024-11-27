package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.fixture.lottoFixture
import lotto.fixture.lottosFixture
import lotto.fixture.winningLottoFixture

class LottosTest : StringSpec({
    "당첨 로또를 입력받아 1등부터 꽝까지 당첨 결과를 반환한다" {
        val lottos =
            lottosFixture(
                lottoFixture(1, 2, 3, 4, 5, 6),
                lottoFixture(1, 2, 3, 4, 5, 45),
                lottoFixture(1, 2, 3, 4, 5, 7),
                lottoFixture(1, 2, 3, 4, 8, 9),
                lottoFixture(1, 2, 3, 8, 9, 10),
                lottoFixture(1, 2, 8, 9, 10, 11),
            )
        val winningLotto =
            winningLottoFixture(
                numbers = intArrayOf(1, 2, 3, 4, 5, 6),
                bonusNumber = 45,
            )

        val actual = lottos.match(winningLotto)

        actual.countByResult(Result.FIRST) shouldBe 1
        actual.countByResult(Result.SECOND) shouldBe 1
        actual.countByResult(Result.THIRD) shouldBe 1
        actual.countByResult(Result.FOURTH) shouldBe 1
        actual.countByResult(Result.FIFTH) shouldBe 1
        actual.countByResult(Result.MISS) shouldBe 1
        actual.prize shouldBe Money(2_031_555_000)
    }
})
