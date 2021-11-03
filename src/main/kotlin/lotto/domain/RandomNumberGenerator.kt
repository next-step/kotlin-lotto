package lotto.domain

object RandomNumberGenerator {

    fun nextSix(): LottoNumbers {
        return LottoNumber.VALID_LOTTO_NUMBERS
            .shuffled()
            .take(6)
            .let(::LottoNumbers)
    }
}
