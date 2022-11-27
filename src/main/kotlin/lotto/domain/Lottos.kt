package lotto.domain

class Lottos(val lottoList: List<Lotto>) {
    val count = lottoList.size

    companion object {
        fun of(totalLottoNumbers: List<Set<LottoNumber>>): Lottos {
            val lottoList = totalLottoNumbers.map { lottoNumbers ->
                Lotto(lottoNumbers)
            }

            return Lottos(lottoList)
        }
    }
}
