package lotto.domain

class LottoBundle(val lottos: List<Lotto>) {

    init {
        require(lottos.isNotEmpty()) { "로또는 1개 이상이어야 합니다." }
    }
}
