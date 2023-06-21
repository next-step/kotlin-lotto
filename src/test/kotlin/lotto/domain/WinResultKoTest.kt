package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class WinResultKoTest : StringSpec({
    "맞춘 갯수에 따른 당첨 결과" {
        mapOf(
            Pair(6, false) to WinResult.FIRST,
            Pair(5, true) to WinResult.SECOND,
            Pair(5, false) to WinResult.THIRD,
            Pair(4, false) to WinResult.FOURTH,
            Pair(3, false) to WinResult.FIFTH,
            Pair(2, false) to WinResult.LOSE,
            Pair(1, false) to WinResult.LOSE,
            Pair(0, false) to WinResult.LOSE,
            Pair(0, true) to WinResult.LOSE,
        ).forAll { (pair, winResult) ->
            WinResult.valueOf(pair.first, pair.second) shouldBe winResult
        }
    }
})
