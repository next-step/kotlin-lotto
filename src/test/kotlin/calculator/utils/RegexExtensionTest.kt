package calculator.utils

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

internal class RegexExtensionTest : FunSpec({
    context("입력값에서 //와 \n 패턴이 있으면 반환값은 null이 아니다.") {
        withData(
            "//;\n1;2;3",
            "//!\n1:2;3",
            "//*\n1;2;3",
        ) { data ->
            data.findByPattern() shouldNotBe null
        }
    }

    context("입력값에서 //와 \n 패턴이 없으면 반환값이 null 이다") {
        withData(
            "1;2;3",
            "1;2:3",
            "@#\n1;2;3",
        ) { data ->
            data.findByPattern() shouldBe null
        }
    }
})
