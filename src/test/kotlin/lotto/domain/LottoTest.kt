package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe
import lotto.util.RandomLottoNumberGenerator

class LottoTest : FunSpec({

    test("로또 자동 발급") {
        Lotto.of(RandomLottoNumberGenerator.generate(), true).isAutoPick shouldBe true
    }

    test("로또 수동 발급") {
        Lotto.of(LottoNumbers.of(1, 2, 3, 4, 5, 6)).isAutoPick shouldBe false
    }

    test("로또 숫자는 정렬해서 조회한다.") {
        val lotto = Lotto.of(LottoNumbers.of(2, 1, 6, 5, 4, 3))
        lotto.toString() shouldBe "[1, 2, 3, 4, 5, 6]"
    }

    test("로또 자동 발급시 번호는 랜덤하게 생성된다.") {
        val numberMap = List(100) {}
            .map { Lotto.of(RandomLottoNumberGenerator.generate()) }
            .map { it.numbers }
            .flatMap { it.numbers }
            .sortedBy { it.number }
            .groupingBy { it }.eachCount()

        numberMap.keys.size shouldBeInRange (6..45)
    }
})
