package lotto

class ManualLottoMaker : LottoMaker {
    override fun make(lottos: List<LottoNumber>): Lotto {
        validate(lottos)
        val lottoNumbers = lottos.sortedBy { it.number }
        return Lotto(lottoNumbers.toSet())
    }

    private fun validate(lottos: List<LottoNumber>) {
        require(lottos.size == LOTTO_SIZE) { "유효하지 않은 로또 입니다." }
    }

    companion object {
        private const val LOTTO_SIZE = 6
    }
}
