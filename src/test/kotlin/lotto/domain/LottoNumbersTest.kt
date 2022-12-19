package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

/**
 * @see LottoNumbers
 */
class LottoNumbersTest : FunSpec({

    val selectedNumberString = "1, 2, 3, 4, 5, 6"
    val lottoNumbers = LottoNumbers.from(selectedNumberString)

    test("matches") {
        lottoNumbers.matches(lottoNumbers) shouldBe 6
    }

    test("toString") {
        lottoNumbers.toString() shouldBe selectedNumberString
    }
})
