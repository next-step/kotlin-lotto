package lotto.domain

data class Lottos(
    val lottoNumbers: List<Lotto>
) {
    fun size() = lottoNumbers.size
}
