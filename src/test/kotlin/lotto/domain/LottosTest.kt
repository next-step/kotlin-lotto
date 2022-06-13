package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottosTest : StringSpec({
    "당첨 로또와 비교하여 통계 결과를 얻는다" {
        // given
        val lottos = Lottos(
            listOf(
                Lotto(1, 2, 3, 4, 5, 6),
                Lotto(1, 2, 3, 4, 5, 10),
                Lotto(1, 2, 3, 4, 9, 10),
                Lotto(1, 2, 3, 8, 9, 10),
                Lotto(1, 2, 7, 8, 9, 10),
            )
        )
        val winningLotto = WinningLotto(
            Lotto(1, 2, 3, 4, 5, 6)
        )

        // when
        val actual = lottos.getStatistics(winningLotto)

        // then
        actual.statistics[Rank.FIRST] shouldBe 1
        actual.statistics[Rank.SECOND] shouldBe 1
        actual.statistics[Rank.THIRD] shouldBe 1
        actual.statistics[Rank.FOURTH] shouldBe 1
    }

    "자동 로또를 발급한다" {
        // given
        val lottoNumber = 3
        val expectedLotto = Lotto(1, 2, 3, 4, 5, 6)

        // when
        val actual = Lottos.generateAutoLottos(lottoNumber) { expectedLotto }

        // then
        actual.lottos.size shouldBe lottoNumber
        actual.lottos[0].lottoNumbers shouldBe expectedLotto.lottoNumbers
        actual.lottos[1].lottoNumbers shouldBe expectedLotto.lottoNumbers
        actual.lottos[2].lottoNumbers shouldBe expectedLotto.lottoNumbers
    }
})
