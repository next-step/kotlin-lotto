package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class WinResultKoTest : StringSpec({
    "맞춘 갯수에 따른 당첨 결과" {
        mapOf(
            6 to WinResult.FIRST,
            5 to WinResult.THIRD,
            4 to WinResult.FOURTH,
            3 to WinResult.FIFTH,
            2 to WinResult.LOSE,
            1 to WinResult.LOSE,
            0 to WinResult.LOSE,
        ).forAll { (matchCount, winResult) ->
            WinResult.valueOfMatchCount(matchCount) shouldBe winResult
        }
    }
})
