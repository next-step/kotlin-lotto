package com.nextstep.jngcii.lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

class BonusNumberTest {
    @ParameterizedTest
    @MethodSource("validBonusNumber")
    fun `보너스볼 생성 성공 테스트`(lastWeekNumbers: List<Int>, number: Int) {
        val lastWeekLotto = Lotto(
            lottoNumbers = lastWeekNumbers.map { LottoNumber(it) }
        )
        val bonusNumber: BonusNumber = BonusNumber(number, lastWeekLotto)

        assertThat(bonusNumber.value).isEqualTo(number)
    }

    @ParameterizedTest
    @ValueSource(
        ints = [
            -1, 0, 46, 100
        ]
    )
    fun `보너스볼 생성 실패 테스트(범위 이상)`(number: Int) {
        val lastWeekLotto = Lotto(
            lottoNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }
        )

        assertThrows<IllegalArgumentException>("1~45에 해당하는 숫자로 이루어진 숫자가 아닙니다.") {
            BonusNumber(number, lastWeekLotto)
        }
    }

    @ParameterizedTest
    @ValueSource(
        ints = [
            1, 2, 3, 4, 5, 6
        ]
    )
    fun `보너스볼 생성 실패 테스트(이미 존재)`(number: Int) {
        val lastWeekLotto = Lotto(
            lottoNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }
        )

        assertThrows<IllegalArgumentException>("보너스넘버는 지난주 로또넘버 6개에 포함될 수 없습니다.") {
            BonusNumber(number, lastWeekLotto)
        }
    }

    companion object {
        @JvmStatic
        fun validBonusNumber() = listOf(
            Arguments.of(listOf(1, 2, 3, 4, 5, 6), 7),
            Arguments.of(listOf(1, 2, 3, 4, 6, 7), 5),
            Arguments.of(listOf(1, 2, 3, 4, 5, 6), 45),
            Arguments.of(listOf(45, 44, 43, 41, 40, 39), 42),
        )
    }
}
