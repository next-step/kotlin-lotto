package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith

class LottoNumbersTest : FunSpec({
    context("객체 생성") {
        test("6개의 로또 번호를 가진 객체를 생성한다.") {
            shouldNotThrowAny {
                LottoNumbers(listOf(1, 2, 3, 4, 5, 6))
            }
        }

        test("중복 번호가 존재할 경우 예외가 발생한다.") {
            val actual = shouldThrow<IllegalArgumentException> {
                LottoNumbers(listOf(1, 2, 3, 4, 5, 5))
            }

            actual.message should startWith("there is duplicate number")
        }
    }
    context("countMatchedNumbers()") {
        test("일치하는 번호 개수를 반환한다.") {
            val lottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6))

            table(
                headers("lottoNumbers", "winningNumbers", "matchedCount"),
                row(lottoNumbers, LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), 6),
                row(lottoNumbers, LottoNumbers(listOf(1, 2, 3, 4, 5, 7)), 5),
                row(lottoNumbers, LottoNumbers(listOf(1, 2, 3, 4, 8, 7)), 4),
                row(lottoNumbers, LottoNumbers(listOf(1, 2, 3, 9, 8, 7)), 3),
                row(lottoNumbers, LottoNumbers(listOf(1, 2, 10, 9, 8, 7)), 2),
                row(lottoNumbers, LottoNumbers(listOf(1, 11, 10, 9, 8, 7)), 1),
                row(lottoNumbers, LottoNumbers(listOf(12, 11, 10, 9, 8, 7)), 0)
            ).forAll { lottoNumbers, winningNumbers, matchedCount ->
                lottoNumbers.countMatchedNumbers(winningNumbers) shouldBe matchedCount
            }
        }
    }
    context("numbers()") {
        test("로또 번호들을 반환한다.") {
            val lottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6))

            lottoNumbers.numbers() shouldContainExactly listOf(1, 2, 3, 4, 5, 6)
        }
    }
})
