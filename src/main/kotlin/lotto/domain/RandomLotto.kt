package lotto.domain

class RandomLotto : Lotto(lottoNumbers.shuffled().take(LOTTO_NUMBER_SIZE).sorted().map { it }) {
    companion object {
        private val lottoNumbers = (LottoNumber.LOTTO_MIN_NUMBER..LottoNumber.LOTTO_MAX_NUMBER).toList()
    }
}
