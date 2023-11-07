package lotto.domain

import java.lang.IllegalArgumentException

@JvmInline
value class LottoNumber(val value: Int) {
    init {
        require(value in 1..45) {
            throw IllegalArgumentException("Invalid number: number not in 1..45")
        }
    }
}
