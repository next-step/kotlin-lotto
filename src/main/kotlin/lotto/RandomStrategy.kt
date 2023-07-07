package lotto

class RandomStrategy : LottoNumbersGenerateStrategy {
    override fun generate(): LottoNumbers {
        val randomNumbers = LottoNumber.LOTTO_NUMBER_POOL.shuffled().take(LottoNumbers.SIZE)

        return LottoNumbers(randomNumbers)
    }
}
