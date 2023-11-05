package lotto.model

data class Game(
    val lottoNumbers: LinkedHashSet<LottoNumber>,
) {
    constructor(lottoNumbers: Set<LottoNumber>) : this(LinkedHashSet(lottoNumbers))
}
