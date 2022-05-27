package lotto

object CachedLotto {

    private val lotto: MutableList<LottoNumber> = mutableListOf()

    init {
        for (i in 1..45) lotto.add(CachedLottoNumbers.getLottoNumber(1))
    }

    fun get(): HashSet<LottoNumber> {
        return lotto.toList()
            .shuffled()
            .take(6)
            .toHashSet()
    }
}
