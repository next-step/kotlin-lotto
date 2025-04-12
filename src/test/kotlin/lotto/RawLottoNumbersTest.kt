package lotto

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class RawLottoNumbersTest : FunSpec({
    val rawNumbers =
        listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 6),
        )

    test("does not throw exception on create") {
        shouldNotThrowAny {
            RawLottoNumbers(rawNumbers)
        }
    }

    test("correctly returns size") {
        RawLottoNumbers(rawNumbers).size shouldBe 2
    }

    test("conversion to lottos") {
        shouldNotThrowAny {
            RawLottoNumbers(rawNumbers).toLottos()
        }
    }
})
