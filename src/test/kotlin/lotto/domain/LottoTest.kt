package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe
import lotto.exception.DuplicateLottoNumberException
import lotto.exception.InvalidLottoNumberException
import lotto.exception.InvalidLottoNumberSizeException
import lotto.util.RandomLottoNumberGenerator

class LottoTest : FunSpec({
    test("Lotto 숫자는 6개로 구성된다.") {
        shouldThrow<InvalidLottoNumberSizeException> {
            Lotto(listOf())
        }
        shouldThrow<InvalidLottoNumberSizeException> {
            Lotto(listOf(1))
        }
        shouldThrow<InvalidLottoNumberSizeException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    test("로또 숫자는 중복이 없어야 한다.") {
        shouldThrow<DuplicateLottoNumberException> {
            Lotto(listOf(1, 1, 1, 4, 5, 6))
        }
    }

    test("로또 번호는 1 부터 45까지 허용된다.") {
        shouldThrow<InvalidLottoNumberException> {
            Lotto(listOf(0, 2, 3, 4, 5, 6))
        }
        shouldThrow<InvalidLottoNumberException> {
            Lotto(listOf(1, 2, 3, 4, 5, 100))
        }
    }

    test("로또 숫자는 정렬해서 조회한다.") {
        val lotto = Lotto(listOf(2, 1, 6, 5, 4, 3))
        lotto.numbers.toString() shouldBe "[1, 2, 3, 4, 5, 6]"
    }

    test("로또 숫자끼리 비교가 가능하다.") {
        val lotto = Lotto(listOf(2, 1, 6, 5, 4, 3))
        val winningLotto = WinningLotto(listOf(3, 4, 5, 6, 7, 8))
        winningLotto.matchingNumbers(lotto) shouldBe listOf(3, 4, 5, 6)
    }

    test("로또 자동 발급시 번호는 랜덤하게 생성된다.") {
        val numberMap = List(100) {}
            .map { Lotto(RandomLottoNumberGenerator.generate()) }
            .map { it.numbers }
            .flatMap { it.numbers }
            .sorted()
            .groupingBy { it }.eachCount()

        numberMap.keys.size shouldBeInRange 6..45
    }
})
