package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.row
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class LottoNumbersTest : FunSpec({
    context("로또번호의 일치 개수를 확인할 수 있다.") {
        withData(
            row(createSimpleLottoNumbers(), createSimpleLottoNumbers(), 6),
            row(createSimpleLottoNumbers(), createSimpleLottoNumbers(1, 2, 3, 4, 5, 7), 5),
            row(createSimpleLottoNumbers(), createSimpleLottoNumbers(1, 2, 3, 4, 7, 8), 4),
            row(createSimpleLottoNumbers(), createSimpleLottoNumbers(7, 8, 9, 10, 11, 12), 0),
        ) { (lottoNumbers1, lottoNumbers2, expectedCount) ->
            val matchCount = lottoNumbers1.countMatch(lottoNumbers2)
            matchCount shouldBe expectedCount
        }
    }

    context("로또 번호가 6개가 아니면 오류가 발생합니다.") {
        withData(
            setOf(1, 2, 3, 4, 5) to "로또 번호는 6개여야 합니다.",
            setOf(1, 2, 3, 4, 5, 6, 7) to "로또 번호는 6개여야 합니다.",
        ) { (input, expected) ->
            shouldThrow<IllegalArgumentException> {
                createSimpleLottoNumbers(input)
            }.message shouldBe expected
        }
    }
})
