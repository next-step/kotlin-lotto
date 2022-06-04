package lotto

class AutoLottoMaker : LottoMaker {

    override fun make(lottos: List<LottoNumber>): Lotto {
        return lottos
            .shuffled()
            .take(LOTTO_SIZE)
            .sortedBy { it.number }
            .toSet()
            .let(::Lotto)
    }

    companion object {
        private const val LOTTO_SIZE = 6
    }
}
