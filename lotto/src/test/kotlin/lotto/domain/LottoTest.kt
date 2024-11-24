package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.string.shouldContain
import lotto.domain.enums.LottoCompensationStrategy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoTest {
    @Test
    fun `각 로또마다 6개의 숫자를 가지고 있다`() {
        val lotto = Lotto()

        lotto.values.size shouldBe 6
    }

    @Test
    fun `로또의 숫자들은 무작위로 섞여 있다`() {
        val lotto = Lotto()

        lotto.values.sorted() shouldNotBe lotto.values
    }

    @Test
    fun `로또의 숫자는 1~45 까지 이다`() {
        val lotto = Lotto()

        lotto.values.all { it in 1..45 } shouldBe true
    }

    @Test
    fun `correctCount가 null이면 마킹할 수 있다`() {
        val lotto = Lotto()

        shouldNotThrowAny {
            lotto.markCorrectCount(1)
        }
    }

    @Test
    fun `correctCount가 null이면 markedCorrectCount을 조회할 수 없다`() {
        val lotto = Lotto()

        val exception = shouldThrowExactly<IllegalStateException> {
            lotto.markedCorrectCount
        }
        exception.message shouldContain "마킹이 되지 않은 로또입니다"
    }

    @Test
    fun `correctCount가 null이 아닌 경우 예외가 발생한다`() {
        val lotto = Lotto()
        lotto.markCorrectCount(1)

        val exception = shouldThrowExactly<IllegalStateException> {
            lotto.markCorrectCount(1)
        }
        exception.message shouldContain "이미 당첨 개수 마킹이 완료된 로또입니다"
    }

    @Test
    fun `correctCount가 null이 아니면 markedCorrectCount을 조회할 수 있다`() {
        val lotto = Lotto()
        lotto.markCorrectCount(1)

        shouldNotThrowAny {
            lotto.markedCorrectCount
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2])
    fun `맞춘 개수가 3개 미만인 경우 당첨금이 0원이다`(correctCount: Int) {
        val lotto = Lotto()
        lotto.markCorrectCount(correctCount)

        lotto.markedCorrectCount shouldBe correctCount
        lotto.compensation shouldBe 0
    }

    @ParameterizedTest
    @ValueSource(ints = [3, 4, 5, 6])
    fun `맞춘 개수가 3개 이상인 경우 당첨금이 존재한다`(correctCount: Int) {
        val lotto = Lotto()
        lotto.markCorrectCount(correctCount)

        lotto.markedCorrectCount shouldBe correctCount
        lotto.compensation shouldBe LottoCompensationStrategy.findByCorrectCount(correctCount)?.compensation
    }
}
