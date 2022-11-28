package lotto.domain

class LottoManualGenerator : LottoGenerator {
    override fun generateLottoFromNumbers(possibleNumbers: List<LottoNumber>): Lotto {
        val numberList =
            possibleNumbers
                .subList(0, Lotto.LOTTO_NUMBER_COUNT)
                .toMutableSet()

        return Lotto(numberList)
    }

    override fun generateLotto(lottoNumbers: String): Lotto {
        val lottoNumberSet =
            lottoNumbers
                .split(",")
                .mapNotNull {
                    it.trim()
                        .toIntOrNull()
                }.map { LottoNumber(it) }
        return Lotto(lottoNumberSet.toMutableSet())
    }

}
