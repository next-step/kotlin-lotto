package lotto.domain

class AutoLotto : Lotto {
    override val lottoNumbers: LottoNumbers = LottoNumbers.random()
}
