package lotto.domain

object LottoGenerator {

    fun randomTicket(): LottoNumbers {
        return LottoNumber.VALID_LOTTO_NUMBERS
            .shuffled()
            .take(6)
            .let(::LottoNumbers)
    }
}
