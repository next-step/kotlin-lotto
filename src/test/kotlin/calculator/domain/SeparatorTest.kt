package calculator.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder

internal class SeparatorTest : FreeSpec({

    "주어진 문자열로 조합된 구분자목록 문자열을 반환한다." - {
        listOf(
            "a",
            "|",
            "1",
        ).forEach { separatorValue ->
            "'$separatorValue'로 조합된 구분자목록 문자열 반환" {
                val regex = Separator.toRegexWith(separatorValue = separatorValue)
                regex.toString()
                    .split(separatorValue)
                    .map { Separator.valueOf(it) }
                    .shouldContainExactlyInAnyOrder(expected = Separator.values())
            }
        }
    }
})
