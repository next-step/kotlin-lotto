package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class LottoNumbersTest : FunSpec({

    context("LottoNumbers 정상 생성") {
        withData(
            nameFn = { "LottoNumbers of $it" },
            listOf(1, 2, 3, 4, 5, 6),
            listOf(3, 2, 4, 5, 40, 41),
        ) { numbers ->

            val lottoNumbers = LottoNumbers.of(*numbers.toIntArray())
            lottoNumbers.lottoNumbers.map(LottoNumber::number).toSet() shouldBe numbers
        }
    }

    context("LottoNumbers size가 6이 아닐 경우 IllegalArgumentException throw") {
        withData(
            nameFn = { "LottoNumbers of $it" },
            listOf(1, 2, 3, 4, 5, 6, 7),
            listOf(3, 2, 4, 5, 40),
        ) { numbers ->

            shouldThrow<IllegalArgumentException> {
                LottoNumbers.of(*numbers.toIntArray())
            }
        }
    }

    context("LottoNumbers of에 중복된 숫자를 넘기면 IllegalArgumentException throw") {
        withData(
            nameFn = { "LottoNumbers of $it" },
            listOf(1, 2, 3, 4, 4, 6),
            listOf(3, 2, 4, 5, 40, 40),
        ) { numbers ->

            shouldThrow<IllegalArgumentException> {
                LottoNumbers.of(*numbers.toIntArray())
            }
        }
    }

    test("LottoNumbers는 다른 LottoNumbers랑 일치하는 개수를 구할수 있다.") {
        val lottoNumbers1 = LottoNumbers.of(1, 2, 3, 4, 5, 6)
        val lottoNumbers2 = LottoNumbers.of(5, 6, 40, 41, 42, 43)

        lottoNumbers1.countMatchingLottoNumbers(lottoNumbers2) shouldBe 2
    }

    test("LottoNumbers는 equals 비교가 가능하다.") {
        val numbers1 = setOf(1, 2, 3, 4, 5, 6)
        val numbers2 = setOf(2, 1, 3, 4, 5, 6)
        val numbers3 = setOf(1, 2, 3, 4, 5, 7)

        (LottoNumbers.of(numbers1) == LottoNumbers.of(numbers1)) shouldBe true
        (LottoNumbers.of(numbers1) == LottoNumbers.of(numbers2)) shouldBe true
        (LottoNumbers.of(numbers1) == LottoNumbers.of(numbers3)) shouldBe false
    }
})
