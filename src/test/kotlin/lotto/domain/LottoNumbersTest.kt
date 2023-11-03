package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoNumbersTest : FunSpec({

    test("로또 번호를 당첨 번호 리스트를 비교한다.") {
        val lottoNumbers = LottoNumbers(
            listOf(1, 2, 3, 4, 5, 6)
                .map { LottoNumber(it) }
        )
        val otherNumbers = LottoNumbers(
            listOf(1, 2, 3, 4, 5, 7)
                .map { LottoNumber(it) }
        )
        lottoNumbers.matchNumbersCount(otherNumbers) shouldBe 5
    }

    test("로또 번호와 당첨 번호 1개 비교한다.") {
        val lottoNumbers = LottoNumbers(
            listOf(1, 2, 3, 4, 5, 6)
                .map { LottoNumber(it) }
        )
        val otherNumber = LottoNumber(1)

        lottoNumbers.matchNumbers(otherNumber) shouldBe true
    }

    test("로또의 숫자는 중복되지 않는다.") {

        val exception = shouldThrow<IllegalArgumentException> {
            LottoNumbers(listOf(1, 2, 3, 4, 5, 5).map { LottoNumber(it) })
        }
        exception.message shouldBe "로또는 중복되지 않는 숫자만 가질 수 있습니다."
    }
})
