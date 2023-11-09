package autolotto.vo

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.beInRange
import io.kotest.matchers.shouldBe

class LottoTest : FunSpec({
    test("로또는 6개의 번호를 갖는다. ") {
        // Given
        val lotto = Lotto()

        // When
        val numbers = lotto.numbers

        // Then
        numbers.size shouldBe 6
    }

    test("로또 1장의 숫자는 1~45의 숫자다") {
        // Given
        val lotto = Lotto()

        // When
        val numbers = lotto.numbers

        // Then
        numbers.forEach {
            it.number shouldBe beInRange(1..45)
        }
    }

    test("로또 1장의 숫자는 중복되지 않는다") {
        // Given
        val lotto = Lotto()

        // When
        val numbers = lotto.numbers

        // Then
        numbers.distinct().size shouldBe 6
    }


    test("로또 1장의 숫자는 오름차순으로 정렬되어 있다") {
        // Given
        val lotto = Lotto()

        // When
        val numbers = lotto.numbers

        // Then
        val sortedNumbers = numbers.map { it.number }.sorted()
        numbers.map { it.number } shouldBe sortedNumbers
    }
})
