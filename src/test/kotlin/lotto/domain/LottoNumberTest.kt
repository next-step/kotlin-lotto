package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.comparables.shouldBeEqualComparingTo
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeSameInstanceAs
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoNumberTest {

    @DisplayName("특정 로또 번호로 생성할 수 있다")
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 43, 44, 45])
    fun number(number: Int) {
        LottoNumber.getInstance(number).number shouldBe number
    }

    @DisplayName("로또 번호는 1-45 사이의 값이여야 한다")
    @ParameterizedTest
    @ValueSource(ints = [0, -1, 46, 50, 100])
    fun getInstanceFailIfNotLottoNumber(number: Int) {
        shouldThrow<IllegalArgumentException> { LottoNumber.getInstance(number) }
    }

    @DisplayName("값 객체이다")
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 43, 44, 45])
    fun getInstance(number: Int) {
        val sut = LottoNumber.getInstance(number)
        val other = LottoNumber.getInstance(number)

        assertAll(
            { sut shouldBe other },
            { sut shouldBeSameInstanceAs other },
            { sut shouldBeEqualComparingTo other }
        )
    }

    @DisplayName("로또 번호 값으로 비교할 수 있다")
    @Test
    fun compare() {
        listOf(
            1 to 1,
            2 to 0,
            3 to -1,
        ).map { (compareTo, compareResult) ->
            {
                val sut = LottoNumber.getInstance(2)
                val other = LottoNumber.getInstance(compareTo)

                sut.compareTo(other) shouldBe compareResult
            }
        }
    }
}
