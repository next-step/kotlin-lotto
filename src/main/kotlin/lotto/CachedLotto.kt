package lotto

object CachedLotto {

    private val lotto: MutableList<LottoNumber> = mutableListOf()

    init {
        for (i in 1..45) lotto.add(CachedLottoNumbers.getLottoNumber(i))
    }

    fun get(): List<LottoNumber> {
        return lotto.toList()
            .shuffled()
            .take(6)
            .sortedBy { it.number }
    }
}
