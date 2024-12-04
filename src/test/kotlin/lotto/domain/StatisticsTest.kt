package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lotto.fixture.fakeBonusNumber
import lotto.fixture.fakeFirstRankLotto
import lotto.fixture.fakeSecondRankLotto
import lotto.fixture.fakeWinningLotto
import lotto.fixture.noRankLotto

class StatisticsTest : DescribeSpec({
    describe("로또의 수익률을 계산한다") {
        lateinit var winningLotto: WinningLotto
        beforeTest { winningLotto = WinningLotto(fakeWinningLotto(), fakeBonusNumber()) }

        context("사용자의 로또가 모두 당첨로또인 경우") {
            it("상금을 더한다") {
                val lottos =
                    listOf(
                        fakeFirstRankLotto(),
                        fakeSecondRankLotto(),
                    )
                val price = lottos.size * 1000

                val sut = Statistics(winningLotto, lottos)
                val actual = sut.calculateEarningRatio(price)
                actual shouldBe 1015000.0
            }
        }

        context("사용자의 로또가 일부만 당첨로또인 경우") {
            it("상금을 더한다") {
                val lottos =
                    listOf(
                        fakeFirstRankLotto(),
                        fakeSecondRankLotto(),
                        noRankLotto(),
                    )
                val price = lottos.size * 1000

                val sut = Statistics(winningLotto, lottos)
                val actual = sut.calculateEarningRatio(price)
                actual shouldBe 676666.66
            }
        }
    }
})
