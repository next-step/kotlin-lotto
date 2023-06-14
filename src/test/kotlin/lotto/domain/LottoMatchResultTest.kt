package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import lotto.model.LottoErrorCode

class LottoMatchResultTest : StringSpec({

    "지정된 범위의 당첨 개수를 입력하면 정상적으로 생성된다." {
        forAll(
            row(0),
            row(2),
            row(3),
            row(6),
        ) { countOfMatch ->
            val lottoMatchResult = LottoMatchResult(countOfMatch = countOfMatch)

            lottoMatchResult.toString() shouldBe countOfMatch.toString()
        }
    }

    "허용되지 않은 범위의 당첨 개수를 입력하면 지정된 범위가 아니라는 에러가 발생한다." {
        forAll(
            row(-1),
            row(100),
            row(7),
        ) { countOfMatch ->
            val exception = shouldThrow<IllegalStateException> {
                LottoMatchResult(countOfMatch = countOfMatch)
            }

            exception shouldHaveMessage LottoErrorCode.NOT_INCLUDE_RANGE_COUNT_OF_MATCH.message("0..6 $countOfMatch")
        }
    }
})
