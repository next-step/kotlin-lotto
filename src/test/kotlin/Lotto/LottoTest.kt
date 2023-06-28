package Lotto

import Lotto.domain.Lotto
import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `로또 번호 검증 1~45 이외의 번호로 생성 시 예외를 발생시킨다`() {
        shouldThrow<IllegalStateException> {
            Lotto(arrayOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `로또 번호의 갯수가 6개가 아니면 예외를 발생시킨다`() {
        shouldThrow<IllegalStateException> {
            Lotto(arrayOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `로또 번호가 하나라도 중복이면 예외를 발생시킨다`() {
        shouldThrow<IllegalStateException> {
            Lotto(arrayOf(1, 2, 3, 4, 5, 5))
        }
    }
}
