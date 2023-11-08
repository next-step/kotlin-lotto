package lotto.domain

class AutoLotto : Lotto {
    override val lottoNumbers: LottoNumbers = run {
        val list = (1..49).shuffled().take(6).sorted()
        LottoNumbers(*list.toIntArray())
    }
}
