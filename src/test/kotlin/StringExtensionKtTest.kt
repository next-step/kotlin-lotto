import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class StringExtensionKtTest : StringSpec({

    "문자열이 정수인지 반환" {
        forAll(
            row("1", true),
            row("0", true),
            row("-1", true),
            row("a", false),
            row("-a", false),
        ) { string, expected ->
            string.isInt() shouldBe expected
        }
    }
})
