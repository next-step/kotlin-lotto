package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.fixture.LottoFixture

class LottosTest : StringSpec({
    "당첨 로또와 비교하여 통계 결과를 얻는다" {
        // given
        val lottos = Lottos(
            listOf(
                LottoFixture.createLotto(listOf(1, 2, 3, 4, 5, 6)),
                LottoFixture.createLotto(listOf(1, 2, 3, 4, 5, 10)),
                LottoFixture.createLotto(listOf(1, 2, 3, 4, 9, 10)),
                LottoFixture.createLotto(listOf(1, 2, 3, 8, 9, 10)),
                LottoFixture.createLotto(listOf(1, 2, 7, 8, 9, 10)),
            )
        )
        val winningLotto = WinningLotto(
            LottoFixture.createLotto(listOf(1, 2, 3, 4, 5, 6))
        )

        // when
        val actual = lottos.getStatistics(winningLotto)

        // then
        actual.statistics[Rank.FIRST] shouldBe 1
        actual.statistics[Rank.SECOND] shouldBe 1
        actual.statistics[Rank.THIRD] shouldBe 1
        actual.statistics[Rank.FOURTH] shouldBe 1
    }
})
