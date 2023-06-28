package Lotto.domain

interface LottoGenerator {
    fun createLotto(): Lotto
}

class AutoLottoGenerator : LottoGenerator {
    override fun createLotto(): Lotto {
        return Lotto(getRandomLottoNumbers())
    }

    private fun getRandomLottoNumbers(): List<LottoNumber> {
        return LottoNumber.NUMBERS.shuffled()
            .subList(0, 6)
            .sorted()
            .map { LottoNumber(it) }
    }
}
