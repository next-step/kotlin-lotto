package simulator.lotto

import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

internal class NumbersTest {
    @Test
    fun `번호는 오름차순 정렬하여 출력한다`() {
        val numbers = Numbers.of(listOf(6, 2, 3, 4, 5, 1))

        numbers.toString() shouldBe "1,2,3,4,5,6"
    }

    @Test
    fun `번호가 6개가 아닌 경우 Exception을 발생시킨다`() {
        assertThatIllegalArgumentException()
            .isThrownBy { Numbers.of(listOf(6, 2, 3, 4, 5)) }
    }

    @Test
    fun `숫자 리스트로부터 로또번호목록을 생성할 수 있다`() {
        val intList = listOf(1, 2, 3, 4, 5, 6)

        Numbers.of(intList) shouldBe Numbers(intList.map { Number(it) })
    }

    @Test
    fun `로또 번호가 다른 번호와 얼마나 일치하는지 알 수 있다`() {
        val numbers = Numbers.of(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = Numbers.of(listOf(1, 2, 3, 4, 5, 7))

        assertThat(numbers.countOfMatch(winningNumbers)).isEqualTo(5)
    }
}