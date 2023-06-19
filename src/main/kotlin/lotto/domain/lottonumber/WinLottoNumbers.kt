package lotto.domain.lottonumber

data class WinLottoNumbers(
    val lottoNumbers: LottoNumbers,
    val bonusNumber: LottoNumber,
) {

    init {
        require(bonusNumber !in lottoNumbers) {
            "bonus number can not be duplicated with lotto numbers"
        }
    }
}
