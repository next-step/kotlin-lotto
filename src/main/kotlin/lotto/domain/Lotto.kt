package lotto.domain

private fun List<LottoNumber>.isValidNumberCount() = this.size != Lotto.COUNT_OF_NUMBER

private fun List<LottoNumber>.isDuplicated() = this.size != this.distinct().size

class Lotto private constructor(
    val lottoNumbers: List<LottoNumber>
) {

    companion object {
        const val COUNT_OF_NUMBER = 6
        const val PRICE = 1000

        fun create(lottoNumbers: List<LottoNumber>): Lotto {
            validateNumbers(lottoNumbers)

            return Lotto(lottoNumbers.sortedBy { it.number })
        }

        private fun validateNumbers(lottoNumbers: List<LottoNumber>) {
            if (lottoNumbers.isValidNumberCount()) {
                throw IllegalArgumentException("로또 숫자가 6개가 아닌 로또는 생성할 수 없습니다.")
            }

            if (lottoNumbers.isDuplicated()) {
                throw IllegalArgumentException("로또 숫자는 중복될 수 없습니다.")
            }
        }
    }
}
