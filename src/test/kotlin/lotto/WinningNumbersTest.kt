package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.inspectors.shouldForAll
import io.kotest.matchers.shouldBe
import lotto.model.WinningNumbers
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class WinningNumbersTest {
    @Test
    @DisplayName("6개의 로또 번호와 1개의 보너스 번호로 WinningNumbers 객체를 생성한다")
    fun `create WinningNumbers with valid numbers and bonus`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val winningNumbersObj = WinningNumbers.from(winningNumbers, bonusNumber)

        winningNumbersObj.winnigLottoNumbers.size shouldBe 6
        winningNumbersObj.winnigLottoNumbers.shouldForAll { it.num in 1..45 }
        winningNumbersObj.bonusNumber.num shouldBe 7
    }

    @Test
    @DisplayName("WinningNumbers 객체 생성 시 로또 번호가 6개보다 적으면 예외를 던진다")
    fun `throw exception when winning numbers are less than 6`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5)
        val bonusNumber = 6

        shouldThrow<IllegalArgumentException> {
            WinningNumbers.from(winningNumbers, bonusNumber)
        }.message shouldBe "당첨 로또 번호는 정확히 6개여야 합니다."
    }

    @Test
    @DisplayName("WinningNumbers 객체 생성 시 로또 번호가 6개보다 많으면 예외를 던진다")
    fun `throw exception when winning numbers are more than 6`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6, 7)
        val bonusNumber = 8

        shouldThrow<IllegalArgumentException> {
            WinningNumbers.from(winningNumbers, bonusNumber)
        }.message shouldBe "당첨 로또 번호는 정확히 6개여야 합니다."
    }

    @Test
    @DisplayName("WinningNumbers 객체 생성 시 로또 번호에 중복이 있으면 예외를 던진다")
    fun `throw exception when winning numbers have duplicates`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 5)
        val bonusNumber = 6

        shouldThrow<IllegalArgumentException> {
            WinningNumbers.from(winningNumbers, bonusNumber)
        }.message shouldBe "당첨 로또 번호는 중복될 수 없습니다."
    }

    @Test
    @DisplayName("WinningNumbers 객체 생성 시 보너스 번호가 당첨 번호에 포함되면 예외를 던진다")
    fun `throw exception when bonus number is in winning numbers`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 6

        shouldThrow<IllegalArgumentException> {
            WinningNumbers.from(winningNumbers, bonusNumber)
        }.message shouldBe "보너스 번호는 당첨 로또 번호와 중복될 수 없습니다."
    }

    @Test
    @DisplayName("WinningNumbers 객체 생성 시 보너스 번호가 유효한 범위를 벗어나면 예외를 던진다")
    fun `throw exception when bonus number is out of valid range`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 46

        shouldThrow<IllegalArgumentException> {
            WinningNumbers.from(winningNumbers, bonusNumber)
        }.message shouldBe "로또 숫자 범위는 1에서 45까지 입니다."
    }

    @Test
    @DisplayName("WinningNumbers 객체 생성 시 로또 번호 리스트에 1~45 범위를 벗어난 번호가 있으면 예외를 던진다")
    fun `throw exception when winning numbers have out of range numbers`() {
        // Assuming LottoNumber.from(number) throws IllegalArgumentException for invalid numbers
        val winningNumbers = listOf(1, 2, 3, 4, 5, 46) // 46 is invalid
        val bonusNumber = 7

        shouldThrow<IllegalArgumentException> {
            WinningNumbers.from(winningNumbers, bonusNumber)
        }.message shouldBe "로또 숫자 범위는 1에서 45까지 입니다."
    }
}
