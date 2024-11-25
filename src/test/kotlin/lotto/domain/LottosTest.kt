package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.fixture.lottoFixture
import lotto.fixture.lottosFixture

class LottosTest : StringSpec({
    "당첨 번호를 입력받아 당첨 결과를 반환한다" {
        val lottos =
            lottosFixture(
                lottoFixture(1, 2, 3, 4, 5, 6),
                lottoFixture(1, 2, 3, 4, 5, 7),
                lottoFixture(1, 2, 3, 4, 8, 9),
                lottoFixture(1, 2, 3, 7, 8, 9),
                lottoFixture(1, 2, 7, 8, 9, 10),
                lottoFixture(1, 7, 8, 9, 10, 11),
            )
        val winningLotto = lottoFixture(1, 2, 3, 4, 5, 6)

        val actual = lottos.match(winningLotto)

        actual.countByResult(Result.FIRST) shouldBe 1
        actual.countByResult(Result.SECOND) shouldBe 1
        actual.countByResult(Result.THIRD) shouldBe 1
        actual.countByResult(Result.FOURTH) shouldBe 1
        actual.countByResult(Result.MISS) shouldBe 2
        actual.prize shouldBe Money(2_015_055_000)
    }
})
