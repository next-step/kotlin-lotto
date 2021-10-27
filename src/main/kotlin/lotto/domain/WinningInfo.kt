package lotto.domain

data class WinningInfo(val winningNumberPackage: LottoNumberPackage) {
    companion object {
        private const val WINNING_NUMBER_SPLIT_DELIMITER = ","

        fun from(input: String): LottoNumberPackage {
            return LottoNumberPackage(getLottoNumbers(input))
        }

        private fun getLottoNumbers(input: String): Set<LottoNumber> {
            return input.split(WINNING_NUMBER_SPLIT_DELIMITER)
                .map { LottoNumber.from(it.trim()) }
                .toSet()
        }
    }
}
