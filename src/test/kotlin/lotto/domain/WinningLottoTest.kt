package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class WinningLottoTest {
    @Test
    internal fun `당첨 로또는 6개의 당첨 번호와 1개의 보너스 번호를 가진다`() {
        val sut = WinningLotto(
            winningNumbers = setOf(1, 2, 3, 4, 5, 6).toLottoNumberSet(),
            bonusNumber = LottoNumber.from(7),
        )
        sut.winningNumbers shouldContainExactly setOf(1, 2, 3, 4, 5, 6).toLottoNumberSet()
        sut.bonusNumber shouldBe LottoNumber.from(7)
    }

    @Test
    internal fun `당첨 로또가 7개의 번호를 가지지 않으면 예외가 발생한다`() {
        shouldThrow<IllegalArgumentException> {
            WinningLotto(
                winningNumbers = setOf(1, 2, 3, 4, 5).toLottoNumberSet(),
                bonusNumber = LottoNumber.from(6)
            )
        }
    }

    @Test
    internal fun `당첨 로또 번호가 1부터 45사이의 값이 아닌 경우 예외가 발생한다`() {
        shouldThrow<IllegalArgumentException> {
            WinningLotto(
                winningNumbers = setOf(-1, 0, 1, 20, 45, 46).toLottoNumberSet(),
                bonusNumber = LottoNumber.from(47)
            )
        }
    }

    @Test
    internal fun `당첨 로또 번호가 서로 중복되는 경우 예외가 발생한다`() {
        shouldThrow<IllegalArgumentException> {
            WinningLotto(
                winningNumbers = setOf(1, 3, 17, 20, 40, 45).toLottoNumberSet(),
                bonusNumber = LottoNumber.from(3)
            )
        }
    }
}
