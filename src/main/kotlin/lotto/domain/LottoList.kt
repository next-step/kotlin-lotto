package lotto.domain

data class LottoList(val lottoList: List<Lotto>) {
    val size = lottoList.size

    operator fun plus(other: LottoList): LottoList {
        return LottoList(lottoList + other.lottoList)
    }
}
