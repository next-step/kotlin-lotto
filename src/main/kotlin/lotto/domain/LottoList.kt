package lotto.domain

data class LottoList(val lottoList: List<Lotto>) {
    val size = lottoList.size

    operator fun plus(other: List<Lotto>): LottoList {
        return LottoList(lottoList.toMutableList().apply {
            addAll(other)
        })
    }
}
