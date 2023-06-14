package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import lotto.domain.MatchState.MATCH
import lotto.domain.MatchState.NON_MATCH
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

    "로또 일치 결과끼리 비교할 수 있다." {
        forAll(
            row(LottoMatchResult(countOfMatch = 1), LottoMatchResult(countOfMatch = 2, NON_MATCH), false),
            row(LottoMatchResult(countOfMatch = 2), LottoMatchResult(countOfMatch = 2), true),
            row(LottoMatchResult(countOfMatch = 3), LottoMatchResult(countOfMatch = 3, NON_MATCH), true),
            row(LottoMatchResult(countOfMatch = 6), LottoMatchResult(countOfMatch = 6, MATCH), true),
            row(LottoMatchResult(countOfMatch = 6, NON_MATCH), LottoMatchResult(countOfMatch = 6, MATCH), false),
        ) { result, other, expect ->
            result.correctMatchResult(otherMatchResult = other) shouldBe expect
        }
    }

    "로또 매치 결과의 보너스볼 조건을 알 수 있다." {
        forAll(
            row(LottoMatchResult(countOfMatch = 1), false),
            row(LottoMatchResult(countOfMatch = 2, NON_MATCH), false),
            row(LottoMatchResult(countOfMatch = 2, MATCH), true),
        ) { matchResult, expect ->
            matchResult.hasBonusBallCondition() shouldBe expect
        }
    }
})
