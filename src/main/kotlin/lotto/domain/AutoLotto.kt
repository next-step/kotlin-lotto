package lotto.domain

class AutoLotto : Lotto {
    override val lottoNumbers: LottoNumbers = run {
        val list = (1..45).shuffled().take(6).sorted()
        LottoNumbers(*list.toIntArray())
    }
}
