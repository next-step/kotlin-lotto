package lotto.domain

class AutoLottoGenerator : LottoGenerator {

    override fun generate(amount: Int): List<Lotto> {
        val result = mutableListOf<Lotto>()
        repeat(amount) {
            val randomNumbers = (LottoNumber.LOWER_LIMIT..LottoNumber.UPPER_LIMIT).toList().shuffled().take(Lotto.NUM_OF_LOTTO)
            val lottoNumbers = randomNumbers.map { LottoNumber(it) }
            result += Lotto(lottoNumbers)
        }
        return result
    }
}