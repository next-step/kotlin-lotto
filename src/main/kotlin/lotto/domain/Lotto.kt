package lotto.domain

class Lotto(val lottoNumbers: LottoNumbers) {

    fun countMatchNumbers(previousLottoNumbers: LottoNumbers): Int =
        previousLottoNumbers.numbers.count(lottoNumbers.numbers::contains)
}
