package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LotteryTest {

    @DisplayName("6개의 로또 번호를 포함해야한다")
    @Test
    fun create() {
        listOf(
            intArrayOf(1, 2),
            intArrayOf(1, 2, 3, 4, 5),
            intArrayOf(1, 2, 3, 4, 5, 6, 7)
        ).map { numbers ->
            shouldThrow<IllegalArgumentException> { Lottery(*numbers) }
        }
    }

    @DisplayName("일치하는 로또 번호 갯수를 구한다")
    @Test
    fun countSameLottoNumbers() {
        val sut = Lottery(1, 2, 3, 4, 5, 6)
        listOf(
            Lottery(1, 12, 13, 14, 15, 16) to 1,
            Lottery(1, 2, 13, 14, 15, 16) to 2,
            Lottery(1, 2, 3, 4, 5, 6) to 6
        ).map { (other, expected) ->
            sut.countSameLottoNumbers(other) shouldBe expected
        }
    }
}
