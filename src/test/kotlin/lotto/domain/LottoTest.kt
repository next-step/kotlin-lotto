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
            Lotto(1)
        }
        shouldThrow<InvalidLottoNumberSizeException> {
            Lotto(1, 2, 3, 4, 5, 6, 7)
        }
    }

    test("로또 숫자는 중복이 없어야 한다.") {
        shouldThrow<DuplicateLottoNumberException> {
            Lotto(1, 1, 1, 4, 5, 6)
        }
    }

    test("로또 번호는 1 부터 45까지 허용된다.") {
        shouldThrow<InvalidLottoNumberException> {
            Lotto(0, 2, 3, 4, 5, 6)
        }
        shouldThrow<InvalidLottoNumberException> {
            Lotto(1, 2, 3, 4, 5, 100)
        }
    }

    test("로또 자동 발급") {
        Lotto(RandomLottoNumberGenerator.generate(), true).isAutoPick shouldBe true
    }

    test("로또 수동 발급") {
        Lotto(1, 2, 3, 4, 5, 6).isAutoPick shouldBe false
        Lotto(LottoNumbers(1, 2, 3, 4, 5, 6)).isAutoPick shouldBe false
    }

    test("로또 숫자는 정렬해서 조회한다.") {
        val lotto = Lotto(2, 1, 6, 5, 4, 3)
        lotto.toString() shouldBe "[1, 2, 3, 4, 5, 6]"
    }

    test("로또 자동 발급시 번호는 랜덤하게 생성된다.") {
        val numberMap = List(100) {}
            .map { Lotto(RandomLottoNumberGenerator.generate()) }
            .map { it.numbers }
            .flatMap { it.numbers }
            .sortedBy { it.number }
            .groupingBy { it }.eachCount()

        numberMap.keys.size shouldBeInRange (6..45)
    }
})
