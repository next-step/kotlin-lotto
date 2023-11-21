package lotto.domain.model

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.shouldBe
import lotto.domain.model.Rank.Companion.filterHasReward
import lotto.domain.model.Rank.Companion.sortedByReward

class RankTest : StringSpec({
    "로또 번호가 3개 이상 일치하면 상금이 있다." {
        val matchCount = 3
        val rank = Rank.valueOf(matchCount)
        rank.reward shouldBeGreaterThan 0
    }

    "로또 번호가 3개 미만으로 일치하면 상금이 없다." {
        val matchCount = 2
        val rank = Rank.valueOf(matchCount)
        rank.reward shouldBe 0
    }

    "로또 번호가 4개 일치하고 보너스 볼이 일치하면 4등이다." {
        val matchCount = 4
        val isMatchBonusNumber = true
        val rank = Rank.valueOf(matchCount, isMatchBonusNumber)
        rank shouldBe Rank.FOURTH
    }

    "로또 번호가 5개 일치하고 보너스 볼이 일치하지 않으면 3등이다." {
        val matchCount = 5
        val isMatchBonusNumber = false
        val rank = Rank.valueOf(matchCount, isMatchBonusNumber)
        rank shouldBe Rank.THIRD
    }

    "로또 번호가 5개 일치하고 보너스 볼이 일치하면 2등이다." {
        val matchCount = 5
        val isMatchBonusNumber = true
        val rank = Rank.valueOf(matchCount, isMatchBonusNumber)
        rank shouldBe Rank.SECOND
    }

    "로또 번호가 6개 일치하면 1등이다." {
        val matchCount = 6
        val rank = Rank.valueOf(matchCount)
        rank shouldBe Rank.FIRST
    }

    "로또 번호가 7개 일치하면 IllegalArgumentException 예외가 발생한다." {
        val matchCount = 7
        shouldThrowWithMessage<IllegalArgumentException>("로또 숫자의 일치 수는 로또 숫자 수의 범위를 벗어날 수 없습니다. matchCount=$matchCount") {
            Rank.valueOf(matchCount)
        }
    }

    "로또 등수 중 상금이 있는 등수를 필터링 할 수 있다." {
        val ranks = arrayOf(Rank.FIRST, Rank.SECOND, Rank.MISS)
        ranks.filterHasReward() shouldBe arrayOf(Rank.FIRST, Rank.SECOND)
    }

    "로또 등수 중 상금에 대한 오름차순 정렬할 수 있다." {
        val ranks = listOf(Rank.SECOND, Rank.FIRST, Rank.FOURTH, Rank.THIRD)
        ranks.sortedByReward() shouldBe listOf(Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST)
    }
})
