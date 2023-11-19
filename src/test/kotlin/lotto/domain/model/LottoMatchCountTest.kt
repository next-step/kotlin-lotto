package lotto.domain.model

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.shouldBe

class LottoMatchCountTest : StringSpec({
    "로또 번호가 3개 이상 일치하면 상금이 있다." {
        val matchCount = 3
        val lottoMatchCount = LottoMatchCount.from(matchCount)
        lottoMatchCount.reward shouldBeGreaterThan 0
    }

    "로또 번호가 3개 미만으로 일치하면 상금이 없다." {
        val matchCount = 2
        val lottoMatchCount = LottoMatchCount.from(matchCount)
        lottoMatchCount.reward shouldBe 0
    }

    "로또 번호가 6개 일치하면 상금은 2000000000원 이다." {
        val matchCount = 6
        val lottoMatchCount = LottoMatchCount.from(matchCount)
        lottoMatchCount.reward shouldBe 2000000000
    }

    "로또 번호가 7개 일치하면 IllegalArgumentException 예외가 발생한다." {
        val matchCount = 7
        shouldThrowWithMessage<IllegalArgumentException>("로또 숫자의 일치 수는 로또 숫자 수의 범위를 벗어날 수 없습니다. matchCount=$matchCount") {
            LottoMatchCount.from(matchCount)
        }
    }
})
