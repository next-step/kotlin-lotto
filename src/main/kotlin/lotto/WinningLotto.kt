package lotto

class WinningLotto(lottoNumbers: Set<LottoNumber> = emptySet(), private val bonusNumber: LottoNumber) {

    init {
        validate(lottoNumbers, bonusNumber)
    }

    private val _lottoNumbers: MutableSet<LottoNumber> = lottoNumbers.toMutableSet()
    val lottoNumber: Set<LottoNumber>
        get() = _lottoNumbers.toSet()

    fun matchCount(lottos: Set<LottoNumber>): Int {
        return lottos.count { _lottoNumbers.contains(it) }
    }

    fun matchBonus(lottos: Set<LottoNumber>): Boolean = matchCount(lottos) == 5 && lottos.contains(bonusNumber)

    private fun validate(lottoNumbers: Set<LottoNumber>, bonusNumber: LottoNumber) {
        require(lottoNumbers.size == MIN_SIZE) { "당첨 번호의 갯수가 잘못 되었습니다." }

        require(!lottoNumbers.contains(bonusNumber)) { "보너스 번호가 중복될 수 없습니다." }
    }

    companion object {
        private const val MIN_SIZE = 6
    }
}
