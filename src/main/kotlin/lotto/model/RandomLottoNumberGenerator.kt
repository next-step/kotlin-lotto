package lotto.model

class RandomLottoNumberGenerator : LottoNumberGenerator {

    override fun pick(): LottoNumbers = LottoNumbers(
        LottoNumber.LOTTO_NUMBER_CACHE.shuffled().subList(0, LOTTO_SIZE)
            .sortedBy { it.number }
    )
}
