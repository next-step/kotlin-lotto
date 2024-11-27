package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldBeSortedBy
import io.kotest.matchers.shouldBe

class LottoNumbersTest : StringSpec({
    "로또 하나에 6개의 랜덤번호가 들어있다" {
        LottoNumbers.create().numbers.size shouldBe 6
    }

    "로또번 호들은 중복되지 않는다" {
        val numbers = LottoNumbers.create().numbers
        numbers.distinct().size shouldBe 6
    }

    "로또 번호가 6개가 아니면 예외 발생한다" {
        val numbers = setOf(1, 2, 3, 4, 5, 6, 7)
        shouldThrow<IllegalArgumentException> { LottoNumbers.from(numbers) }
    }

    "로또 번호끼리의 일치 수를 반환한다" {
        table(
            headers("lottoNumbers", "otherNumbers", "expected"),
            row(setOf(1, 2, 3, 4, 5, 6), setOf(1, 2, 3, 4, 5, 6), 6),
            row(setOf(1, 2, 3, 4, 5, 6), setOf(1, 2, 3, 4, 5, 32), 5),
            row(setOf(10, 11, 12, 13, 14, 15), setOf(15, 14, 13, 12, 40, 41), 4),
            row(setOf(31, 32, 3, 4, 5, 6), setOf(31, 32, 40, 41, 42, 43), 2),
        ).forAll { lottoNumbers, others, expected ->
            val origin = LottoNumbers.from(lottoNumbers)
            val other = LottoNumbers.from(others)
            origin.countMatchedNumber(other) shouldBe expected
        }
    }

    "로또 번호 생성시 오름차순으로 정렬된다" {
        LottoNumbers.from(setOf(6, 5, 4, 3, 2, 1)).numbers shouldBeSortedBy { it.number }
    }

    "로또 번호에 포함되는 번호가 있다면 true 를 반환한다" {
        LottoNumbers.from(setOf(1, 2, 3, 4, 5, 6)).containsNumber(LottoNumber(1)) shouldBe true
    }

    "로또 번호에 포함되는 번호가 없다면 false 를 반환한다" {
        LottoNumbers.from(setOf(1, 2, 3, 4, 5, 6)).containsNumber(LottoNumber(45)) shouldBe false
    }
})
