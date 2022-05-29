package lotto

class AutoLottoMaker : LottoMaker {

    private val lotto: MutableList<LottoNumber> = mutableListOf()

    init {
        for (i in LOTTO_NUMBER_START..LOTTO_NUMBER_END) lotto.add(CachedLottoNumbers.getLottoNumber(i))
    }

    override fun make(): Lotto {
        return Lotto(get().toSet())
    }

    private fun get(): List<LottoNumber> {
        return lotto.toList()
            .shuffled()
            .take(LOTTO_SIZE)
            .sortedBy { it.number }
    }

    companion object {
        private const val LOTTO_NUMBER_START = 1
        private const val LOTTO_NUMBER_END = 45
        private const val LOTTO_SIZE = 6
    }
}
