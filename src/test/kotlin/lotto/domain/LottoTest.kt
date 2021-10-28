package lotto.domain

import lotto.exception.IllegalLottoException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class LottoTest {
    @TestFactory
    fun `잘못된 로또번호 갯수`() = listOf(
        emptyList(),
        (1..5).toList(),
        (1..7).toList(),
        (1..45).toList()
    ).map {
        DynamicTest.dynamicTest("로또는 6개의 번호를 가져야 합니다. $it") {
            assertThatExceptionOfType(IllegalLottoException::class.java)
                .isThrownBy { Lotto.from(it) }
        }
    }

    @TestFactory
    fun equals() = listOf(
        (1..6).toList(),
        (21..26).toList(),
        (40..45).toList()
    ).map {
        DynamicTest.dynamicTest("로또가 같으면 같다고 인식되어야 한다. $it") {
            assertThat(Lotto(it.map { number -> LottoNumber(number) }))
                .isEqualTo(Lotto.from(it))
        }
    }
}
