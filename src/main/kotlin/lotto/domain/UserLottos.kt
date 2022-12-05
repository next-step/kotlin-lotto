package lotto.domain

class UserLottos(val lottos: List<LottoNumbers> = emptyList()) {
    fun add(lottoNumbers: LottoNumbers): UserLottos {
        return UserLottos(lottos + listOf(lottoNumbers))
    }

    fun addAll(lottos: List<LottoNumbers>): UserLottos {
        return UserLottos(this.lottos + lottos)
    }
}
