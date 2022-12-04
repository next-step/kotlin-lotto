package lotto.domain

class UserLottos(lottos: List<LottoNumbers> = emptyList()) {
    private val _lottos: MutableList<LottoNumbers> = lottos.toMutableList()
    val lottos: List<LottoNumbers>
        get() = _lottos.toList()

    fun add(lottoNumbers: LottoNumbers): UserLottos {
        _lottos.add(lottoNumbers)
        return UserLottos(this.lottos)
    }

    fun addAll(lottos: List<LottoNumbers>): UserLottos {
        var newUserLottos = UserLottos()
        lottos.forEach {
            newUserLottos = this.add(it)
        }
        return newUserLottos
    }
}
