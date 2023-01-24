package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LottoNumbersTest {
    @Test
    @DisplayName("로또번호가 6개를 넘어가면 에러를 뱉는다")
    fun `sut lottoNumbers should be 6 digits`() {
        // Arrange
        val lottoNumbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6),
            LottoNumber(7),
        )

        // Act
        val actual = assertThrows<IllegalArgumentException> { LottoNumbers(value = lottoNumbers) }

        // Assert
        assertThat(actual.message).isEqualTo("로또는 6자리 입니다.")
    }

    @Test
    @DisplayName("로또는 중복되지 않는 6자리가 아니면 에러를 뱉는다")
    fun `sut lottoNumbers should not be a duplicate value`() {
        // Arrange
        val lottoNumbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(5),
        )

        // Act
        val actual = assertThrows<IllegalArgumentException> { LottoNumbers(value = lottoNumbers) }

        // Assert
        assertThat(actual.message).isEqualTo("로또는 중복되지 않는 6자리 입니다.")
    }

    @Test
    @DisplayName("일치하는 번호가 몇개인지 찾아준다")
    fun `sut countMatchNumber`() {
        // Arrange
        val lottoNumbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6),
        )

        val matchLottoNumbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(10),
            LottoNumber(11),
            LottoNumber(12),
        )

        // Act
        val actual = LottoNumbers(value = lottoNumbers).countMatchNumber(matchLottoNumbers)

        // Assert
        assertThat(actual).isEqualTo(3)
    }

    @Test
    @DisplayName("해당 번호를 갖고있는지 알려준다")
    fun `sut isContainNumber`() {
        // Arrange
        val lottoNumbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6),
        )

        val containedLottoNumber = LottoNumber(1)

        // Act
        val actual = LottoNumbers(value = lottoNumbers).isContainNumber(containedLottoNumber)

        // Assert
        assertThat(actual).isTrue
    }
}
