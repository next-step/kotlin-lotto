package calculator

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

internal class DelimiterExtractorTest : FunSpec({
    context("입력값에서 //와 \n 사이에 위치하는 구분자를 추출할 수 있다.") {
        withData(
            "//;\n1;2;3" to listOf(";"),
            "//#\n1;2;3" to listOf("#"),
            "//*\n1;2;3" to listOf("*"),
        ) { (data, result) ->
            DelimiterExtractor.run(data) shouldBe result
        }
    }

    context("입력값에서 //와 \n 사이에 위치하는 구분자가 없다면 구분자는 , : 이다.") {
        withData(
            "1;2;3" to listOf(",", ":"),
            "1:2;3" to listOf(",", ":"),
            "1:2:3" to listOf(",", ":"),
        ) { (data, result) ->
            DelimiterExtractor.run(data) shouldBe listOf(",", ":")
        }
    }
})
