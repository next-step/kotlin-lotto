package lotto

class AutoLottoMaker : LottoMaker {

    override fun make(lottos: List<LottoNumber>): Lotto {

        val lottoNumbers = lottos
            .shuffled()
            .take(LOTTO_SIZE)
            .sortedBy { it.number }
        return Lotto(lottoNumbers.toSet())
    }

    companion object {
        private const val LOTTO_SIZE = 6
    }
}
