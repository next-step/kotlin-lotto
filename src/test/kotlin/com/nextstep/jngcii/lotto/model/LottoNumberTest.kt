package com.nextstep.jngcii.lotto.model

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [-2, -1, 0, 46, 1000])
    fun `Lotto 생성시 리스트에 1~45 가 아닌 숫자가 있다면 예외를 발생`(value: Int) {
        assertThrows<IllegalArgumentException>("1~45에 해당하는 숫자로 이루어진 숫자가 아닙니다.") { LottoNumber(value) }
    }
}
