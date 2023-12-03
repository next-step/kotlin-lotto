package lotto2.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldInclude

class LottoNumbersTest : StringSpec({

    "로또 번호 목록은 총 6개여야 한다." {
        forAll(
            row(listOf(1, 2, 3, 4, 5, 6)),
            row(listOf(1, 12, 23, 34, 37, 45)),
            row(listOf(1, 23, 27, 28, 33, 44)),
        ) { numbers: List<Int> ->
            val lottoNumbers = LottoNumbers(numbers.map { LottoNumber(it) })

            lottoNumbers.shouldNotBeNull()
        }
    }

    "로또 번호 목록이 6개가 아니라면 예외가 발생한다." {
        forAll(
            row(listOf(1, 2, 3, 4, 5)),
            row(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)),
            row(listOf(12, 23, 34, 37, 45)),
            row(listOf(28, 33, 44)),
        ) { numbers: List<Int> ->
            shouldThrow<IllegalArgumentException> {
                LottoNumbers(numbers.map { LottoNumber(it) })
            }.message shouldInclude "6개"
        }
    }

    "로또 번호 목록에 중복된 숫자가 있다면 예외가 발생한다." {
        forAll(
            row(listOf(1, 1, 1, 1, 1, 1)),
            row(listOf(30, 30, 1, 2, 3, 4)),
            row(listOf(1, 2, 3, 4, 45, 45)),
            row(listOf(1, 23, 44, 28, 33, 44)),
        ) { numbers: List<Int> ->
            shouldThrow<IllegalArgumentException> {
                LottoNumbers(numbers.map { LottoNumber(it) })
            }.message shouldInclude "중복"
        }
    }
})

class CountMatchingNumbersTest : StringSpec({

    "2개의 로또 번호들이 서로 겹치는 숫자가 없다면, 0을 반환한다. " {
        val lottoNumbers1 = LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val lottoNumbers2 = LottoNumbers(listOf(31, 32, 33, 34, 35, 36).map { LottoNumber(it) })

        lottoNumbers1.countMatchingNumbers(lottoNumbers2) shouldBe 0
    }

    "2개의 로또 번호들이 서로 총 3개의 숫자가 겹친다면, 3을 반환한다. " {
        val lottoNumbers1 = LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val lottoNumbers2 = LottoNumbers(listOf(1, 2, 3, 34, 35, 36).map { LottoNumber(it) })

        lottoNumbers1.countMatchingNumbers(lottoNumbers2) shouldBe 3
    }

    "2개의 로또 번호들이 서로 총 6개의 숫자가 겹친다면, 6을 반환한다. " {
        val lottoNumbers1 = LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val lottoNumbers2 = LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })

        lottoNumbers1.countMatchingNumbers(lottoNumbers2) shouldBe 6
    }
})

class ContainsTest : StringSpec({
    val lottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })

    "로또 번호에 포함된 숫자라면 참을 반환한다." {
        lottoNumbers.contains(6) shouldBe true
    }

    "로또 번호에 포함되지 않은 숫자라면 거짓을 반환한다." {
        lottoNumbers.contains(666) shouldBe false
    }
})
