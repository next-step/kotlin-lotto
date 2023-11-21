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
            row(listOf(1, 12, 13, 14, 15, 16), 1),
            row(listOf(1, 2, 13, 14, 15, 16), 2),
            row(listOf(1, 2, 3, 14, 15, 16), 3),
            row(listOf(1, 2, 3, 4, 15, 16), 4),
            row(listOf(1, 2, 3, 4, 5, 16), 5),
            row(listOf(1, 2, 3, 4, 5, 6), 6),
        ) { numbers, answer ->
            val lottoNumbers = LottoNumbers.create(numbers)

            val result = lottoNumbers.match(winningLottoNumbers)

            result shouldBe answer
        }
    }

    test("로또 번호 생성 시 숫자 개수가 6개가 아니거나 중복된 숫자가 존재하는 경우 IllegalArgumentException 예외 발생 테스트") {
        forAll(
            row(listOf(1, 2, 3, 4, 5)),
            row(listOf(1, 2, 3, 4, 5, 5)),
            row(listOf(1, 2, 3, 4, 5, 6, 7))
        ) { numbers ->
            shouldThrow<IllegalArgumentException> { LottoNumbers.create(numbers) }
        }
    }
})
