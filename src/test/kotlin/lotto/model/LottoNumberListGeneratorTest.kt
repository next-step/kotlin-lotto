package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoNumberListGeneratorTest {

    @Test
    @DisplayName("수동 로또 번호들 생성해 반환하는 로직 테스트")
    fun `check manual lotto generation logic`() {
        // given
        val numbers = listOf("1,10,22,13,14,45")
        val expected = listOf(
            Lotto(
                listOf(
                    LottoNumber(1),
                    LottoNumber(10),
                    LottoNumber(13),
                    LottoNumber(14),
                    LottoNumber(22),
                    LottoNumber(45),
                )
            )
        )

        // when
        val lottoList = LottoNumberListGenerator.generateManualLottoList(numbers)

        // then
        assertThat(lottoList).isEqualTo(expected)
    }

    @Test
    @DisplayName("로또 번호들 생성해 반환하는 로직 테스트")
    fun `check lotto generation logic`() {
        // given
        val price = Price(1000)
        val numbers = listOf(1, 10, 22, 13, 14, 45)
        val expected = listOf(
            Lotto(
                listOf(
                    LottoNumber(1),
                    LottoNumber(10),
                    LottoNumber(13),
                    LottoNumber(14),
                    LottoNumber(22),
                    LottoNumber(45),
                )
            )
        )

        // when
        val lottoList = LottoNumberListGenerator.generateAutoLottoList(price.lottoCount, numbers)

        // then
        assertThat(lottoList).isEqualTo(expected)
        assertThat(lottoList.size).isEqualTo(price.lottoCount)
    }

    @Test
    @DisplayName("로또 생성 번호 확인")
    fun `check lotto numbers`() {
        // given
        val numbers = listOf(1, 10, 22, 13, 14, 45)
        val expected = listOf(
            LottoNumber(1),
            LottoNumber(10),
            LottoNumber(13),
            LottoNumber(14),
            LottoNumber(22),
            LottoNumber(45),
        )

        // when
        val lottoList = LottoNumberListGenerator.generateRandomNumbers(numbers)

        // then
        assertThat(lottoList).isEqualTo(expected)
    }
}
