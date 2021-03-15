package lotto.data

import java.lang.IllegalArgumentException

class LottoNumber private constructor(
    val value: Int
) {
    init {
        require(value in 1..45) { "로또 숫자는 1에서 45사이의 숫자여야 합니다." }
    }

    companion object {
        const val LOTTERY_MIN_NUMBER = 1
        const val LOTTERY_MAX_NUMBER = 45
        private val NUMBERS: Map<Int, LottoNumber> = (LOTTERY_MIN_NUMBER..LOTTERY_MAX_NUMBER).associateWith(::LottoNumber)

        fun from(number: Int): LottoNumber = NUMBERS[number] ?: throw IllegalArgumentException("잘못된 숫자가 들어왔습니다.")
    }
}
