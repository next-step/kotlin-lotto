package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.row
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class LottoNumbersTest : FunSpec({
    context("로또번호의 일치 개수를 확인할 수 있다.") {
        withData(
            row(LottoNumbers(1, 2, 3, 4, 5, 6), LottoNumbers(1, 2, 3, 4, 5, 6), 6),
            row(LottoNumbers(1, 2, 3, 4, 5, 6), LottoNumbers(1, 2, 3, 4, 5, 7), 5),
            row(LottoNumbers(1, 2, 3, 4, 5, 6), LottoNumbers(1, 2, 3, 4, 7, 8), 4),
            row(LottoNumbers(1, 2, 3, 4, 5, 6), LottoNumbers(7, 8, 9, 10, 11, 12), 0),
        ) { (lottoNumbers1, lottoNumbers2, expectedCount) ->
            val matchCount = lottoNumbers1.countMatch(lottoNumbers2)
            matchCount shouldBe expectedCount
        }
    }
})
