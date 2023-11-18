package lotto.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoNumbersTest : FunSpec({
    test("로또 번호와 당점 번호 비교 후 일치하는 번호를 정상 반환하는지 테스트") {
        val winningLottoNumbers = LottoNumbers.create(
            listOf(1, 2, 3, 4, 5, 6)
        )

        forAll(
            row(listOf(1, 1, 1, 1, 1, 1), 1),
            row(listOf(1, 2, 1, 1, 1, 1), 2),
            row(listOf(1, 2, 3, 1, 1, 1), 3),
            row(listOf(1, 2, 3, 4, 1, 1), 4),
            row(listOf(1, 2, 3, 4, 5, 1), 5),
            row(listOf(1, 2, 3, 4, 5, 6), 6),
        ) { numbers, answer ->
            val lottoNumbers = LottoNumbers.create(numbers)

            val result = lottoNumbers.match(winningLottoNumbers)

            result shouldBe answer
        }
    }

    test("로또 번호 생성 시 숫자 개수가 6개가 아닌 경우 IllegalArgumentException 예외 발생 테스트") {
        forAll(
            row(listOf(1, 2, 3, 4, 5)),
            row(listOf(1, 2, 3, 4, 5, 6, 7))
        ) { numbers ->
            shouldThrow<IllegalArgumentException> { LottoNumbers.create(numbers) }
        }
    }
})
