package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.fixture.fixture
import lotto.fixture.lottoNumbersFixture

class LottosTest : StringSpec({
    "당첨 번호를 입력받아 당첨 결과를 반환한다" {
        val lottos =
            Lottos(
                listOf(
                    Lotto.fixture(1, 2, 3, 4, 5, 6),
                    Lotto.fixture(1, 2, 3, 4, 5, 7),
                    Lotto.fixture(1, 2, 3, 4, 8, 9),
                    Lotto.fixture(1, 2, 3, 7, 8, 9),
                    Lotto.fixture(1, 2, 7, 8, 9, 10),
                    Lotto.fixture(1, 7, 8, 9, 10, 11),
                ),
            )
        val winningNumbers = lottoNumbersFixture(1, 2, 3, 4, 5, 6)

        val actual = lottos.match(winningNumbers)

        actual.first shouldBe 1
        actual.second shouldBe 1
        actual.third shouldBe 1
        actual.fourth shouldBe 1
        actual.miss shouldBe 2
        actual.prize shouldBe Money(2_015_055_000)
    }
})
