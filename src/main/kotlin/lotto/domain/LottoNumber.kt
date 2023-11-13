package lotto.domain

import kotlin.random.Random

data class LottoNumber(val number: Int) {
    init {
        require(number in (1..45)) {
            "numbers should be between 1 to 45: now is $number"
        }
    }

    companion object {
        fun randomNumber(exclude: List<LottoNumber>): LottoNumber {
            var number: Int
            do {
                number = Random.nextInt(45) + 1
            } while (exclude.contains(LottoNumber(number)))
            return LottoNumber(number)
        }
    }
}
