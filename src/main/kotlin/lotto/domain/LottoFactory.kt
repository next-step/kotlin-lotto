package lotto.domain

object LottoFactory {

    private val LottoNUMBERS = (LottoNumber.MIN_VALUE..LottoNumber.MAX_VALUE).map { LottoNumber(it) }.toList()
    fun generateRandom(): Lotto {
        val numbers = LottoNUMBERS.shuffled().take(Lotto.NUMBERS_SIZE)
        return Lotto(numbers)
    }
}
